package models;

import base.Discount;
import base.Price;

public class DiscountModel implements Discount, Price {
    @Override
    public double calculatePrice(int amount, double tariff){
        return amount * tariff;
    }
    double discount;
    @Override
    public double calculateDiscount(double price) {
        if(price <= 5000){
            discount = price * 5 / 100;
        }else if(price > 5000 && price <= 10000){
            discount = price * 10 / 100;
        }else if (price > 10000){
            discount = price * 15 / 100;
        }
        return discount;
    }
    public double calculateCost(double price, double discount){
        return price - discount;
    }
}
