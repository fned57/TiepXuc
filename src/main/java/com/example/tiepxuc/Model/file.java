package com.example.tiepxuc.Model;


import javax.persistence.*;


@Entity
public class file {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private byte[] data;


    public file(Long id, byte[] data) {
        this.id = id;
        this.data = data;
    }

    public file() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
