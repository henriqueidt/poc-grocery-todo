package org.example.commands;

import org.example.GroceryItem;
import org.example.GroceryTodoApp;

public class AddGroceryItemToListCommand implements Command {
    private final GroceryTodoApp app;
    private GroceryItem lastAddedItem;

    public AddGroceryItemToListCommand(GroceryTodoApp app, String itemName) {
        this.app = app;
        this.lastAddedItem = new GroceryItem(itemName);
    }

    @Override
    public void execute() {
        this.app.addGroceryItemToList(lastAddedItem);
    }

    @Override
    public void undo() {
        this.app.removeGroceryItemFromList(lastAddedItem);
    }

}
