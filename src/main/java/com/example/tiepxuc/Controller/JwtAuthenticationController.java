package com.example.tiepxuc.Controller;


import com.example.tiepxuc.Config.JwtTokenUtil;
import com.example.tiepxuc.Model.JwtRequest;
import com.example.tiepxuc.Model.JwtResponse;
import com.example.tiepxuc.Model.User;
import com.example.tiepxuc.Repository.UserReposito;
import com.example.tiepxuc.Service.JwtUserDetailsService;
import com.example.tiepxuc.function.find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/*
Expose a POST API /authenticate using the JwtAuthenticationController. The POST API gets username and password in the
body- Using Spring Authentication Manager we authenticate the username and password.If the credentials are valid,
a JWT token is created using the JWTTokenUtil and provided to the client.
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserReposito userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    UserReposito userReposito;

    @RequestMapping(value = "/dangki", method = RequestMethod.POST)
    public  String createUser(@RequestBody User user) {
        if(user.getPassword()==null || user.getEmail() == null){
            return "Đăng kí thất bại";
        }else{
            user.setPassword(bcryptEncoder.encode(user.getPassword()));
            user.setRole("USER");
            userDao.save(user);
            return "Đăng kí thành công";
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public User getuser(){
        return findUser();
    }

    public User findUser(){
        String userName = null;
        String pass = null;
        User user = null;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
            pass = ((UserDetails)principal).getPassword();
            user = userReposito.findByEmailAndPassword(userName,pass);
        } else {
            return null;
        }
        return user;
    }
}
