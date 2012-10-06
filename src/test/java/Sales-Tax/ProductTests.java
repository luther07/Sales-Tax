package salestax;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTests {

   @Test
   public void testTrue() {
      assertEquals("True", true, true);
   }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void Product_ExceptionThrownIf_QuantityLessThanOne() throws Exception {
        Product zeroQuantity = new Product(0, true, "zeroCokes", 1.00);
            
    }
}
