package com.example.tiepxuc.Service;


import com.example.tiepxuc.Model.User;
import com.example.tiepxuc.Repository.UserReposito;
import com.example.tiepxuc.dto.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
//            ArrayList<String> list = new ArrayList<>();
//            list.add("ADMIN");


            List<SimpleGrantedAuthority> authorities = new ArrayList<>();

//            for (String role : list) {
//                authorities.add(new SimpleGrantedAuthority(role));
//            }
            authorities.add(new SimpleGrantedAuthority(user.get(0).getRole()));
//            return new org.springframework.security.core.userdetails.User(user.get(0).getEmail(), user.get(0).getPassword(),authorities);
            MyUser user1  =new  MyUser(user.get(0).getEmail(), user.get(0).getPassword(),authorities);
            user1.setId(user.get(0).getIduser());
            return user1;
        }
    }
}
