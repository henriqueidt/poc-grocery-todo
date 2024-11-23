package org.example;

public class Main {
    public static void main(String[] args) {
        GroceryTodoApp app = new GroceryTodoApp();

        app.addGroceryItemToList("Milk");
        app.addGroceryItemToList("Eggs");
        app.addGroceryItemToList("Bread");

        app.markGroceryItemAsDone("Milk");

        System.out.println(app.getGroceryList());



    }
}