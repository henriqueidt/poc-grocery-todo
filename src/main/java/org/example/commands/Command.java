package org.example.commands;

import org.example.GroceryItem;

public interface Command {
    void execute(GroceryItem item);
    GroceryItem undo();
}
