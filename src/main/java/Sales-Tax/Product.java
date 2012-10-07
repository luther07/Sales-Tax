package salestax;

abstract class Product{
    private static double importDuty;
    private boolean imported;
    private String name;
    private double unitPrice;
    private int quantity;

    abstract String name();
    abstract double price();
    abstract int quantity();
    abstract boolean isImported();
    abstract double tax();
}