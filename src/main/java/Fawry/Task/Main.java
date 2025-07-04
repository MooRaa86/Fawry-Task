package Fawry.Task;

import Fawry.Task.Models.Cart;
import Fawry.Task.Models.Customer;
import Fawry.Task.Models.Product;
import Fawry.Task.Services.Checkout;
import Fawry.Task.Stock.Stock;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Stock stock = new Stock();
            Customer customer = new Customer("omar", "Menofia", "01019855004", 2000);
            Cart cart = new Cart();
            cart.addProduct(stock.getCheese(), 2);
            cart.addProduct(stock.getBiscuits(), 1);
//            cart.addProduct(stock.getTV(), 1);
            Checkout checkout = new Checkout(customer, cart);
            checkout.process();
            cart.clear();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}