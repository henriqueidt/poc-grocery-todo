package org.example;

import org.example.commands.AddGroceryItemToListCommand;
import org.example.commands.Command;
import org.example.commands.MarkGroceryItemAsDoneCommand;

import java.util.LinkedHashMap;
import java.util.Map;

public class GroceryTodoApp {
    private static Map<String, GroceryItem> groceryList = new LinkedHashMap<>();

    public void addGroceryItemToList(String itemName) {
        GroceryItem item = new GroceryItem(itemName);
        AddGroceryItemToListCommand addCommand = new AddGroceryItemToListCommand(groceryList);
        addCommand.execute(item);
    }

    public void markGroceryItemAsDone(String itemName) {
        MarkGroceryItemAsDoneCommand markItemDone = new MarkGroceryItemAsDoneCommand();
        GroceryItem item = groceryList.get(itemName);
        markItemDone.execute(item);
    }

    public String getGroceryList() {
        StringBuilder list = new StringBuilder();
        for (GroceryItem item : groceryList.values()) {
            list.append(item.toString()).append("\n");
        }
        return list.toString();
    }
}
