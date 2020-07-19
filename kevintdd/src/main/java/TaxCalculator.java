import java.math.BigDecimal;
import java.math.MathContext;

public class TaxCalculator {
    private double tax = 0.10;
    private double importTax = 0.05;
    private double bothTax = 0.15;
    private TaxCalculator(){

    }

    public static TaxCalculator getInstance(){
        return  new TaxCalculator();
    }

    public BigDecimal calculateTax(BigDecimal price, double taxRate){
        MathContext mc = new MathContext(4);
        return price.add(price.multiply(BigDecimal.valueOf(taxRate))).round(mc);
    }

    public BigDecimal checkTaxStatus(Item item){
        BigDecimal itemPrice = item.getPrice();
        if(item.getExempt() == true && item.getImported() == false){
            return itemPrice;
        }
        else if (item.getExempt() == true && item.getImported() == true){
            BigDecimal importedPrice = calculateTax(itemPrice, importTax);
            item.setPrice(importedPrice);
            return itemPrice;
        }
        else if(item.getExempt() == false && item.getImported() == true){
            BigDecimal taxedPrice = calculateTax(itemPrice, bothTax);
            item.setPrice(taxedPrice);
            return itemPrice;
        }
        else if(item.getExempt() == false && item.getImported() == false){
            BigDecimal normalTaxPrice = calculateTax(itemPrice, tax);
            item.setPrice(normalTaxPrice);
            return itemPrice;
        }
        return itemPrice;
    }
}
