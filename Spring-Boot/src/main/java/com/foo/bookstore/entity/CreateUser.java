package com.foo.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateUser {

    private int id;
    private String username;
    private String password;
    private String salt;

}
