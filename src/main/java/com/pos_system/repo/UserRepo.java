package com.pos_system.repo;

import com.pos_system.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {


    List<User> findAllByActiveStatus(Boolean activeStatus);


    Page<User> findAllByActiveStatus(Boolean activeStatus, Pageable pageable);

    int countAllByActiveStatus(Boolean activeStatus);
}
