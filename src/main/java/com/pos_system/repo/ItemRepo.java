package com.pos_system.repo;

import com.pos_system.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findByItemName(String itemName);
}
