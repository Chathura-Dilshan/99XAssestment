package com.api.assessment.dtos;

public class PriceOfItems {

    private Integer itemSeq;
    private String itemName;
    private Integer cartons;
    private Integer units;
    private Double totalPrice;
    private Double actualCartonPrice;
    private Double actualSinglePrice;

    public Integer getItemSeq() {
        return itemSeq;
    }

    public void setItemSeq(Integer itemSeq) {
        this.itemSeq = itemSeq;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getCartons() {
        return cartons;
    }

    public void setCartons(Integer cartons) {
        this.cartons = cartons;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getActualCartonPrice() {
        return actualCartonPrice;
    }

    public void setActualCartonPrice(Double actualCartonPrice) {
        this.actualCartonPrice = actualCartonPrice;
    }

    public Double getActualSinglePrice() {
        return actualSinglePrice;
    }

    public void setActualSinglePrice(Double actualSinglePrice) {
        this.actualSinglePrice = actualSinglePrice;
    }
}
