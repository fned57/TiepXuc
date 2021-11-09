package com.example.tiepxuc.Service;


import com.example.tiepxuc.Model.User;
import com.example.tiepxuc.Repository.UserReposito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserReposito userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> user = userDao.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Dang Nhap that bai" + username);
        } else {
            return new org.springframework.security.core.userdetails.User(user.get(0).getEmail(), user.get(0).getPassword(), new ArrayList<>());
        }
    }
}
