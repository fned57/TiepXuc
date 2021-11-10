package com.example.tiepxuc.Controller.Admin;

import com.example.tiepxuc.Model.Diadiem;
import com.example.tiepxuc.Model.Khuvuc;
import com.example.tiepxuc.Repository.DiaDiemReposito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/admin/diadiem")
public class DiaDiemController {

    @Autowired
    DiaDiemReposito diaDiemReposito;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Iterable<Diadiem> GetAll(){

        return diaDiemReposito.findAll();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Diadiem PutKhuVuc(@RequestBody Diadiem diadiem, @PathVariable int id){
        diadiem.setIddiadiem(id);
        diaDiemReposito.save(diadiem);
        return diadiem;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Diadiem DeleteKhuVuc(@PathVariable int id){
        Diadiem old = diaDiemReposito.findByIddiadiem(id);
        diaDiemReposito.delete(old);
        return old;
    }

}
