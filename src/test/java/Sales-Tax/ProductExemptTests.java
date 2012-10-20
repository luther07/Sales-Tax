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

    @Test
    public void ProductExempt_WhenQuantityGreaterThanZero_ThenReturnCorrectQuantity() {
        ProductExempt quantityGreaterThanZero = new ProductExempt(12345, false, "qty > 0", 1.0);
        assertEquals(12345, quantityGreaterThanZero.quantity());    
    }

    @Test
    public void ProductExempt_WhenUnitPriceGreaterThanZero_ThenReturnsCorrectPrice() {
        ProductExempt unitPriceGreaterThanZero = new ProductExempt(999, false, "price > 0", 1.0);
        assertEquals(1.0, unitPriceGreaterThanZero.price(), 0.01);
    }

    @Test
    public void ProductExempt_WhenImportUnitPriceGreaterThanZero_ThenReturnsCorrectPrice() {
        ProductExempt importedUnitPriceGreaterThanZero = new ProductExempt(999, true, "price > 0", 1.0);
        assertEquals(1.05, importedUnitPriceGreaterThanZero.price(), 0.01);
    }

    @Test
    public void ProductExempt_WhenImported_ThenIsImportedReturnsTrue() {
        ProductExempt importedProduct = new ProductExempt(1, true, "imported", 1.0);
        assertEquals(true, importedProduct.isImported());
    }

    @Test
    public void ProductExempt_WhenImported_ThenTaxIsFivePercent() {
        ProductExempt importedProductTax = new ProductExempt(999, true, "imported", 1.0);
        assertEquals(1.0*0.05, importedProductTax.tax(), 0.01);
    }

    @Test
    public void ProductExempt_WhenNotImported_ThenTaxIsZeroPercent() {
        ProductExempt notImportedProductTax = new ProductExempt(999, false, "not imported", 1.0);
        assertEquals(0.0, notImportedProductTax.tax(), 0.01);
    }

    @Test
    public void ProductExempt_WhenTaxNotAtFiveCentIncr_ThenRound() {
        ProductExempt taxRoundingProduct = new ProductExempt(999, true, "must round", 1.1);
        assertEquals(0.10, taxRoundingProduct.tax(), 0.01);
    }

    @Test
    public void ProductExempt_WhenInputProductQuantityIs500_ThenObjectHas500Quantity() {
        String[] inputProductData = {"500", "books", "at", "12.49"};
        ProductExempt inputQuantityFiveHundred = new ProductExempt(inputProductData);
        assertEquals(500, inputQuantityFiveHundred.quantity());
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductExempt_ConstructorStringArray_WhenQuantityLessThan1_ExceptionThrown() {
        String[] quantityZero = {"0", "books", "at", "12.49"};
        ProductExempt stringArrayConstructorZeroQuantity = new ProductExempt(quantityZero);
    }

    @Test
    public void ProductExempt_parseQuantity_WhenParsingQuanity500_Returns500() {
        String[] inputProductData = {"500", "books", "at", "12.49"};
        assertEquals(500, ProductExempt.parseQuantity(inputProductData));
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void ProductExempt_ConstructorStringArray_WhenEmptyName_ExceptionThrown() {
        String[] inputProductData = {"1", "at", "12.49"};
        ProductExempt stringArrayConstructorEmptyName = new ProductExempt(inputProductData);
    }
}