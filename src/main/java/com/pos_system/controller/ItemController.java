package com.pos_system.controller;

import com.pos_system.dto.ItemDto;
import com.pos_system.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

//    @PostMapping("/itemSave")
//    public String saveItem(@RequestBody ItemDto itemDto){
//        itemService.saveItem(itemDto);
//        return "Item saved successfully!";
//    }


    @PostMapping("/itemSave")
    public ResponseEntity<Object> saveItem(@RequestBody ItemDto itemDto) {
        String response = itemService.saveItem(itemDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping(value = "/search", params = {"itemName"})
    public List<ItemDto> getItems(@RequestParam(value = "itemName") String itemName) {
        List<ItemDto> itemDto = itemService.searchByName(itemName);
        return itemDto;
    }

    @GetMapping(value = "/search1", params = {"itemName"})
    public List<ItemDto> getItems1(@RequestParam(value = "itemName") String itemName) {
        List<ItemDto> itemDto = itemService.searchByName1(itemName);
        return itemDto;
    }
}
