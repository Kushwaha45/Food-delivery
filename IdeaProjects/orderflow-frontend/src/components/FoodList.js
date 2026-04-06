import React, { useEffect, useState } from "react";
import api from "../api";

function FoodList() {
    const [food, setFood] = useState([]);

    useEffect(() => {
        api.get("/food")
            .then(res => setFood(res.data))
            .catch(err => console.log(err));
    }, []);

    return (
        <div>
            <h2>🍔 Food Items</h2>
            {food.map(item => (
                <div key={item.foodId}>
                    {item.name} - ₹{item.price}
                </div>
            ))}
        </div>
    );
}

export default FoodList;