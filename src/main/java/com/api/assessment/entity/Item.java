package com.api.assessment.entity;

import javax.persistence.*;

@Entity
@Table(name = "item",schema = "assessment")
public class Item extends SharedModel{
    private Integer itemSeq;
    private String itemName;
    private Double cartonPrice;
    private Double unitPerCarton;
    private Double discountMinValue;
    private Double discount;
    private Double percentageForSingleItem;
    private String imageUrl;
    private Integer amount;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_seq")
    public Integer getItemSeq() {
        return itemSeq;
    }

    public void setItemSeq(Integer itemSeq) {
        this.itemSeq = itemSeq;
    }

    @Basic
    @Column(name = "item_name", nullable = false, length = 250)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "carton_price", nullable = false)
    public Double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(Double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    @Basic
    @Column(name = "unit_per_carton")
    public Double getUnitPerCarton() {
        return unitPerCarton;
    }

    public void setUnitPerCarton(Double unitPerCarton) {
        this.unitPerCarton = unitPerCarton;
    }


    @Basic
    @Column(name = "discount_min_value")
    public Double getDiscountMinValue() {
        return discountMinValue;
    }

    public void setDiscountMinValue(Double discountMinValue) {
        this.discountMinValue = discountMinValue;
    }

    @Basic
    @Column(name = "discount")
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "percentage_for_single_item")
    public Double getPercentageForSingleItem() {
        return percentageForSingleItem;
    }

    public void setPercentageForSingleItem(Double percentageForSingleItem) {
        this.percentageForSingleItem = percentageForSingleItem;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Transient
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
