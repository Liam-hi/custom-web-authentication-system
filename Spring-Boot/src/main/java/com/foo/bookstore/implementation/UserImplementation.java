package com.foo.bookstore.implementation;

import com.foo.bookstore.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserImplementation implements LoginRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean checkLogin(String userName, String passWord){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("authenticator");
        Map<String, String> inParams = new HashMap<>();
        inParams.put("email", userName);
        inParams.put("userpassword", passWord);
        SqlParameterSource in = new MapSqlParameterSource(inParams);
        Map map = jdbcCall.execute(in);
        return (int) map.get("succeed") >= 1;
    }




}
