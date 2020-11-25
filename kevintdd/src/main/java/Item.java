import java.math.BigDecimal;
import java.text.NumberFormat;

public class Item {
    private final String description;
    private final int quantity;
    private BigDecimal price;
    private final BigDecimal originalPrice;
    private boolean imported;
    private boolean exempt;

    private Item(String description, int quantity, BigDecimal itemPrice, boolean exempt, boolean imported){
        this.description = description;
        this.quantity = quantity;
        this.imported = imported;
        this.exempt = exempt;
        price = itemPrice;
        originalPrice = itemPrice;
    }

    public static Item getInstance(String description, int quantity, BigDecimal price, boolean exempt, boolean imported){
        return new Item(description, quantity, price, exempt, imported);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getOriginalPrice(){
        return originalPrice;
    }

    public void setPrice(BigDecimal newPrice){
        this.price = newPrice;
    }

    public String getDescription(){
        return description;
    }
    public boolean getImported(){
        return imported;
    }

    public boolean getExempt(){
        return exempt;
    }

    @Override
    public String toString(){
        return String.format("%s\t%d\t%s", description, quantity, NumberFormat.getCurrencyInstance().format(price));
    }
}
