package io.kprosoftware.codechallenge.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import io.kprosoftware.codechallenge.common.BaseEntity;
import io.kprosoftware.codechallenge.enum_.PriceSegment;

@Entity
public class VehicleBrand extends BaseEntity<Long> {

    private String name;
    @Enumerated(EnumType.STRING)
    private PriceSegment priceSegment;

    public VehicleBrand() {
        super();
    }

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

    public VehicleBrand(String name, PriceSegment priceSegment) {

        this.name = name;
        this.priceSegment = priceSegment;
    }

}
