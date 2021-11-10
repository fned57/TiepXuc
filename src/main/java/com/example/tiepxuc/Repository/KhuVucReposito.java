package com.example.tiepxuc.Repository;

import com.example.tiepxuc.Model.Khuvuc;
import com.example.tiepxuc.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KhuVucReposito extends CrudRepository<Khuvuc,Integer> {



    @Query(value = "select kv from Khuvuc kv where kv.Idkhuvuc = ?1")
    Khuvuc findByIdkhuvuc(int id);
}
