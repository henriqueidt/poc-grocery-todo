package org.example.commands;

import org.example.GroceryItem;

public interface Command {
    void execute();
    void undo();
}
