package org.example;

public class GroceryItem {
    private String name;
    private boolean isDone = false;

    public GroceryItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return name + " (Done: " + isDone + ")";
    }
}
