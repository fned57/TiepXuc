package com.example.tiepxuc.Controller.User;


import com.example.tiepxuc.Model.User;
import com.example.tiepxuc.function.findUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/user")
public class infoController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String info(){
        return "as";
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public User Putinfo(@RequestBody User user){
        User old = new findUser().findUser();
        user.setRole("USER");
        user.setIduser(old.getIduser());
        return user;
    }

}
