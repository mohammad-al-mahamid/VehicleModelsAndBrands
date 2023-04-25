package io.kprosoftware.codechallenge.entity;

import javax.persistence.Entity;

import io.kprosoftware.codechallenge.common.BaseEntity;
import io.kprosoftware.codechallenge.enum_.PriceSegment;

@Entity
public class VehicleBrands extends BaseEntity<Long> {

    private String name;
    private PriceSegment priceSegment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PriceSegment getPriceSegment() {
        return priceSegment;
    }

    public void setPriceSegment(PriceSegment priceSegment) {
        this.priceSegment = priceSegment;
    }

    public VehicleBrands(String name, PriceSegment priceSegment) {

        this.name = name;
        this.priceSegment = priceSegment;
    }

}
