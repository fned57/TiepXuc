package com.example.tiepxuc.Repository;

import com.example.tiepxuc.Model.file;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface fileReposito extends JpaRepository<file,Long> {
    @Query(value = "select u from file u where u.id = 14")
    Optional<file> findById();
}
