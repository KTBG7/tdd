import java.math.BigDecimal;

public class Store {
    public static void main(String[] args) {
        Order order1 = Order.getInstance();

        Item book = Item.getInstance("Harry Potter and The Chamber of Secrets - book", 1, BigDecimal.valueOf(12.49), true, false);

        Item musicCD = Item.getInstance("Twice - More & More CD", 1, BigDecimal.valueOf(14.99), false, false);

        Item chocolateBar = Item.getInstance("Snickers", 1, BigDecimal.valueOf(0.85), true, false);

        TaxCalculator.getInstance().checkTaxStatus(book);
        TaxCalculator.getInstance().checkTaxStatus(musicCD);
        TaxCalculator.getInstance().checkTaxStatus(chocolateBar);

        order1.addItem(book);
        order1.addItem(musicCD);
        order1.addItem(chocolateBar);

        Receipt receipt1 = Receipt.getInstance(order1);
        System.out.println(ReceiptView.getInstance().prePrint(receipt1));

        Order order2 = Order.getInstance();

        Item boxOfChocolates = Item.getInstance("Godiva Chocolate Box", 1, BigDecimal.valueOf(10.00), true, true);

        Item perfume = Item.getInstance("Versace perfume", 1, BigDecimal.valueOf(47.50), false, true);

        TaxCalculator.getInstance().checkTaxStatus(boxOfChocolates);
        TaxCalculator.getInstance().checkTaxStatus(perfume);

        order2.addItem(boxOfChocolates);
        order2.addItem(perfume);

        Receipt receipt2 = Receipt.getInstance(order2);
        System.out.println(ReceiptView.getInstance().prePrint(receipt2));

        Order order3 = Order.getInstance();

        Item perfume2 = Item.getInstance("Chanel Perfume", 1, BigDecimal.valueOf(27.99), false, true);

        Item perfume3 = Item.getInstance("Kate Spade Perfume", 1 , BigDecimal.valueOf(18.99), false, false);

        Item pills = Item.getInstance("Headache Pills", 1, BigDecimal.valueOf(9.75), true, false);

        Item boxOfChocolate2 = Item.getInstance("Godiva Gold Chocolate Box", 1, BigDecimal.valueOf(11.25), true, true);

        TaxCalculator.getInstance().checkTaxStatus(perfume2);
        TaxCalculator.getInstance().checkTaxStatus(perfume3);
        TaxCalculator.getInstance().checkTaxStatus(pills);
        TaxCalculator.getInstance().checkTaxStatus(boxOfChocolate2);

        order3.addItem(perfume2);
        order3.addItem(perfume3);
        order3.addItem(pills);
        order3.addItem(boxOfChocolate2);

        Receipt receipt3 = Receipt.getInstance(order3);
        System.out.println(ReceiptView.getInstance().prePrint(receipt3));
    }
}
