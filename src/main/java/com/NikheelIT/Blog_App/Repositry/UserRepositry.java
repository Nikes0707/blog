package com.NikheelIT.Blog_App.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NikheelIT.Blog_App.Model.User;

public interface UserRepositry extends JpaRepository<User, Integer> {

}
