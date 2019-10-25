package com.nadine.and.jay.cloudmotoinventory.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "motorcycle")
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Digits(integer = 7, fraction = 2)
    @NotNull
    private BigDecimal price;
    @NotEmpty
    @Size(max = 20)
    private String vin;
    @NotEmpty
    @Size(max = 20)
    private String make;
    @NotEmpty
    @Size(max = 20)
    private String model;
    @NotEmpty
    @Size(max = 4)
    private String year;
    @NotEmpty
    @Size(max = 20)
    private String color;

    public Motorcycle(int id, @Digits(integer = 7, fraction = 2) @NotNull BigDecimal price, @NotEmpty @Size(max = 20) String vin
            , @NotEmpty @Size(max = 20) String make, @NotEmpty @Size(max = 20) String model, @NotEmpty @Size(max = 4) String year,
                      @NotEmpty @Size(max = 20) String color) {
        this.id = id;
        this.price = price;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Motorcycle(@Digits(integer = 7, fraction = 2) @NotNull BigDecimal price, @NotEmpty @Size(max = 20) String vin,
                      @NotEmpty @Size(max = 20) String make, @NotEmpty @Size(max = 20) String model, @NotEmpty @Size(max = 4) String year,
                      @NotEmpty @Size(max = 20) String color) {
        this.price = price;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Motorcycle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return id == that.id &&
                price.equals(that.price) &&
                vin.equals(that.vin) &&
                make.equals(that.make) &&
                model.equals(that.model) &&
                year.equals(that.year) &&
                color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, vin, make, model, year, color);
    }
}
