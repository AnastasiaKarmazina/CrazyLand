package models;

import controller.CardController;
import controller.CheckController;
import controller.TaxController;
import views.CardView;
import views.CheckView;
import views.TaxView;

public class AppModel {
    public void runPayCash() {
        TaxView view = new TaxView();
        TaxModel model = new TaxModel();
        TaxController controller = new TaxController(model, view);
        controller.runApp();
    }

    public void runPayCard() {
        CardView view = new CardView();
        TaxModel model = new TaxModel();
        CardController controller = new CardController(model, view);
        controller.runApp();
    }
    public void runPayCheck() {
        CheckView view = new CheckView();
        TaxModel model = new TaxModel();
        CheckController controller = new CheckController(model, view);
        controller.runApp();
    }



}
