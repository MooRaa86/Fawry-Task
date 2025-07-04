package Fawry.Task.Services;

import Fawry.Task.Models.*;
import java.util.Map;

public  class Checkout {
    private Customer customer;
    private Cart cart;

    public Checkout(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
    }

    public void checkCart(){
        if(cart.getProducts().isEmpty() || cart == null){
            throw new RuntimeException("Cart is empty");
        }
    }

    public void checkProducts(){
        for(Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()){
            Product product = entry.getKey();
            if(product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()){
                throw new RuntimeException("Product is expired");
            }
            if(product instanceof ShippableExiperableProduct && ((ShippableExiperableProduct) product).isExpired()){
                throw new RuntimeException("Product is expired");
            }
            if(product.getQuantity() < 1){
                throw new RuntimeException("Product " + product.getName() +"is out of stock");
            }

        }
    }

    public void checkBalance(){
        double totalPrice = 0.0;
        for(Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()){
            totalPrice += entry.getKey().getPrice();
        }
        if (customer.getBalance() < totalPrice){
            throw new RuntimeException("Not enough balance in your account");
        }
    }

    public void process() {
        checkCart();
        checkProducts();
        checkBalance();

        ShippingService sp = new ShippingService();
        sp.Report(cart);

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            int quantity = entry.getValue();
            String productName = entry.getKey().getName();
            double productPrice = entry.getKey().getPrice();
            double TotalProductPrice = quantity * productPrice;
            System.out.println(quantity + "x " + productName + " " + String.format("%.1f", TotalProductPrice)+" $");
        }

        System.out.println("----------------------");
        double subtotal = cart.calculateSubtotal();
        double shipping =  cart.calculateShippingFees();
        double amount = subtotal + shipping;
        System.out.println("Subtotal " + String.format("%.1f", subtotal) + " $");
        System.out.println("Subtotal " + String.format("%.1f", shipping)+ " $");
        System.out.println("Amount " + String.format("%.1f", amount)+ " $");
    }
}
