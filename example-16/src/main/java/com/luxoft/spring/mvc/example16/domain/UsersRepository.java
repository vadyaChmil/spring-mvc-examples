package com.luxoft.spring.mvc.example16.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// TODO: uncomment it
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;

@Service
// TODO: uncomment one and see difference
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UsersRepository {

    private final List<User> users = new ArrayList<>();

    public UsersRepository() {
        users.add(new User(0, "Mike", 22));
        users.add(new User(1, "Don", 21));
        users.add(new User(2, "Leo", 20));
    }

    public User get(int id) {
        return users.get(id);
    }

    public List<User> getAll() {
        return users;
    }
}
