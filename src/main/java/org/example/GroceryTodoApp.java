package org.example;

import org.example.commands.AddGroceryItemToListCommand;
import org.example.commands.MarkGroceryItemAsDoneCommand;

import java.util.LinkedHashMap;
import java.util.Map;

public class GroceryTodoApp {
    private static Map<String, GroceryItem> groceryList = new LinkedHashMap<>();
    private AddGroceryItemToListCommand addCommand = new AddGroceryItemToListCommand(groceryList);

    public void addGroceryItemToList(String itemName) {
        GroceryItem item = new GroceryItem(itemName);
        addCommand.execute(item);
    }

    public String undoAddGroceryItemToList() {
        return addCommand.undo().getName();
    }

    public void markGroceryItemAsDone(String itemName) {
        MarkGroceryItemAsDoneCommand markItemDone = new MarkGroceryItemAsDoneCommand();
        GroceryItem item = groceryList.get(itemName);
        markItemDone.execute(item);
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
