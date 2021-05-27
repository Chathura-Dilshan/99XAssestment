package com.api.assessment.serviceImpl;

import com.api.assessment.dtos.MasterDataStatus;
import com.api.assessment.dtos.PriceOfItems;
import com.api.assessment.entity.Item;
import com.api.assessment.repositories.ItemRepository;
import com.api.assessment.service.ItemService;
import com.api.assessment.util.PriceEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final PriceEngine priceEngine;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository,
                           PriceEngine priceEngine) {
        this.itemRepository = itemRepository;
        this.priceEngine = priceEngine;
    }

    @Override
    public ResponseEntity createItem(Item item) {
        ResponseEntity responseEntity;
        Optional<Item> existItem = this.itemRepository.findByItemNameContainsIgnoreCase(item.getItemName());

        Set<ConstraintViolation<Item>> errors = Validation.buildDefaultValidatorFactory().
                getValidator().validate(item);
        if (errors.size() > 0) {
            responseEntity = new ResponseEntity<>("Item already exist", HttpStatus.BAD_REQUEST);
        } else {
            if (existItem.isPresent()) {
                responseEntity = new ResponseEntity<>("Item already exist", HttpStatus.BAD_REQUEST);

            } else {
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                item.setCreatedBy(username);
                item.setCreatedDate(new Date());
                item.setLastModifiedBy(username);
                item.setLastModifiedDate(new Date());
                item.setStatus(MasterDataStatus.APPROVED.getStatusSeq());
                item.setItemSeq(null);
                this.itemRepository.save(item);
                responseEntity = new ResponseEntity<>(item, HttpStatus.CREATED);
            }
        }

        return responseEntity;
    }

    @Override
    public List<Item> findAllItems(Integer statusSeq) {
        return this.itemRepository.findByStatus(statusSeq);
    }

    @Override
    public PriceOfItems getPrices(Item item) {
        return this.priceEngine.priceCalulation(item);
    }
}
