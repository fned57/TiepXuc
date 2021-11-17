package com.example.tiepxuc.dto;

import java.util.Date;

public class TiepXucResposito {

    private Date thoigian;
    private String Tendiadiem;
    private String Tenkhuvuc;

    public TiepXucResposito(Date thoigian, String tendiadiem, String tenkhuvuc) {
        this.thoigian = thoigian;
        Tendiadiem = tendiadiem;
        Tenkhuvuc = tenkhuvuc;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public String getTendiadiem() {
        return Tendiadiem;
    }

    public void setTendiadiem(String tendiadiem) {
        Tendiadiem = tendiadiem;
    }

    public String getTenkhuvuc() {
        return Tenkhuvuc;
    }

    public void setTenkhuvuc(String tenkhuvuc) {
        Tenkhuvuc = tenkhuvuc;
    }
}
