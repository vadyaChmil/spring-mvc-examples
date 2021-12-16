package com.luxoft.spring.mvc.example11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    // TODO: open this url in your browser

    @RequestMapping("/index")                   // this handler shows index page
    public String index() {
        return "index";                         // shows index.html
    }

    // TODO: open this url in your browser

    @RequestMapping("/indexAndNpe")             // produces exception and does not show index page
    public String indexWithNpe() {
        System.out.println(
            ((Object) null).toString()          // NullPointerException (NPE)
        );
        return "index";
    }

    @ExceptionHandler(NullPointerException.class)   // this method handles only NullPointerException
    public String handleNpe(
        NullPointerException e
    ) {
        return "npe";                           // shows 'npe.html'
    }

    @RequestMapping("/indexEx")                 // produces exception, TODO: see GlobalExceptionHandler
    public String indexWithOtherException() throws Exception {
        throw new Exception("This is exception details");
    }
}
