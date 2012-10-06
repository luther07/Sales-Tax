package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductNonExemptTests {

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void Product_ExceptionThrownIf_QuantityLessThanOne() throws Exception {
        ProductNonExempt zeroQuantity = new ProductNonExempt(0, true, "zeroCokes", 1.00);
    }
}
