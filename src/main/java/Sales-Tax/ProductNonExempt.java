package salestax;

public class ProductNonExempt extends Product{
    private static final double basicSalesTax = 10.0;
    private static final double importDuty = 5.0;
    private boolean imported;
    private String name;
    private double unitPrice;
    private int quantity;
    
    public ProductNonExempt(int quantity, boolean imported, String name, double unitPrice) {
        if (quantity < 1) throw new java.lang.IllegalArgumentException();
        if (name.isEmpty()) throw new java.lang.IllegalArgumentException();
        if (unitPrice < 0) throw new java.lang.IllegalArgumentException();
        this.quantity = quantity;
        this.imported = imported;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String name() {
        return this.name;
    }

    public double price() {
        return this.unitPrice * this.quantity + this.tax();
    }

    public int quantity() {
        return this.quantity;
    }

    public boolean isImported() {
        return imported;
    }

    public double tax() {
        if (imported) {
            return (this.unitPrice * quantity * (importDuty + basicSalesTax)/100);
        } else {
            return (this.unitPrice * quantity * (basicSalesTax/100));
        }
    }
}
