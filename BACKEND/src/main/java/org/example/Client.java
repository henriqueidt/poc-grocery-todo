package org.example;

import org.example.commands.AddGroceryItemToListCommand;
import org.example.commands.Command;
import org.example.commands.MarkGroceryItemAsDoneCommand;

import java.util.Map;
import java.util.Stack;

public class Client {
    private static GroceryTodoApp app = new GroceryTodoApp();
//    private static Command lastExecutedCommand;
    private static Stack<Command> commandStack = new Stack<>();

    public static void addGroceryItemToList(String itemName) {
        Command command = new AddGroceryItemToListCommand(app, itemName);
        command.execute();
//        lastExecutedCommand = command;
        commandStack.push(command);
    }

    public static void markGroceryItemAsDone(String itemName) {
        Command command = new MarkGroceryItemAsDoneCommand(app, app.getGroceryItem(itemName));
        command.execute();
//        lastExecutedCommand = command;
        commandStack.push(command);
    }

    public static void unmarkGroceryItemAsDone(String itemName) {
        Command command = new MarkGroceryItemAsDoneCommand(app, app.getGroceryItem(itemName));
        command.undo();
//        lastExecutedCommand = command;
        commandStack.push(command);
    }

    public static void undo() {
        if (!commandStack.isEmpty()) {
            Command lastExecutedCommand = commandStack.pop();
            lastExecutedCommand.undo();
        }
    }

    public static Map<String, GroceryItem> getList() {
        return app.getList();
    }

    public static String getGroceryList() {
        return app.getGroceryList();
    }
}
