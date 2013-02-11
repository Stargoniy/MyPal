package com.in6k.mypal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {

    @RequestMapping(value = "/createtransaction")
    public String create(@RequestParam("userId") String id) {

        return "create";
    }

    @RequestMapping(value = "/transactions")
    public String list() {
        return "list";
    }

    @RequestMapping(value = "/deletetransactions")
    public String delete() {
        return "list";
    }

}
