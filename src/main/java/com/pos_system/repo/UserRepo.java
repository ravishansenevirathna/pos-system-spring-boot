package com.pos_system.repo;

import com.pos_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {


//    List<User> findAllByActive_status(String activeStatus);
}
