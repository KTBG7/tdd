
import java.util.ArrayList;

public class Store{
    private String name;
    private double price;
    public ArrayList<Item> itemList;


    public Store(String name) {
        this.name = name;
    }

    public ArrayList addItems(Item item){
        itemList.add(item);
        return itemList;
    }

    public ArrayList getItems() {
        return itemList;
    }
}