package com.example.tiepxuc.Controller.Admin;

import com.example.tiepxuc.Model.Khuvuc;
import com.example.tiepxuc.Repository.KhuVucReposito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RestController
@RequestMapping("/admin/khuvuc")
public class KhuVucController {

    @Autowired
    KhuVucReposito khuVucReposito;



    @RequestMapping(value = "",method = RequestMethod.GET)
    public Iterable<Khuvuc> GetAll(){

        return khuVucReposito.findAll();
    }


    @RequestMapping(value = "",method = RequestMethod.POST)
    public Khuvuc PostKhuVuc(@RequestBody Khuvuc khuvuc){
        khuVucReposito.save(khuvuc);
        return khuvuc;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Khuvuc PutKhuVuc(@RequestBody Khuvuc khuvuc, @PathVariable int id){
        khuvuc.setIdkhuvuc(id);
        khuVucReposito.save(khuvuc);
        return khuvuc;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Khuvuc DeleteKhuVuc(@PathVariable int id){
        Khuvuc old = khuVucReposito.findByIdkhuvuc(id);
        khuVucReposito.delete(old);
        return old;
    }

}
