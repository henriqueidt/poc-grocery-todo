package org.example.commands;

import org.example.GroceryItem;
import org.example.GroceryTodoApp;

public class MarkGroceryItemAsDoneCommand implements Command {
    private final GroceryTodoApp app;
    private GroceryItem lastDoneItem;

    public MarkGroceryItemAsDoneCommand(GroceryTodoApp app, GroceryItem item) {
        this.app = app;
        this.lastDoneItem = item;
    }

    @Override
    public void execute() {
        this.app.markItemAsDone(lastDoneItem);
    }

    @Override
    public void undo() {
        this.app.unmarkItemAsDone(lastDoneItem);
    }
}
