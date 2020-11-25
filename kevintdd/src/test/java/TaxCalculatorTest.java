import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorTest {
    Item musicCD = Item.getInstance("Twice - More & More CD", 1, BigDecimal.valueOf(14.99), false, false);
    @Test
    public void testCalculateTax_sales() {
        double taxRate = 0.1;
        BigDecimal price = BigDecimal.valueOf(14.99);
        BigDecimal expected = BigDecimal.valueOf(16.49);
        BigDecimal actual =  TaxCalculator.getInstance().calculateTax(price, taxRate);
        assertEquals(actual, expected);
    }
    @Test
    public void testCalculateTax_import(){
        double taxRate = 0.05;
        BigDecimal price = BigDecimal.valueOf(10.00);
        String expected = NumberFormat.getCurrencyInstance().format(BigDecimal.valueOf(10.50));
        String actual = NumberFormat.getCurrencyInstance().format(TaxCalculator.getInstance().calculateTax(price, taxRate));
        assertEquals(actual, expected);
    }
}
