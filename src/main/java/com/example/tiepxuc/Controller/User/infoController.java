package com.example.tiepxuc.Controller.User;


import com.example.tiepxuc.Model.User;
import com.example.tiepxuc.Repository.UserReposito;
import com.example.tiepxuc.function.find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

@Controller
@RestController
@RequestMapping("/user")
public class infoController {

    @Autowired
    UserReposito userReposito;

    @Autowired
    ServletContext servletContext;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public User info(){
        return new find().findUser();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public User Putinfo(@RequestBody User user){
        User old = new find().findUser();
        user.setRole("USER");
        user.setIduser(old.getIduser());
        userReposito.save(user);
        return user;
    }

    @RequestMapping(value = "/avt", method = RequestMethod.PUT)
    public String Putinfos(@RequestBody MultipartFile file){
        if(!file.isEmpty()){
            String part = servletContext.getRealPath("/");
            return part;
//            try {
//                file.transferTo(Path.of(part + "/image/"+file.getOriginalFilename()));
//                return file;
//            } catch (IOException e) {
//                e.printStackTrace();
//                return null;
//            }
        }else
            return null;

    }

}
