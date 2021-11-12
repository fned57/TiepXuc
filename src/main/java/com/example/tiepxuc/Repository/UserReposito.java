package com.example.tiepxuc.Repository;

import com.example.tiepxuc.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserReposito extends CrudRepository<User,Integer> {


    @Query(value = "SELECT u from User u where u.Email = ?1")
    List<User> findUserByEmail(String Email);

    @Query(value = "select u from User u where u.Iduser = ?1")
    User findByIduser(int id);

    @Query(value = "select u from User u where u.Email = ?1 and  u.Password = ?2")
    User findByEmailAndPassword(String Email, String Password);



}
