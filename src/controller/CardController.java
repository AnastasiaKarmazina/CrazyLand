package controller;

import models.TaxModel;
import product.Product;
import utils.Rounder;
import views.CardView;


public class CardController {
    TaxModel model;
    CardView view;
    private String name;
    private int amount;
    private double tariff;

    public CardController(TaxModel model, CardView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {
        mapDataToModel();
        double[] calcValues = {
                calcPrice(), calcDiscount(),
                calcCost(), calcCardTax(),
                calcCardTaxCost()
        };
        String[] roundValues = getRoundValues(calcValues);
        setOutput(formOutput(roundValues));
    }

    private void mapDataToModel() {
        String[] data = view.getData();
        Product product = new Product();

        product.setName(data[0]);
        name = product.getName();

        product.setAmount(Integer.parseInt(data[1]));
        amount = product.getAmount();

        product.setTariff(Double.parseDouble(data[2]));
        tariff = product.getTariff();
    }

    private double calcPrice() {
        return model.calculatePrice(amount, tariff);
    }

    private double calcDiscount() {
        return model.calculateDiscount(calcPrice());
    }

    private double calcCost() {
        return model.calculateCost(calcPrice(), calcDiscount());
    }

    private double calcCardTax() {
        return model.calculateCardTax(calcCost());
    }

    private double calcCardTaxCost() {
        return model.calculateTaxWithCardCost(calcCost(), calcCardTax());
    }

    private String[] getRoundValues(double[] calcValues) {
        return new String[]{
                Rounder.roundValue(calcValues[0]),
                Rounder.roundValue(calcValues[1]),
                Rounder.roundValue(calcValues[2]),
                Rounder.roundValue(calcValues[3]),
                Rounder.roundValue(calcValues[4]),
        };
    }
    private String formOutput(String[] calcValues) {
        return "------------------------------\n" +
                "Product name is: " + name + ";" + "\n" +
                "Amount product: " + amount + " ШТ;" + "\n" +
                "Tariff is: " + tariff + " USD;" + "\n" +
                "Price is: " + calcValues[0] + " USD;\n" +
                "Discount is: " + calcValues[1] + " USD;\n" +
                "Cost is: " + calcValues[2] + " USD; \n" +
                "Tax amount (USD): " + calcValues[3]  + "\n" +
                "Cost amount (USD): " + calcValues[4];

    }
    private void setOutput(String output) {

        view.getOutput(output);
    }
}

