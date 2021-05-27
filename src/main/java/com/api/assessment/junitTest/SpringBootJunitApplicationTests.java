package com.api.assessment.junitTest;

import com.api.assessment.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootJunitApplicationTests {

    private ItemRepository itemRepository;

    @Autowired
    public SpringBootJunitApplicationTests(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

}
