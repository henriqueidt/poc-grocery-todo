package org.example;

import org.example.commands.AddGroceryItemToListCommand;
//import org.example.commands.MarkGroceryItemAsDoneCommand;

import java.util.LinkedHashMap;
import java.util.Map;

public class GroceryTodoApp {
    private static Map<String, GroceryItem> groceryList = new LinkedHashMap<>();

    public GroceryItem getGroceryItem(String itemName) {
        return groceryList.get(itemName);
    }

    public void addGroceryItemToList(GroceryItem item) {
        groceryList.put(item.getName(), item);
    }

    public void removeGroceryItemFromList(GroceryItem item) {
        groceryList.remove(item.getName());
    }

    public void markItemAsDone(GroceryItem item) {
        item.setDone(true);
    }

    public void unmarkItemAsDone(GroceryItem item) {
        item.setDone(false);
    }
    
    public Map<String, GroceryItem> getList() {
        return groceryList;
    }


    public String getGroceryList() {
        StringBuilder list = new StringBuilder();
        String format = "%-15s %-10s%n";
        list.append(String.format(format, "Item Name", "Done"));
        list.append(String.format(format, "---------", "----"));
        for (GroceryItem item : groceryList.values()) {
            list.append(String.format(format, item.getName(), item.isDone()));
        }
        return list.toString();
    }

}
