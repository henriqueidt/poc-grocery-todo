package org.example;

public class Main {
    public static void main(String[] args) {
        Client app = new Client();

        app.addGroceryItemToList("Milk");
        app.addGroceryItemToList("Eggs");
        app.addGroceryItemToList("Bread");

        app.undo();

        app.markGroceryItemAsDone("Milk");
        app.markGroceryItemAsDone("Eggs");

        app.undo();

        System.out.println(app.getGroceryList());



    }
}