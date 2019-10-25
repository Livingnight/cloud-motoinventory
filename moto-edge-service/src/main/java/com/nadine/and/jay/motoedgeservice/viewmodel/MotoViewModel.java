package com.nadine.and.jay.motoedgeservice.viewmodel;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MotoViewModel {
    private int id;
    private BigDecimal price;
    private String vin;
    private String make;
    private String model;
    private String year;
    private String color;
    private BigDecimal salesTax;
    private BigDecimal docFees;
    private BigDecimal transpoCost;
    private BigDecimal totalCost;

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

    public BigDecimal getSalesTax() {
        return salesTax.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getDocFees() {
        return docFees.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setDocFees(BigDecimal docFees) {
        this.docFees = docFees.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getTranspoCost() {
        return transpoCost.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setTranspoCost(BigDecimal transpoCost) {
        this.transpoCost = transpoCost.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getTotalCost() {
        return totalCost.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotoViewModel that = (MotoViewModel) o;
        return getId() == that.getId() &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getVin(), that.getVin()) &&
                Objects.equals(getMake(), that.getMake()) &&
                Objects.equals(getModel(), that.getModel()) &&
                Objects.equals(getYear(), that.getYear()) &&
                Objects.equals(getColor(), that.getColor()) &&
                Objects.equals(getSalesTax(), that.getSalesTax()) &&
                Objects.equals(getDocFees(), that.getDocFees()) &&
                Objects.equals(getTranspoCost(), that.getTranspoCost()) &&
                Objects.equals(getTotalCost(), that.getTotalCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getVin(), getMake(), getModel(), getYear(), getColor(), getSalesTax(), getDocFees(), getTranspoCost(), getTotalCost());
    }

    @Override
    public String toString() {
        return "MotoViewModel{" +
                "id=" + id +
                ", price=" + price +
                ", vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", salesTax=" + salesTax +
                ", docFees=" + docFees +
                ", transpoCost=" + transpoCost +
                ", totalCost=" + totalCost +
                '}';
    }
}
