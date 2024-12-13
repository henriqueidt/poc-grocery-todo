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
              justifyContent: "space-between",
              padding: "10px",
              borderBottom: "1px solid #ddd",
            }}
          >
            <span
              style={{ textDecoration: item.done ? "line-through" : "none" }}
            >
              {item.name}
            </span>
            {!item.done && (
              <button
                onClick={() => markItemDone(item.name)}
                style={{ padding: "4px 8px", cursor: "pointer" }}
              >
                Mark as Done
              </button>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default App;
