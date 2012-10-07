package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductExemptTests {

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductExempt_ExceptionThrownIf_QuantityLessThanOne() throws Exception {
        ProductExempt zeroQuantity = new ProductExempt(0, false, "zero cokes", 1.0);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductExempt_OnEmptyName_ExceptionThrown() throws Exception {
        ProductExempt emptyName = new ProductExempt(1, false, "", 1.0);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductExempt_OnNegativePrice_ExceptionThrown() throws Exception {
        ProductExempt negativePrice = new ProductExempt(1, false, "negative price", -1.0);
    }
}