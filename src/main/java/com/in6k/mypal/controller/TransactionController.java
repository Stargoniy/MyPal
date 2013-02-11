package com.in6k.mypal.controller;

import com.in6k.mypal.dao.TransactionDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {

    @RequestMapping(value = "/create", method = RequestMethod.GET )
    public String creationForm(@RequestParam("debit") String debit, @RequestParam("credit") String credit) {
        /*Integer debitId = new Integer(debit);
        Integer creditId = new Integer(credit);

        User user = null;

            user = UserDAO.getById(debitId);


        Account acc = new Account();
        acc.setName(request.getParameter("name"));
        acc.setUser(user);
        acc.setTypeId(25);

        AccountDAOimpl.save(acc);*/


        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST )
    public String create(@RequestParam("debit") String debit, @RequestParam("credit") String credit) {
        /*Integer debitId = new Integer(debit);
        Integer creditId = new Integer(credit);

        User user = null;

            user = UserDAO.getById(debitId);


        Account acc = new Account();
        acc.setName(request.getParameter("name"));
        acc.setUser(user);
        acc.setTypeId(25);

        AccountDAOimpl.save(acc);*/


        return "create";
    }

    @RequestMapping(value = "/list")
    public String list() {
        return "list";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") int id) throws SQLException {

        TransactionDAO.delete(id);
        return "list";
    }

}
