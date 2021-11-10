package com.example.tiepxuc.Repository;

import com.example.tiepxuc.Model.Diadiem;
import com.example.tiepxuc.Model.Khuvuc;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DiaDiemReposito extends CrudRepository<Diadiem,Integer> {

    @Query(value = "select dd from Diadiem dd where dd.Iddiadiem = ?1")
    Diadiem findByIddiadiem(int id);
}
