package com.mypal.controller;

import com.mypal.dao.TransactionDao;
import com.mypal.dao.UserDao;
import com.mypal.domain.User;
import com.mypal.service.CreditCard.IncreaseBalanсeService;
import com.mypal.service.CreditCard.ValidCreditCardService;
import com.mypal.service.ValidUser.SessionValidService;
import com.mypal.service.TransactionService;
import com.mypal.service.ValidUser.ValidUserAndRedirecttoLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {
    private final String LOGGED_USER = "LoggedUser";

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String creationForm(ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User userSession = (User) session.getAttribute(LOGGED_USER);

        if (null == userSession || userSession.getActive() == false) {
            return "security/accessdenied";
        }

        model.addAttribute("sess", userSession);
        model.addAttribute("balance", UserDao.getBalance(userSession));

        return "transaction/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(HttpServletRequest request, ModelMap model) throws IOException {
        HttpSession session = request.getSession();
        boolean transactionComplete = TransactionService.create((User) session.getAttribute(LOGGED_USER), request.getParameter("debit"), request.getParameter("sum"));
        request.setAttribute("transactionComplete", transactionComplete);
        if (transactionComplete) {
            request.setAttribute("transactionComplete", transactionComplete);
            return "redirect:/transaction/history";
        }
        else {
            User userSession = (User) session.getAttribute(LOGGED_USER);
            model.addAttribute("sess", userSession);
            model.addAttribute("balance", UserDao.getBalance(userSession));
            return "transaction/create";
        }
    }

    @RequestMapping(value = "/history")
    public String history(ModelMap model, HttpServletRequest request) throws IOException, SQLException {
        HttpSession session = request.getSession();
        User userSession = (User) session.getAttribute(LOGGED_USER);

        if (userSession == null || userSession.getActive() == false) {
            return "security/accessdenied";
        }
        model.addAttribute("sess", userSession);
        model.addAttribute("balance", UserDao.getBalance(userSession));
        model.addAttribute("transactions", TransactionDao.findAllForUser(userSession));

        return "transaction/history";
    }

    @RequestMapping(value = "/create/creditfromcard", method = RequestMethod.POST)
    public String createTransactionDebetFromCard(HttpServletRequest request,
                                                 @RequestParam("card_number") String cardNumber,
                                                 @RequestParam("expiry_date_month") String expiryDateMonth,
                                                 @RequestParam("name_on_card") String nameOnCard,
                                                 @RequestParam("sum") String sum,
                                                 @RequestParam("cvv") String cvv, ModelMap model) throws IOException {

        HttpSession session = request.getSession();
        ValidCreditCardService isValidCard = new ValidCreditCardService();
        List validateCardInfo = isValidCard.validateCardInfo(cardNumber, sum, nameOnCard, cvv, expiryDateMonth);

        if ((validateCardInfo.size()>0)){
            model.addAttribute("validateCardInfo", validateCardInfo);
            userInfoForView(model, session);
            return "creditcard/create";
        }

        boolean fromCard = true;

        IncreaseBalanсeService.moneyFromCreditCard(cardNumber, sum, SessionValidService.ValidUser(session).getId(), fromCard);

        userInfoForView(model, session);
        return "creditcard/create";
    }

    @RequestMapping(value = "/create/creditfromcard", method = RequestMethod.GET)
    public String creationFormDebetFromCard(HttpServletRequest request, ModelMap model){

        ValidUserAndRedirecttoLogin validUserAndRedirecttoLogin = new ValidUserAndRedirecttoLogin(request, model).invoke();

        if (validUserAndRedirecttoLogin.is()) return "security/accessdenied";
        HttpSession session = validUserAndRedirecttoLogin.getSession();

        userInfoForView(model, session);
        return "creditcard/create";
    }

    @RequestMapping(value = "/create/debitedtothecard", method = RequestMethod.GET)
    public String creationDebitedToTheCard(HttpServletRequest request, ModelMap model){

        ValidUserAndRedirecttoLogin validUserAndRedirecttoLogin = new ValidUserAndRedirecttoLogin(request, model).invoke();

        if (validUserAndRedirecttoLogin.is()) return "security/accessdenied";
        HttpSession session = validUserAndRedirecttoLogin.getSession();

        userInfoForView(model, session);
        return "creditcard/transfer";
    }

    @RequestMapping(value = "/create/debitedtothecard", method = RequestMethod.POST)
    public String createTransactionDebitedToTheCard(HttpServletRequest request,
                                                    @RequestParam("card_number") String cardNumber,
                                                    @RequestParam("sum") String sum, ModelMap model){
        HttpSession session = request.getSession();
        ValidCreditCardService isValidCard = new ValidCreditCardService();
        List validateCardInfo = isValidCard.validateCardInfo(cardNumber, sum, "cardName", "cvv", "cardMonth");

        if ((validateCardInfo.contains("cardNumber")) || (validateCardInfo.contains("sum"))){
            model.addAttribute("validateCardInfo", validateCardInfo);
            userInfoForView(model, session);
            return "creditcard/transfer";
        }

        boolean fromCard = false;

        IncreaseBalanсeService.moneyFromCreditCard(cardNumber, sum, SessionValidService.ValidUser(session).getId(), fromCard);

        userInfoForView(model, session);
        return "creditcard/transfer";
    }

    private void userInfoForView(ModelMap model, HttpSession session) {
        User userSession = (User) session.getAttribute(LOGGED_USER);
        model.addAttribute("sess", userSession);
        model.addAttribute("balance", UserDao.getBalance(userSession));
    }

}
