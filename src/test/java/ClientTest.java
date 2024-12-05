import org.example.Client;
import org.example.GroceryItem;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void testMain() {
        Client app = new Client();
        app.addGroceryItemToList("Milk");
        app.addGroceryItemToList("Eggs");
        app.addGroceryItemToList("Bread");
        app.undo();
        app.markGroceryItemAsDone("Milk");
        app.markGroceryItemAsDone("Eggs");
        app.undo();

        assertEquals(2, app.getList().size());
        assertEquals(true, app.getList().get("Milk").isDone());
        assertEquals(false, app.getList().get("Eggs").isDone());
    }
}
