import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReceiptView {


    private ReceiptView(){

    }

    public static ReceiptView getInstance() {
        return new ReceiptView();
    }

    public String prePrint(Receipt receipt){
        StringBuilder formattedReceipt = new StringBuilder();
        String taxedTotal = new String();
        String taxes = new String();
        BigDecimal totalPrice = BigDecimal.valueOf(0.00);
        BigDecimal preTaxTotal = BigDecimal.valueOf(0.00);
        for (Item item : receipt.getItems()){
            formattedReceipt.append(String.format("\n\t%s", item.toString()));
            totalPrice = totalPrice.add(item.getPrice());
            preTaxTotal = preTaxTotal.add(item.getOriginalPrice());
        }
        BigDecimal taxed = roundToNickle(totalPrice);
        taxedTotal = roundToNickle(totalPrice).toString();
        BigDecimal preTax = roundToNickle(preTaxTotal);
        BigDecimal salesTax = taxed.subtract(preTaxTotal);
        taxes = roundToNickle(salesTax).toString();
        formattedReceipt.append(String.format("\n\t%s", "Sales Taxes: " + taxes + " The total price is: " + taxedTotal));
        return formattedReceipt.toString();
    }
    public static BigDecimal roundToNickle(final BigDecimal value){
        return value.setScale(2, RoundingMode.FLOOR).multiply(new BigDecimal(20)).add(new BigDecimal("0.5")).setScale(0, RoundingMode.FLOOR).divide(new BigDecimal(20)).setScale(2, RoundingMode.FLOOR);
    }
}
