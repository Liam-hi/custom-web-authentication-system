package com.foo.bookstore.controller;

import com.foo.bookstore.repository.BookRepository;
import com.foo.bookstore.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    LoginRepository loginRepository;

    @CrossOrigin
    @GetMapping("create")
    public boolean checkLogin(@RequestParam String userName, @RequestParam String passWord){
        return loginRepository.checkLogin(userName, passWord);
    }
}
