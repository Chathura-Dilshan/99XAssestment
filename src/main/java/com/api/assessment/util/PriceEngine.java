package com.api.assessment.util;

import com.api.assessment.dtos.PriceOfItems;
import com.api.assessment.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class PriceEngine {


    public PriceOfItems priceCalulation(Item item) {

        PriceOfItems priceOfItems = new PriceOfItems();
        if (item.getAmount() != null) {
            Integer cartonValue = (int) (item.getAmount() / item.getUnitPerCarton());
            Integer unitValue = (int) (item.getAmount() % item.getUnitPerCarton());

            Double actualCartonPrice;
            Double actualSinglePrice;
            if (cartonValue >= item.getDiscount()) {
                actualCartonPrice = cartonValue * item.getCartonPrice();
                actualCartonPrice = actualCartonPrice * (item.getDiscount() / 100);

            } else {
                actualCartonPrice = cartonValue * item.getCartonPrice();
            }

            //Single unit price
            actualSinglePrice = (unitValue * item.getCartonPrice()) +
                    (unitValue * item.getCartonPrice()) * (item.getPercentageForSingleItem() / 100);


            priceOfItems.setCartons(cartonValue);
            priceOfItems.setUnits(unitValue);
            priceOfItems.setItemName(item.getItemName());
            priceOfItems.setItemSeq(item.getItemSeq());
            priceOfItems.setActualCartonPrice(actualCartonPrice);
            priceOfItems.setActualSinglePrice(actualSinglePrice);

        }

        return priceOfItems;

    }
}
