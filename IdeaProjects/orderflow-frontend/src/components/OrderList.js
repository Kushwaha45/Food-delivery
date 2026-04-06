import React, { useEffect, useState } from "react";
import api from "../api";

function OrderList() {

    const [orders, setOrders] = useState([]);

    useEffect(() => {
        api.get("/orders")
            .then(res => setOrders(res.data))
            .catch(err => console.log(err));
    }, []);

    return (
        <div>
            <h2>📦 Orders</h2>

            {orders.map(order => (
                <div key={order.orderId}>
                    <b>Order #{order.orderId}</b> - ₹{order.totalPrice} - {order.status}
                    <br />
                    User: {order.user.name}
                    <hr />
                </div>
            ))}
        </div>
    );
}

export default OrderList;