package com.foo.bookstore.implementation;

import com.foo.bookstore.repository.CreateUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CreateUserImplementation implements CreateUserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean createUser(String userName, String passWord){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_user");
        Map<String, String> inParams = new HashMap<>();
        inParams.put("email", userName);
        inParams.put("password", passWord);
        SqlParameterSource in = new MapSqlParameterSource(inParams);
        Map map = jdbcCall.execute(in);
        return (int) map.get("succeed") >= 1;
    }
}
