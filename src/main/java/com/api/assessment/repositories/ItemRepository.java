package com.api.assessment.repositories;

import com.api.assessment.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByItemNameContainsIgnoreCase(String itemName);

    List<Item> findByStatus(Integer statusSeq);
}
