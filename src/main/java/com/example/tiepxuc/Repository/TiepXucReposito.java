package com.example.tiepxuc.Repository;

import com.example.tiepxuc.Model.Tiepxuc;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TiepXucReposito extends CrudRepository<Tiepxuc,Integer> {
    @Query(value = "select tx from Tiepxuc tx where tx.diadiem.Tendiadiem like ?1")
    Iterable<Tiepxuc> findTiepxucByDiadiem(String diadiem);

    @Query(value = "select tx from Tiepxuc tx where tx.user.Name like ?1")
    Iterable<Tiepxuc> findTiepxucByUser(String name);

    @Query(value = "select tx from Tiepxuc tx where tx.diadiem.Tendiadiem like ?1 and tx.user.Name like ?2")
    Iterable<Tiepxuc> findTiepxucByDiadiemaAndUser(String diadiem, String user);

}
