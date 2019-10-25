package com.nadine.and.jay.motoedgeservice.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Motorcycle {
    private int id;
    private BigDecimal price;
    private String vin;
    private String make;
    private String model;
    private String year;
    private String color;

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
        return getId() == that.getId() &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getVin(), that.getVin()) &&
                Objects.equals(getMake(), that.getMake()) &&
                Objects.equals(getModel(), that.getModel()) &&
                Objects.equals(getYear(), that.getYear()) &&
                Objects.equals(getColor(), that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getVin(), getMake(), getModel(), getYear(), getColor());
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "id=" + id +
                ", price=" + price +
                ", vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
