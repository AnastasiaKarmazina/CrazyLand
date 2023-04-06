package models;

import base.Price;

public class PriceModel implements Price {

    @Override
    public double calculatePrice(int amount, double tariff) {
        return amount * tariff;
    }
}
