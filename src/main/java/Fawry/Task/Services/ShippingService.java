package Fawry.Task.Services;

import Fawry.Task.Customs.Shippable;
import Fawry.Task.Models.Cart;
import Fawry.Task.Models.Product;

import java.util.Map;

public class ShippingService {
    public void Report(Cart cart) {
        System.out.println("** Shipment notice **");
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product instanceof Shippable) {
                double weight = ((Shippable) product).getWeight();
                double totalItemWeight = weight * quantity;

                System.out.println(quantity + "x " + product.getName() + " " +  String.format("%.1f", totalItemWeight) + "g");
            }
        }
        System.out.println("Total package weight " + String.format("%.1f", cart.calculateTotalWeight() / 1000) + "kg\n");
    }
}
