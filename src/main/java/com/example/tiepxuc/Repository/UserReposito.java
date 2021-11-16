package com.example.tiepxuc.Repository;

import com.example.tiepxuc.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserReposito extends CrudRepository<User,Long> {


    @Query(value = "SELECT u from User u where u.Email = ?1")
    List<User> findUserByEmail(String Email);

    @Query(value = "select u from User u where u.Iduser = ?1")
    User findByIduser(Long id);

    @Query(value = "select u from User u where u.Email = ?1 and  u.Password = ?2")
    User findByEmailAndPassword(String Email, String Password);



}
