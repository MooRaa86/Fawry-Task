package Fawry.Task.Models;

import Fawry.Task.Customs.Shippable;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cart;

    public Cart() {
        cart = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if(product.getQuantity() < quantity) {
            throw new IllegalArgumentException(product.getName()+" quantity is less than " + quantity);
        }
        else if(product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()){
            throw new IllegalArgumentException("Product is expired, cannot add it");
        } else if(product instanceof ShippableExiperableProduct && ((ShippableExiperableProduct) product).isExpired()) {
            throw new IllegalArgumentException("Product is expired, cannot add it");
        }
        cart.put(product, quantity);
        product.setQuantity(product.getQuantity() - quantity);
    }

    public Double calculateSubtotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            total += (entry.getKey().getPrice() * entry.getValue());
        }
        return total;
    }

    public Double calculateTotalWeight() {
        double weight = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            if(entry.getKey() instanceof Shippable) {
                weight += ((Shippable) entry.getKey()).getWeight() * entry.getValue();
            }
        }
        return weight;
    }

    public Double calculateShippingFees() {
        return calculateTotalWeight() * 0.028;
    }

    public Map<Product, Integer> getProducts() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public void clear(){
        cart.clear();
    }
}
