package com.luxoft.spring.mvc.example16.controller;

import com.luxoft.spring.mvc.example16.domain.User;
import com.luxoft.spring.mvc.example16.domain.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PagesController {

    private final UsersRepository repo;

    @Autowired
    public PagesController(UsersRepository repo) {
        this.repo = repo;
    }

    @ModelAttribute("users")
    public List<User> getAllUsers() {
        return repo.getAll();
    }

    @RequestMapping("/users")
    public String viewOrder(Model model) {
        // TODO: why it works?
        //model.addAttribute("users", repo.getAll());
        return "users";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String editUser(
        @RequestParam("id") int id,
        Model model
    ) {
        model.addAttribute("user", repo.get(id));
        return "user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String editUserSubmit(
        @RequestParam("id") int id,
        @RequestParam("name") String name,
        @RequestParam("age") int age,
        Model model
    ) {
        repo.get(id).setName(name);
        repo.get(id).setAge(age);

        model.addAttribute("user", repo.get(id));
        return "redirect:/users";
    }
}
