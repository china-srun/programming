package com.secondproject.secondspringboot.service.implement;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.secondproject.secondspringboot.dataTransferObject.itemDto;
import com.secondproject.secondspringboot.model.item;
import com.secondproject.secondspringboot.repository.itemRepository;
import com.secondproject.secondspringboot.service.itemService;

@Service
public class itemServiceimpl implements itemService{
    
    @Autowired
    private itemRepository ItemRepository;
    
    public List<item> getItems() {
        return ItemRepository.findItemsByStatus("Active");
    }

    public Page<item> getItemsByPage(int page, int offset) {
        // we use this in order to paginate only 25 items in order to reduce the time spent
        return ItemRepository.findAll(PageRequest.of(page, offset));
    }

    public item createItem(itemDto ItemDto) {
        return ItemRepository.save(new item(UUID.randomUUID().toString(), ItemDto.getName(), ItemDto.getPic(), ItemDto.getPrice(), new Date(), "Active"));
    }

    public item getByItemId(String id) {
        Optional<item> optionalItem =  ItemRepository.findById(id);

        if (optionalItem.isPresent()) {
            return optionalItem.get();
        }
        else {
            return null;
        }
    }

    public item updateItem(String id, itemDto newItemInfo) {
        Optional<item> optionalItem = ItemRepository.findById(id);
        item oldItemInfo = optionalItem.get();
        oldItemInfo.setName(newItemInfo.getName());
        oldItemInfo.setPic(newItemInfo.getPic());
        oldItemInfo.setPrice(newItemInfo.getPrice());
        return ItemRepository.save(oldItemInfo);
    }

    public item deleteItem (String id) {
        Optional<item> optionalItem =  ItemRepository.findById(id);
        item foundItem = optionalItem.get();
        foundItem.setStatus("Deleted");
        return ItemRepository.save(foundItem);
    }
}
