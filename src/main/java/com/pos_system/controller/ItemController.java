package com.pos_system.controller;

import com.pos_system.dto.ItemDto;
import com.pos_system.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/itemSave")
    public String saveItem(@RequestBody ItemDto itemDto){
        itemService.saveItem(itemDto);
        return "Item saved successfully!";
    }
}
