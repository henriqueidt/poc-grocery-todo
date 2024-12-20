// Import necessary modules
import React, { useState, useEffect } from "react";
import axios from "axios";

// Base URL of the API
const API_BASE_URL = "http://localhost:8080";

const App = () => {
  const [todoList, setTodoList] = useState([]);
  const [newItem, setNewItem] = useState("");
  const [error, setError] = useState(null);

  // Fetch the to-do list from the API
  const fetchTodoList = async () => {
    try {
      const response = await axios.get(`${API_BASE_URL}/todo-list`);
      setTodoList(response.data);
    } catch (err) {
      setError("Failed to fetch the to-do list.");
    }
  };

  // Handle creating a new grocery item
  const createItem = async () => {
    if (!newItem.trim()) return;
    try {
      await axios.post(`${API_BASE_URL}/todo-list/create-item`, {
        name: newItem,
      });
      setNewItem(""); // Clear input
      fetchTodoList(); // Refresh list
    } catch (err) {
      setError("Failed to create a new item.");
    }
  };

  // Handle marking an item as done
  const markItemDone = async (name) => {
    try {
      await axios.put(`${API_BASE_URL}/todo-list/mark-item-done/${name}`);
      fetchTodoList(); // Refresh list
    } catch (err) {
      setError(`Failed to mark ${name} as done.`);
    }
  };

  // Handle unmarking an item as done
  const unmarkItemDone = async (name) => {
    try {
      await axios.put(`${API_BASE_URL}/todo-list/unmark-item-done/${name}`);
      fetchTodoList(); // Refresh list
    } catch (err) {
      setError(`Failed to unmark ${name} as done.`);
    }
  };

  // Handle checkbox toggle
  const toggleItemDone = async (item) => {
    if (item.done) {
      await unmarkItemDone(item.name);
    } else {
      await markItemDone(item.name);
    }
  };

  const handleUndo = async () => {
    try {
      await axios.get(`${API_BASE_URL}/todo-list/undo`);
      fetchTodoList();
    } catch (err) {
      setError("Failed to undo.");
    }
  };

  // Load to-do list on component mount
  useEffect(() => {
    fetchTodoList();
  }, []);

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>Grocery To-Do List</h1>

      {error && <p style={{ color: "red" }}>{error}</p>}

      {/* New item input */}
      <div>
        <input
          type="text"
          placeholder="Add a new grocery item"
          value={newItem}
          onChange={(e) => setNewItem(e.target.value)}
          style={{ padding: "8px", marginRight: "10px", width: "300px" }}
        />
        <button onClick={createItem} style={{ padding: "8px 16px" }}>
          Add Item
        </button>
      </div>

      {/* Display to-do list */}
      <ul style={{ listStyleType: "none", padding: 0, marginTop: "20px" }}>
        {todoList.map((item) => (
          <li
            key={item.name}
            style={{
              display: "flex",
              alignItems: "center",
              padding: "10px",
              borderBottom: "1px solid #ddd",
            }}
          >
            <input
              type="checkbox"
              checked={item.done}
              onChange={() => toggleItemDone(item)}
              style={{ marginRight: "10px" }}
            />
            <span
              style={{ textDecoration: item.done ? "line-through" : "none" }}
            >
              {item.name}
            </span>
          </li>
        ))}
      </ul>

      <button onClick={handleUndo}>Undo</button>
    </div>
  );
};

export default App;
