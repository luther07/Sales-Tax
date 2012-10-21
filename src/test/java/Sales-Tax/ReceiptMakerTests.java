package salestax;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReceiptMakerTests {

    @Test
    public void ReceiptMaker_ReceiptTaxTotal_WhenZeroProducts_EqualsZero() {
        ReceiptMaker zeroItemsZeroTaxes = new ReceiptMaker();
        assertEquals(0.0, zeroItemsZeroTaxes.totalSalesTax(), 0.01);
    }

    @Test 
    public void ReceiptMaker_ReceiptTaxTotal_WhenQuantityMoreThanOne_AmountIsMultiplied() {
        ReceiptMaker quantityOfTen = new ReceiptMaker();
        String[] inputData = {"10", "music", "CD", "at", "12.49"};
        quantityOfTen.addProduct(inputData);
        assertEquals(12.49, quantityOfTen.totalSalesTax(), 0.01);
    }

    @Test
    public void ReceiptMaker_ReceiptTotal_WhenZeroProducts_EqualsZero() {
        ReceiptMaker zeroItemsZeroTotal = new ReceiptMaker();
        assertEquals(0.0, zeroItemsZeroTotal.receiptTotal(), 0.01);
    }

    @Test 
    public void ReceiptMaker_ReceiptTotal_WhenQuantityMoreThanOne_AmmountIsMultiplied() {
        ReceiptMaker quantityOfTen = new ReceiptMaker();
        String[] inputData = {"10", "books", "at", "12.49"};
        quantityOfTen.addProduct(inputData);
        assertEquals(124.90, quantityOfTen.receiptTotal(), 0.01);
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

    @Test
    public void ReceiptMaker_parseName_WhenInputHasNameBook_ReturnsBook() {
        String[] inputData = {"1", "book", "at", "12.49"};
        assertEquals("book ", ReceiptMaker.parseName(inputData));
    }

    @Test
    public void ReceiptMaker_parseImported_WhenInputSaysImported_ReturnsTrue() {
        String[] inputData = {"1", "imported", "book", "at", "12.49"};
        assertEquals(true, ReceiptMaker.parseImported(inputData));
    }

    @Test
    public void ReceiptMaker_parsePrice_WhenInputIs100_Returns100() {
        String[] inputData = {"1", "imported", "book", "at", "100.0"};
        assertEquals(100.0, ReceiptMaker.parsePrice(inputData), 0.01);
    }

    @Test
    public void ReceiptMaker_parseExempt_WhenInputIsChocolate_ReturnsTrue() {
        String[] inputData = {"1", "chocolate", "bar", "at", "0.85"};
        assertEquals(true, ReceiptMaker.parseExempt(inputData));
    }

    @Test
    public void ReceiptMaker_ApplicationTest1() {
        String[] inputData1 = {"1", "book", "at", "12.49"};
        String[] inputData2 = {"1", "music", "CD", "at", "14.99"};
        String[] inputData3 = {"1", "chocolate", "bar", "at", "0.85"};
        ReceiptMaker test1 = new ReceiptMaker();
        test1.addProduct(inputData1);
        test1.addProduct(inputData2);
        test1.addProduct(inputData3);
	assertEquals(1.50, test1.totalSalesTax(), 0.01);
        assertEquals(29.83, test1.receiptTotal(), 0.01);        
    }

    @Test
    public void ReceiptMaker_ApplicationTest2() {
        String[] inputData1 = {"1", "imported", "box", "of", "chocolates", "at", "10.00"};
        String[] inputData2 = {"1", "imported", "bottle", "of", "perfume", "at", "47.50"};
        ReceiptMaker test2 = new ReceiptMaker();
        test2.addProduct(inputData1);
        test2.addProduct(inputData2);
        assertEquals(7.65, test2.totalSalesTax(), 0.01);
        assertEquals(65.15, test2.receiptTotal(), 0.01);
    }

    @Test
    public void ReceiptMaker_ApplicationTest3() {
        String[] inputData1 = {"1", "imported", "bottle", "of", "perfume", "at", "27.99"};
        String[] inputData2 = {"1", "bottle", "of", "perfume", "at", "18.99"};
        String[] inputData3 = {"1", "packet", "of", "headache", "pills", "at", "9.75"};
        String[] inputData4 = {"1", "box", "of", "imported", "chocolates", "at", "11.25"};
        ReceiptMaker test3 = new ReceiptMaker();
        test3.addProduct(inputData1);
        test3.addProduct(inputData2);
        test3.addProduct(inputData3);
        test3.addProduct(inputData4);
        assertEquals(6.70, test3.totalSalesTax(), 0.01);
        assertEquals(74.68, test3.receiptTotal(), 0.01);
    }
}
