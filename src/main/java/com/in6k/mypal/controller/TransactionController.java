package com.in6k.mypal.controller;

import com.in6k.mypal.dao.TransactionDAO;
import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.Transaction;
import com.in6k.mypal.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String creationForm(ModelMap model) {
        User user = new User();
        user.setEmail("petrov@gmail.com");

        model.addAttribute(user);
        return "transaction/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(HttpServletRequest request) throws IOException {
        Transaction transaction = new Transaction();
        transaction.setDebit(UserDao.getByEmail(request.getParameter("debit")));
        transaction.setCredit(UserDao.getById(Integer.parseInt(request.getParameter("credit"))));
        transaction.setSum(Double.parseDouble(request.getParameter("sum")));
        TransactionDAO.create(transaction);

        return "transaction/list";
    }

    @RequestMapping(value = "/list")
    public String list(ModelMap model) throws IOException, SQLException {

        Collection<Transaction> transactions = null;

        transactions = TransactionDAO.findAllForUser(UserDao.getById(2));

        model.addAttribute("transactions", transactions);

        //request.getRequestDispatcher("/Transaction.jsp").include(request, response);

        return "transaction/list";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") int id) throws SQLException {

        TransactionDAO.delete(id);
        return "transaction/list";
    }

}
