package com.example.tiepxuc.Controller.Admin;


import com.example.tiepxuc.Model.User;
import com.example.tiepxuc.Repository.UserReposito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    UserReposito userReposito;

    @Autowired
    PasswordEncoder passwordEncoder;


    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> GetAll(){
        return (List<User>) userReposito.findAll();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User GetUserByID(@PathVariable Long id){
        return  userReposito.findByIduser(id);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public User PostUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userReposito.save(user);
        return user;
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public User DeleteUser(@PathVariable Long id){
        User old = userReposito.findByIduser(id);
        userReposito.delete(old);
        return old;
    }


}
