import React, { useState } from "react";
import api from "../api";

function OrderForm() {

    const [userId, setUserId] = useState("");
    const [foodId, setFoodId] = useState("");
    const [quantity, setQuantity] = useState("");

    const placeOrder = () => {

        const order = {
            totalPrice: 500,
            status: "PLACED",
            user: { userId: Number(userId) },
            items: [
                {
                    quantity: Number(quantity),
                    food: { foodId: Number(foodId) }
                }
            ]
        };

        api.post("/orders", order)
            .then(() => alert("✅ Order Placed"))
            .catch(err => console.log(err));
    };

    return (
        <div>
            <h2>🛒 Place Order</h2>

            <input placeholder="User ID"
                   onChange={e => setUserId(e.target.value)} />

            <input placeholder="Food ID"
                   onChange={e => setFoodId(e.target.value)} />

            <input placeholder="Quantity"
                   onChange={e => setQuantity(e.target.value)} />

            <button onClick={placeOrder}>Order</button>
        </div>
    );
}

export default OrderForm;