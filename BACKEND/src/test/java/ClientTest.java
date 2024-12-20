import org.example.Client;
import org.example.GroceryItem;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void testAddGroceryItemToList() {
        Client app = new Client();
        app.addGroceryItemToList("Milk");

        assertEquals(1, app.getList().size());
        assertEquals("Milk", app.getList().get("Milk").getName());
        assertFalse(app.getList().get("Milk").isDone());
    }

    public void testMarkGroceryItemAsDone() {
        Client app = new Client();
        app.addGroceryItemToList("Milk");
        app.markGroceryItemAsDone("Milk");

        assertTrue(app.getList().get("Milk").isDone());
    }

    public void testUndoAddingItem() {
        Client app = new Client();
        app.addGroceryItemToList("Milk");

        assertEquals(1, app.getList().size());

        app.undo();

        assertEquals(0, app.getList().size());
    }

    public void testUndoMarkingItemAsDone() {
        Client app = new Client();
        app.addGroceryItemToList("Milk");
        app.markGroceryItemAsDone("Milk");

        assertTrue(app.getList().get("Milk").isDone());

        app.undo();

        assertFalse(app.getList().get("Milk").isDone());
    }

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
