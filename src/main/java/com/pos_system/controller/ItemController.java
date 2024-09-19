package com.pos_system.controller;

import com.pos_system.dto.ItemDto;
import com.pos_system.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/search", params = {"itemName"})
    public List<ItemDto> getItems(@RequestParam(value = "itemName") String itemName){
        List<ItemDto> itemDto = itemService.searchByName(itemName);
        return itemDto;
    }

    @GetMapping(value = "/search1", params = {"itemName"})
    public List<ItemDto> getItems1(@RequestParam(value = "itemName") String itemName){
        List<ItemDto> itemDto = itemService.searchByName1(itemName);
        return itemDto;
    }
}
