/*******************************************************
 * Author: Mark Johnson
 * Date: 10/07/12
 *
 * Compilation: javac ProductNonExempt.java
 * Execution: not applicable
 *
 * Defines a type for exempt products.
 ******************************************************/

package salestax;

public class ProductExempt extends Product {
    private static final double basicSalesTax = 0.0;
    private static final double importDuty = 5.0;
    private boolean imported;
    private String name;
    private double unitPrice;
    private int quantity;

    public ProductExempt(int quantity, boolean imported, String name, double unitPrice) {
    }

    public String name() {
        return "baked beans";
    }

    public double price() {
        return 0.0;
    }

    public int quantity() {
        return 0;
    }

    public boolean isImported() {
        return false;
    }

    public double tax() {
        return 0.0;
    }
}