package com.example.tiepxuc.Controller;


import com.example.tiepxuc.Model.Diadiem;
import com.example.tiepxuc.Model.Tiepxuc;
import com.example.tiepxuc.Model.User;
import com.example.tiepxuc.Repository.TiepXucReposito;
import com.example.tiepxuc.Repository.UserReposito;
import com.example.tiepxuc.dto.MyUser;
import com.example.tiepxuc.function.find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RestController
@RequestMapping("/tiepxuc")
public class TiepXucController {

    @Autowired
    TiepXucReposito tiepXucReposito;

    @Autowired
    UserReposito userReposito;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Iterable<Tiepxuc> GetTiepXuc(@RequestParam(name = "user", required = false) String name, @RequestParam(name = "diadiem", required = false) String diadiem){
        if(name != null && diadiem != null){
            return tiepXucReposito.findTiepxucByDiadiemaAndUser(diadiem,name);
        }else if(diadiem != null && name == null){
            return tiepXucReposito.findTiepxucByDiadiem(diadiem);
        }else if(name != null && diadiem == null)
            return tiepXucReposito.findTiepxucByUser(name);
        else return tiepXucReposito.findAll();
    }


    @RequestMapping(value = "",method = RequestMethod.POST)
    public Tiepxuc PostTiepXuc(@RequestBody Diadiem diadiem){

        Tiepxuc tiepxuc = new Tiepxuc();
        tiepxuc.setUser(getUser());
        tiepxuc.setDiadiem(diadiem);
        tiepxuc.setThoigian(new Date());
        tiepXucReposito.save(tiepxuc);
        return tiepxuc;
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
