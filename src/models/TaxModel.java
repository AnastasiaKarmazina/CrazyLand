package models;

import base.Discount;
import base.Price;
import base.Tax;

public class TaxModel implements Tax, Discount, Price {
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
    double tax;
    @Override
    public double calculateTax(double cost){
        if(cost <= 5000){
            tax = cost * 2 / 100;
        }else if(cost > 5000 && cost <= 10000){
            tax = cost * 5 / 100;
        }else if(cost > 10000){
            tax = cost * 7 / 100;
        }
        return tax;
    }
    public double calculateTaxWithCost(double cost, double tax){
        return cost + tax;
    }
    @Override
    public double calculateCardTax(double cost){
        if(cost <= 5000){
            tax = cost * 3 / 100;
        }else if(cost > 5000 && cost <= 10000){
            tax = cost * 2 / 100;
        }else if(cost > 10000){
            tax = cost;
        }
        return tax;
    }
    public double calculateTaxWithCardCost(double cost, double tax){
        return cost + tax;
    }
    @Override
    public double calculateCheckTax(double cost){
        return cost * 2 / 100;
    }
    public double calculateTaxCheckCost(double cost, double tax){
        return cost + tax;
    }
}

