package com.secondproject.secondspringboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.secondproject.secondspringboot.dataTransferObject.itemDto;
import com.secondproject.secondspringboot.model.item;

public interface itemService {
    
    List<item> getItems();

    Page<item> getItemsByPage(int page, int offset);
    
    item getByItemId(String id);

    item createItem(itemDto ItemDto);

    item updateItem(String id, itemDto newItemInfo);

    item deleteItem (String id);
    
}
