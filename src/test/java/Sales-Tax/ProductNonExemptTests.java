package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductNonExemptTests {

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductNonExempt_ExceptionThrownIf_QuantityLessThanOne() throws Exception {
        ProductNonExempt zeroQuantity = new ProductNonExempt(0, true, "zeroCokes", 1.00);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductNonExempt_OnEmptyName_ExceptionThrown() throws Exception {
        ProductNonExempt emptyName = new ProductNonExempt(1, true, "", 1.00);
    }
}
