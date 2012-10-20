package salestax;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReceiptMakerTests {

    @Test
    public void ReceiptMaker_ReceiptTaxTotal_WhenZeroProducts_EqualsZero() {
        ReceiptMaker zeroItems = new ReceiptMaker();
        assertEquals(0.0, zeroItems.totalSalesTax(), 0.01);
    }

    @Test
    public void ReceiptMaker_ReceiptTotal_WhenZeroProducts_EqualsZero() {
        ReceiptMaker zeroItems = new ReceiptMaker();
        assertEquals(0.0, zeroItems.receiptTotal(), 0.01);
    }

    @Test
    public void ReceiptMaker_parseInteger_WhenInputHasQuantity500_Returns500() {
        String[] inputData = {"500", "books", "at", "12.49"};
        assertEquals(500, ReceiptMaker.parseQuantity(inputData));
    }

    @Test
    public void ReceiptMaker_parseInteger_WhenInputHasQuantityZero_ReturnsZero() {
        String[] inputData = {"0", "books", "at", "12.49"};
        assertEquals(0, ReceiptMaker.parseQuantity(inputData));
    }
}
