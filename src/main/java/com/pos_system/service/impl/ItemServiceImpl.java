package com.pos_system.service.impl;

import com.pos_system.dto.ItemDto;
import com.pos_system.entity.Item;
import com.pos_system.repo.ItemRepo;
import com.pos_system.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final ItemRepo itemRepo;

    public ItemServiceImpl(ModelMapper modelMapper, ItemRepo itemRepo) {
        this.modelMapper = modelMapper;
        this.itemRepo = itemRepo;
    }


    @Override
        public String saveItem(ItemDto itemDto) {

//        using moddel mapper
        System.out.println("zzzzzzzzzzzzzz"+itemDto);
        Item item = modelMapper.map(itemDto,Item.class);
        System.out.println("vvvvvvvvvvvvvvv"+item);

        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return "saved";

        }
        else{
            throw new DuplicateKeyException("already exists");
        }


    }
}
