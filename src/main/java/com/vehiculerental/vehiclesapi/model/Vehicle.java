package com.vehiculerental.vehiclesapi.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @NotNull
    @Size(min = 7, max = 7)
    private String id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "type")
    private String type;

    @Column(name = "color")
    private String color;

    @Column(name = "base_price")
    private Float basePrice;

    @Column(name = "kmPrice")
    private Float kmPrice;

    @Column(name = "horse_power")
    private int horsePower;

    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    public Vehicle() {

    }


    public Vehicle(String id, String brand, String type, String color, Float basePrice, Float kmPrice, int horsePower, Date createdAt, Date updatedAt) {


        this.id = id;
        this.brand = brand;
        this.type = type;
        this.color = color;
        this.basePrice = basePrice;
        this.kmPrice = kmPrice;
        this.horsePower = horsePower;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {

        this.basePrice = basePrice;
    }

    public Float getKmPrice() {
        return kmPrice;
    }

    public void setKmPrice(Float kmPrice) {

        this.kmPrice = kmPrice;
    }

    public int getHorsePower() {

        return horsePower;
    }

    public void setHorsePower(int horsePower) {

        this.horsePower = horsePower;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;

    }

}
