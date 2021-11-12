package com.example.tiepxuc.Controller;


import com.example.tiepxuc.Model.Diadiem;
import com.example.tiepxuc.Model.Tiepxuc;
import com.example.tiepxuc.Repository.TiepXucReposito;
import com.example.tiepxuc.Repository.UserReposito;
import com.example.tiepxuc.function.findUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RestController
@RequestMapping("/tiepxuc")
public class TiepXucController {

    @Autowired
    TiepXucReposito tiepXucReposito;

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
        tiepxuc.setUser(new findUser().findUser());
        tiepxuc.setDiadiem(diadiem);
        tiepxuc.setThoigian(new Date());
        tiepXucReposito.save(tiepxuc);
        return tiepxuc;
    }



}
