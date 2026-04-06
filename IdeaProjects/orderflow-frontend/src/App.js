import React from "react";
import FoodList from "./components/FoodList";
import OrderForm from "./components/OrderForm";
import OrderList from "./components/OrderList";

function App() {
  return (
      <div style={{ padding: "20px" }}>
        <h1>🚀 OrderFlow App</h1>

        <FoodList />
        <hr />

        <OrderForm />
        <hr />

        <OrderList />
      </div>
  );
}

export default App;