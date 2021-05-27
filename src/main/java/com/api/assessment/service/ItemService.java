package com.api.assessment.service;

import com.api.assessment.dtos.PriceOfItems;
import com.api.assessment.entity.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    ResponseEntity createItem(Item item);

    List<Item> findAllItems(Integer statusSeq);

    PriceOfItems getPrices(Item item);
}
