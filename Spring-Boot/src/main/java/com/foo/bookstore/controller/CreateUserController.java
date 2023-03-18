package com.foo.bookstore.controller;

import com.foo.bookstore.repository.CreateUserRepository;
import com.foo.bookstore.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/createuser")
public class CreateUserController {

    @Autowired
    CreateUserRepository createUserRepository;

    @CrossOrigin
    @GetMapping("add")
    public boolean createUser(@RequestParam String userName, @RequestParam String passWord){
        return createUserRepository.createUser(userName, passWord);
    }


}
