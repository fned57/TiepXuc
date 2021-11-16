package com.example.tiepxuc.Controller.User;


import com.example.tiepxuc.Model.User;
import com.example.tiepxuc.Repository.UserReposito;
import com.example.tiepxuc.dto.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;

@Controller
@RestController
@RequestMapping("/user")
public class infoController {

    @Autowired
    UserReposito userReposito;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public User info( ){

        return userReposito.findByIduser(findId());

    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public User Putinfo(@RequestBody User user){
        User usernew = userReposito.findByIduser(findId());
        user.setIduser(findId());
        user.setEmail(usernew.getEmail());
        user.setPassword(usernew.getPassword());
        user.setRole(usernew.getRole());
        userReposito.save(user);
        return user;
    }

    @RequestMapping(value = "/avt", method = RequestMethod.PUT)
    public String Putavtuser(@RequestBody MultipartFile file){

        if(!file.isEmpty()){
            try {
                User user = userReposito.findByIduser(findId());;
                user.setAvt(file.getBytes());
                userReposito.save(user);
                return "Thên ảnh thành công";
            } catch (IOException e) {
                e.printStackTrace();
                return "Thêm ảnh thất bại";
            }
        }else
            return "Thêm ảnh thất bại";

    }

    private Long findId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id=null;
        if (principal instanceof MyUser) {
            String username = ((MyUser)principal).getUsername();
            id = ((MyUser)principal).getId();
        }
        return id;
    }

}
