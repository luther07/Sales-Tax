package salestax;

public class ProductNonExempt extends Product{
    public static final double basicSalesTax = 10.0;
    public static final double importDuty = 5.0;
    private boolean imported;
    private String name;
    private double basePrice;
    private int quantity;
    
    public ProductNonExempt(int quantity, boolean imported, String name, double basePrice) {
        if (quantity < 1) throw new java.lang.IllegalArgumentException();
        if (name.isEmpty()) throw new java.lang.IllegalArgumentException();
        if (basePrice < 0) throw new java.lang.IllegalArgumentException();
        this.quantity = quantity;
        this.imported = imported;
        this.name = name;
        this.basePrice = basePrice;
    }

    public String name() {
        return this.name;
    }

    public double price() {
        if (imported) {
            return (this.basePrice * quantity * (1 + importDuty/100));
        } else {
            return this.basePrice * quantity;
        }
    }

    public int quantity() {
        return this.quantity;
    }
}
