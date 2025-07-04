package Fawry.Task.Stock;

import Fawry.Task.Models.Product;
import Fawry.Task.Models.ShippableExiperableProduct;
import Fawry.Task.Models.ShippableProduct;
import java.time.LocalDate;

public class Stock {
    private ShippableExiperableProduct Cheese;
    private ShippableExiperableProduct Biscuits;
    private ShippableProduct TV;
    private ShippableProduct Mobile;
    private Product ScaratchCard;

    // I chose this way because I need to access product direct without store it in a lis
    public Stock() {
        Cheese = new ShippableExiperableProduct("Cheese",100,5,200, LocalDate.now().plusDays(15));
        Biscuits = new ShippableExiperableProduct("Biscuits",150,7,700, LocalDate.now().plusDays(20));
        TV = new ShippableProduct("TV",1500,10,2000);
        Mobile = new ShippableProduct("Mobile",750,8,450);
        ScaratchCard = new Product("ScaratchCard",100,10);
    }

    public ShippableExiperableProduct getCheese() {
        return Cheese;
    }

    public ShippableExiperableProduct getBiscuits() {
        return Biscuits;
    }

    public ShippableProduct getTV() {
        return TV;
    }

    public ShippableProduct getMobile() {
        return Mobile;
    }

    public Product getScaratchCard() {
        return ScaratchCard;
    }

}
