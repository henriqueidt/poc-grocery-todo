package org.example.commands;

import org.example.GroceryItem;

public class MarkGroceryItemAsDoneCommand implements Command {
    private GroceryItem lastDoneItem;

    @Override
    public void execute(GroceryItem item) {
        item.setDone(true);
        this.lastDoneItem = item;
    }

    @Override
    public GroceryItem undo() {
        lastDoneItem.setDone(false);
        return null;
    }
}
