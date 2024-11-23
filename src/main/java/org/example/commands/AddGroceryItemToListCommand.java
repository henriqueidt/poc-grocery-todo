package org.example.commands;

import org.example.GroceryItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddGroceryItemToListCommand implements Command {
    private static Map<String, GroceryItem> groceryList;

    public AddGroceryItemToListCommand(Map<String, GroceryItem> groceryList) {
        this.groceryList = groceryList;
    }

    @Override
    public void execute(GroceryItem item) {
        groceryList.put(item.getName(), item);
    }

    @Override
    public void undo(GroceryItem item) {
        groceryList.remove(item.getName());
    }

}
