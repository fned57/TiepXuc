package com.example.tiepxuc.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Tiepxuc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "Iddiadiem")
    private Diadiem diadiem;


    @ManyToOne
    @JoinColumn(name = "Iduser")
    private User user;

    private Date thoigian;

//    private Integer Iddiadiem;
//
//    private Integer Iduser;

//    public Integer getIddiadiem() {
//        return Iddiadiem;
//    }
//
//    public void setIddiadiem(Integer iddiadiem) {
//        Iddiadiem = iddiadiem;
//    }
//
//    public Integer getIduser() {
//        return Iduser;
//    }
//
//    public void setIduser(Integer iduser) {
//        Iduser = iduser;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Diadiem getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(Diadiem diadiem) {
        this.diadiem = diadiem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }
}
