import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StoreTest {
    Store target = new Store("Target");
    @Test
    @Order(0)
    public void canCreateStore(){
        try{
            assertEquals(true, (target != null));
        } catch (RuntimeException e){
            fail();
        }
    }

    @Test
    @Order(1)
    public void canAddItems(){
        try{
            target.addItems(Item.book);
            assertEquals(false, (target.itemList.isEmpty()));
        } catch (RuntimeException e){
            fail();
        }
    }
}
