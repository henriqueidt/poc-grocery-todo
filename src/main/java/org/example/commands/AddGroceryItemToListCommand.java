package org.example.commands;

import org.example.GroceryItem;

import java.util.Map;

public class AddGroceryItemToListCommand implements Command {
    private final Map<String, GroceryItem> groceryList;
    private GroceryItem lastAddedItem;

    public AddGroceryItemToListCommand(Map<String, GroceryItem> groceryList) {
        this.groceryList = groceryList;
    }

    @Override
    public void execute(GroceryItem item) {
        groceryList.put(item.getName(), item);
        this.lastAddedItem = item;
    }

    @Override
    public GroceryItem undo() {
        return this.groceryList.remove(lastAddedItem.getName());
    }

}
