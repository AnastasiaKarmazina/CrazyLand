package base;

public interface Tax {
    double calculateTax(double cost);
    double calculateCardTax(double cost);
    double calculateCheckTax(double cost);
}
