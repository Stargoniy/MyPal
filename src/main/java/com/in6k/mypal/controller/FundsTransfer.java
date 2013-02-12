package com.in6k.mypal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/founds")
public class FundsTransfer {

    @RequestMapping(value = "/transfer")
    public String addTransfer() {
        return "founds_transfer/foundsTransfer";
    }
}
