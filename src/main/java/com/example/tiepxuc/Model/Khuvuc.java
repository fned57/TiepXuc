package com.example.tiepxuc.Model;


import javax.persistence.*;

@Entity
public class Khuvuc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Idkhuvuc;
    private String Tenkhuvuc;

    public Integer getIdkhuvuc() {
        return Idkhuvuc;
    }

    public void setIdkhuvuc(Integer idkhuvuc) {
        Idkhuvuc = idkhuvuc;
    }

    public String getTenkhuvuc() {
        return Tenkhuvuc;
    }

    public void setTenkhuvuc(String tenkhuvuc) {
        Tenkhuvuc = tenkhuvuc;
    }
}
