package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductNonExemptTests {

     @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductNonExempt_ExceptionThrownIf_QuantityLessThanOne() throws Exception {
        ProductNonExempt zeroQuantity = new ProductNonExempt(0, false, "zero cokes", 1.00);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductNonExempt_OnEmptyName_ExceptionThrown() throws Exception {
        ProductNonExempt emptyName = new ProductNonExempt(1, false, "", 1.00);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductNonExempt_OnNegativePrice_ExceptionThrown() throws Exception {
        ProductNonExempt negativePrice = new ProductNonExempt(1, false, "negative price", -1.0);
	}

    @Test
    public void ProductNonExempt_WhenNameNotEmpty_ThenReturnsCorrectName() {
        ProductNonExempt nonEmptyName = new ProductNonExempt(1, false, "non-empty name", 1.0);
        assertEquals("non-empty name", nonEmptyName.name());
    }

    @Test
    public void ProductNonExempt_WhenQuantityGreaterThanZero_ThenReturnsCorrectQuantity() {
        ProductNonExempt quantityGreaterThanZero = new ProductNonExempt(12345, false, "qty > 0", 1.0);
        assertEquals(12345, quantityGreaterThanZero.quantity());
    }

    @Test
    public void ProductNonExempt_WhenBasePriceGreaterThanZero_ReturnsCorrectValue() {
        ProductNonExempt quantityGreaterThanZero = new ProductNonExempt(1, false, "price > 0", 1.0);
        assertEquals(1.1, quantityGreaterThanZero.price(), 0.01);
    }

    @Test
    public void ProductNonExempt_WhenImportedBasePriceGreaterThanZero_ReturnsCorrectValue() {
        ProductNonExempt importedQuantityGreaterThanZero = new ProductNonExempt(1, true, "price > 0", 1.0);
        assertEquals(1.15, importedQuantityGreaterThanZero.price(), 0.01);
    }

    @Test
    public void ProductNonExempt_WhenImported_ThenIsImportedReturnsTrue() {
        ProductNonExempt importedProduct = new ProductNonExempt(1, true, "imported", 1.0);
        assertEquals(true, importedProduct.isImported());
    }

    @Test
    public void ProductNonExempt_WhenImported_ThenTaxFifteenPercent() {
        ProductNonExempt importedProductTax = new ProductNonExempt(1, true, "imported", 1.0);
        assertEquals(1.0*0.15, importedProductTax.tax(), 0.01);
    }

    @Test
	public void ProductNonExempt_WhenNotImported_ThenTaxTenPercent() {
        ProductNonExempt notImportedProductTax = new ProductNonExempt(1, false, "not imported", 1.0);
        assertEquals(1.0*0.10, notImportedProductTax.tax(), 0.01);
    }
}
