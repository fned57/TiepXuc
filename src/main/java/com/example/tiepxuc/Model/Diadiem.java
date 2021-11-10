package com.example.tiepxuc.Model;

import javax.persistence.*;


@Entity
public class Diadiem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Iddiadiem;
    private String Tendiadiem;

    @ManyToOne
    @JoinColumn(name = "Idkhuvuc")
    private Khuvuc khuvuc;

    public Integer getIddiadiem() {
        return Iddiadiem;
    }

    public void setIddiadiem(Integer iddiadiem) {
        Iddiadiem = iddiadiem;
    }

    public String getTendiadiem() {
        return Tendiadiem;
    }

    public void setTendiadiem(String tendiadiem) {
        Tendiadiem = tendiadiem;
    }

    public Khuvuc getKhuvuc() {
        return khuvuc;
    }

    public void setKhuvuc(Khuvuc khuvuc) {
        this.khuvuc = khuvuc;
    }
}
