package com.pos_system.repo;

import com.pos_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Integer, User> {
}
