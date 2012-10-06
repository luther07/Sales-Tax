package salestax;

public class ProductNonExempt extends Product{
    public static final double basicSalesTax = 10.0;
    public static final double importDuty = 5.0;
    private boolean imported;
    private boolean exempt;
    private String name;
    private double basePrice;
    private int quantity;
    
    public ProductNonExempt(int quantity, boolean imported, String name, double basePrice) {
        if (quantity < 1) throw new java.lang.IllegalArgumentException();
    }
}
