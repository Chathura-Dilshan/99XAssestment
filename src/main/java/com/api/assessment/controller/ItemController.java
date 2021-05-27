package com.api.assessment.controller;

import com.api.assessment.dtos.MasterDataStatus;
import com.api.assessment.dtos.PriceOfItems;
import com.api.assessment.entity.Item;
import com.api.assessment.repositories.ItemRepository;
import com.api.assessment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('createItem')")
    public ResponseEntity createFood(@RequestBody Item item) {
        return this.itemService.createItem(item);
    }


    @PostMapping("/getPrices")
    @PreAuthorize("hasAnyRole('createItem')")
    public PriceOfItems getPrices(@RequestBody Item item) {
        return this.itemService.getPrices(item);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('login','createItem')")
    public List<Item> findAllUsers() {
        return this.itemService.findAllItems(MasterDataStatus.APPROVED.getStatusSeq());
    }
}
