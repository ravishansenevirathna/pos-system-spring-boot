package com.pos_system.service;

import com.pos_system.dto.ItemDto;

import java.util.List;

public interface ItemService {
    String saveItem(ItemDto itemDto);

    List<ItemDto> searchByName(String itemName);

    List<ItemDto> searchByName1(String itemName);
}
