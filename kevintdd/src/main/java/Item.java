import java.math.BigDecimal;
import java.text.NumberFormat;

public class Item {
    private final String description;
    private final int quantity;
    private BigDecimal price;


    private Item(String description, int quantity, BigDecimal itemPrice){
        this.description = description;
        this.quantity = quantity;
        price = itemPrice;
    }

    public static Item getInstance(String description, int quantity, BigDecimal price){
        return new Item(description, quantity, price);
    }

    @Override
    public String toString(){
        return String.format("%s\t%d\t%s", description, quantity, NumberFormat.getCurrencyInstance().format(price));
    }
}
