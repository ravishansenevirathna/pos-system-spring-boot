package com.pos_system.util.mappers;

import com.pos_system.dto.ItemDto;
import com.pos_system.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<ItemDto> entityToDtoList(List<Item> items);

    Item dtoToEntity(ItemDto itemDto);

}
