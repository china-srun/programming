package com.secondproject.secondspringboot.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.secondproject.secondspringboot.dataTransferObject.itemDto;
import com.secondproject.secondspringboot.model.item;
import com.secondproject.secondspringboot.service.itemService;

@RestController
@RequestMapping("/item")
public class itemController {

    @Autowired
    private itemService ItemService;


    //  ITEM_READ
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<item>> getItems() {
        return new ResponseEntity<>(ItemService.getItems(), HttpStatus.OK);
    }

    //  ITEM_READ
    @RequestMapping(value = {"page"}, method = RequestMethod.GET)
    // to test in postman, localhost: 8880/item/page?page=0&offset=25
    public ResponseEntity<Page<item>> getItemsByPage(int page, int offset) {
        return new ResponseEntity<>(ItemService.getItemsByPage(page, offset), HttpStatus.OK);
    }

    // we want the object we add as a json object
    //  ITEM_CREATE
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<item> createItem(@RequestBody itemDto addedItem) {
        return new ResponseEntity<>(ItemService.createItem(addedItem), HttpStatus.OK);
    }


    // value means another path, in order to access the getById method we have to use getById path in the main path
    //  ITEM_READ
    @RequestMapping(value = {"getById"}, method = RequestMethod.GET)
    public ResponseEntity<item> genSingleItem(@RequestParam String id) {
        if (ItemService.getByItemId(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ItemService.getByItemId(id), HttpStatus.OK);
    }


    //  ITEM_WRITE
    @RequestMapping(value = {"update"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<item> updateItem(@RequestParam String id,  @RequestBody itemDto ItemDto) {
        return new ResponseEntity<>(ItemService.updateItem(id, ItemDto), HttpStatus.OK);
    }

    //  ITEM_DELETE
    @RequestMapping(value = {"delete"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<item> deleteItem(@RequestParam String id) {
        return new ResponseEntity<>(ItemService.deleteItem(id), HttpStatus.OK);
    }
}
