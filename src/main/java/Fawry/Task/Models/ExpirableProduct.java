package Fawry.Task.Models;

import Fawry.Task.Customs.Expired;

import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expired {

    private final LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }



    public Boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
