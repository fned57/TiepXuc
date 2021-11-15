package com.example.tiepxuc.Controller;




import com.example.tiepxuc.Model.file;
import com.example.tiepxuc.Repository.fileReposito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Controller
@RestController
@RequestMapping("/file")
public class fileController {

    @Autowired
    fileReposito filereposito;
    @RequestMapping(value = "", method = RequestMethod.POST)
    public file Putinfo(@RequestBody MultipartFile files) {
        if(!files.isEmpty()){
            try {
                file a = new file(1L,files.getBytes());
                filereposito.save(a);
                return a;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }else
            return null;


    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Optional<file> Get() {
        return  filereposito.findById();

    }
    
}
