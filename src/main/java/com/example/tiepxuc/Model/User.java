package com.example.tiepxuc.Model;



import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Iduser;

    private String Name;

    private  String Email;

    private  String Password;

    private  String Phone;

    @Lob
    private byte[] avt;

    private String Role;




    public Long getIduser() {
        return Iduser;
    }

    public void setIduser(Long iduser) {
        Iduser = iduser;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public byte[] getAvt() {
        return avt;
    }

    public void setAvt(byte[] avt) {
        this.avt = avt;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
