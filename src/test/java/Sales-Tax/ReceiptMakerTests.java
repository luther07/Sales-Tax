package salestax;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReceiptMakerTests {

    @Test
    public void ReceiptMaker_ReceiptTaxTotal_WhenZeroProducts_EqualsZero() {
        ProductExempt oneImportedProduct = new ProductExempt(1, true, "imported product", 1.0);
        ReceiptMaker zeroItems = new ReceiptMaker();
        assertEquals(0.0, zeroItems.totalSalesTax(), 0.01);
    }

    @Test

}
