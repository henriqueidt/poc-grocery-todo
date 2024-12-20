package org.example;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class TodoController {

    Client app = new Client();

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/todo-list")
    public List<GroceryItem> get() {
        return new ArrayList<>(app.getList().values());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/todo-list/create-item")
    public void add(@NotNull @RequestBody GroceryItem item) {
        app.addGroceryItemToList(item.getName().toLowerCase());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/todo-list/mark-item-done/{name}")
    public void markDone(@PathVariable String name) {
        app.markGroceryItemAsDone(name.toLowerCase());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/todo-list/unmark-item-done/{name}")
    public void unmarkDone(@PathVariable String name) { app.unmarkGroceryItemAsDone(name.toLowerCase()); }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/todo-list/undo")
    public void undo() { app.undo(); }
}
