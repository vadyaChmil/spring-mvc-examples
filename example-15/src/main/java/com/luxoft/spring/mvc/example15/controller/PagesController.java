package com.luxoft.spring.mvc.example15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PagesController {

    private final List<User> users = new ArrayList<>();

    public PagesController() {
        users.add(new User(0, "Mike", 22));
        users.add(new User(1, "Don", 21));
        users.add(new User(2, "Leo", 20));
    }

    // TODO: open it in your browser

    @RequestMapping("/users")
    public String viewOrder(Model model) {
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String editUser(
        @RequestParam("id") int id,
        Model model
    ) {
        model.addAttribute("user", users.get(id));
        return "user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String editUserSubmit(
        @RequestParam("id") int id,
        @RequestParam("name") String name,
        @RequestParam("age") int age,
        Model model
    ) {
        users.get(id).setName(name);
        users.get(id).setAge(age);

        model.addAttribute("user", users.get(id));
        return "redirect:/users";
    }
}
