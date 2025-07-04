package Fawry.Task.Models;

import Fawry.Task.Customs.Expired;
import Fawry.Task.Customs.Shippable;

import java.time.LocalDate;

public class ShippableExiperableProduct extends Product implements Expired, Shippable {
    private double weight;
    private LocalDate expiryDate;


    public ShippableExiperableProduct(String name, double price, int quantity, double weight, LocalDate date) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = date;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
