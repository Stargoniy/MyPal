package com.in6k.mypal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/funds")
public class FundsTransfer {
    @RequestMapping(value = "/transfer")
    public void addTransfer() {

    }
}
