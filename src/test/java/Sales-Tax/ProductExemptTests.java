package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductExemptTests {

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductExempt_ExceptionThrownIf_QuantityLessThanOne() throws Exception {
        ProductExempt zeroQuantityExempt = new ProductExempt(0, false, "zero cokes", 1.0);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductExempt_OnEmptyName_ExceptionThrown() throws Exception {
        ProductExempt emptyNameExempt = new ProductExempt(1, false, "", 1.0);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductExempt_OnNegativePrice_ExceptionThrown() throws Exception {
        ProductExempt negativePriceExempt = new ProductExempt(1, false, "negative price", -1.0);
    }

    @Test
    public void ProductExempt_WhenNameNotEmpty_ThenReturnCorrectName() {
        ProductExempt nonEmptyName = new ProductExempt(1, false, "non-empty name", 1.0);
        assertEquals("non-empty name", nonEmptyName.name());
    }

}