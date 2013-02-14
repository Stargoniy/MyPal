package com.in6k.mypal.controller;

import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class AdminController {

    private boolean isAdminLogged = false;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin")
    public String adminLogged(ModelMap model) {
        return "/security/login";
    }

    @RequestMapping("/admin/page")
    public String showAdminPage(HttpServletRequest request) {
        HttpSession session = request.getSession();

        isAdminLogged = session.getAttribute("Admin") != null;

        if (isAdminLogged) {
            return "/admin/admin";
        }

        return "/security/login";
    }

    @RequestMapping("/users")
    public String showRegistredUsers(ModelMap model) {

        if (isAdminLogged) {
            model.addAttribute("userlist", UserDao.list());

            return "/user/list";
        }

        return "/security/login";
    }

    @RequestMapping(value = "/user/ban/{id}", method = RequestMethod.GET)
    public String BanUser ( @PathVariable int id, HttpServletResponse response) throws IOException {
        if (isAdminLogged) {
            adminService.banUser(id);

            response.sendRedirect("/users");
        }

        return "/security/login";
    }

    @RequestMapping(value = "/user/unban/{id}", method = RequestMethod.GET)
    public String UnBanUser ( @PathVariable int id, HttpServletResponse response) throws IOException {
        if (isAdminLogged) {
            adminService.unBanUser(id);

            response.sendRedirect("/users");
        }

        return "/security/login";
    }

    @RequestMapping(value = "users/{id}/transactions", method = RequestMethod.GET)
    public String showTransactionsOfUser(ModelMap model, @PathVariable int id) {
        if (isAdminLogged) {
            model.addAttribute("transactions", adminService.transactionsForUserById(id));

            return "admin/transactionlist";
        }

        return "/security/login";
    }

    @RequestMapping(value = "/admin/transaction/list")
    public String showAllTransactions(ModelMap model) throws IOException, SQLException {

        if (isAdminLogged) {
            model.addAttribute("transactions", adminService.showAllTransactions());

            return "/admin/transactionlist";
        }

        return "/security/login";
    }

    @RequestMapping(value = "/transaction/{id}/cancel", method = RequestMethod.GET)
    public String cancelTransaction(@PathVariable int id, HttpServletResponse response) throws SQLException, IOException {

        if (isAdminLogged) {
            adminService.cancelTransaction(id);

            response.sendRedirect("/admin/transaction/list");
        }

        return "/security/login";
    }

    @RequestMapping(value = "/transaction/{id}/restore", method = RequestMethod.GET)
    public String restoreTransaction(@PathVariable int id, HttpServletResponse response) throws SQLException, IOException {

        if (isAdminLogged) {
            adminService.restoreTransaction(id);

            response.sendRedirect("/admin/transaction/list");
        }

        return "/security/login";
    }
}