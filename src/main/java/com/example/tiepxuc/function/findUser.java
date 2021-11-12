package com.example.tiepxuc.function;

import com.example.tiepxuc.Model.User;
import com.example.tiepxuc.Repository.UserReposito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public class findUser {

    @Autowired
    UserReposito userReposito;


    public User findUser(){
        String userName = null;
        String pass = null;
        User user = null;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
            pass = ((UserDetails)principal).getPassword();
            user = userReposito.findByEmailAndPassword(userName,pass);
        } else {
            return null;
        }
        return user;
    }
}
