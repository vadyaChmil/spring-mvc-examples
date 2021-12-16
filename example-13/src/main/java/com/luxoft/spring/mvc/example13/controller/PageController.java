package com.luxoft.spring.mvc.example13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    // TODO: see 'index.html' and open this URL in browser

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
