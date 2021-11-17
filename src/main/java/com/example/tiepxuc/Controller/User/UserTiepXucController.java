package com.example.tiepxuc.Controller.User;

import com.example.tiepxuc.Model.Diadiem;
import com.example.tiepxuc.Model.Tiepxuc;
import com.example.tiepxuc.Model.User;
import com.example.tiepxuc.Repository.TiepXucReposito;
import com.example.tiepxuc.Repository.UserReposito;
import com.example.tiepxuc.dto.MyUser;
import com.example.tiepxuc.dto.TiepXucResposito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
@RestController
@RequestMapping("/user/tiepxuc")
public class UserTiepXucController {
    @Autowired
    TiepXucReposito tiepXucReposito;
    @Autowired
    UserReposito userReposito;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<TiepXucResposito> GetTiepXuc( ){

        return tiepXucReposito.findTiepxucByUserById(getUser().getIduser());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Iterable<TiepXucResposito> postTiepXuc(@RequestBody Diadiem diadiem){
        Tiepxuc news = new Tiepxuc();
        news.setUser(getUser());
        news.setDiadiem(diadiem);
        news.setThoigian(new Date());
        tiepXucReposito.save(news);
        return tiepXucReposito.findTiepxucByUserById(getUser().getIduser());
    }


    private User getUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id=null;
        if (principal instanceof MyUser) {
            String username = ((MyUser)principal).getUsername();
            id = ((MyUser)principal).getId();
        }
        return userReposito.findByIduser(id);
    }
}
