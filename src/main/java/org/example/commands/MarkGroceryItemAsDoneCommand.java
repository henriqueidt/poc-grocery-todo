package org.example.commands;

import org.example.GroceryItem;

public class MarkGroceryItemAsDoneCommand implements Command {
    @Override
    public void execute(GroceryItem item) {
        item.setDone(true);
    }

    @Override
    public void undo(GroceryItem item) {
        item.setDone(false);
    }
}
