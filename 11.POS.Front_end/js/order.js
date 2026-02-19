console.log("Load Order JS");

const customerApi = "http://localhost:8080/api/v1/customers";
const itemApi = "http://localhost:8080/api/v1/items";
const orderApi = "http://localhost:8080/api/v1/orders";

let cart = [];

function loadItems() {
    $.ajax({
        url: itemApi,
        method: "GET",
        success: function(res) {
            const items = res.data || res;
            const select = $("#selectItem");
            select.empty();
            select.append('<option value="">-- Select Item --</option>');

            items.forEach(item => {
                select.append(`<option value="${item.itemId}" 
                    data-name="${item.itemName}" 
                    data-price="${item.sellPrice}" 
                    data-qty="${item.qty}">
                    ${item.itemName}
                </option>`);
            });
            resetItemInfo();
        },
        error: function(err) {
            console.error("Error loading items:", err);
        }
    });
}

function resetItemInfo() {
    $("#itemName").text("");
    $("#availableQty").text("");
    $("#itemPrice").text("");
}

$("#selectItem").change(function() {
    const selected = $("#selectItem option:selected");
    if (!selected.val()) return resetItemInfo();

    $("#itemName").text(selected.data("name"));
    $("#availableQty").text(selected.data("qty"));
    $("#itemPrice").text(selected.data("price"));
});

$("#searchBtn").click(function() {
    const id = $("#searchCustomer").val().trim();
    if (!id) return alert("Enter Customer ID!");

    $.ajax({
        url: `${customerApi}/${id}`,
        method: "GET",
        success: function(res) {
            const cust = res.data || res;
            if (!cust) {
                alert("Customer not found!");
                return resetCustomerInfo();
            }
            $("#cusid").text(cust.id || cust.customerId);
            $("#cusname").text(cust.name || cust.customerName);
            $("#cusaddress").text(cust.address);
        },
        error: function() {
            alert("Customer not found!");
            resetCustomerInfo();
        }
    });
});

function resetCustomerInfo() {
    $("#cusid").text("");
    $("#cusname").text("");
    $("#cusaddress").text("");
}

$("#addToCartBtn").click(function() {
    const selected = $("#selectItem option:selected");
    const qty = parseInt($("#orderQty").val());

    if (!selected.val()) return alert("Select an item!");
    if (!qty || qty <= 0) return alert("Enter valid quantity!");

    const availableQty = parseInt(selected.data("qty"));
    if (qty > availableQty) return alert("Quantity exceeds stock!");

    const existing = cart.find(i => i.id === selected.val());
    if (existing) {
        existing.qty += qty;
    } else {
        cart.push({
            id: selected.val(),
            name: selected.data("name"),
            qty: qty,
            price: parseFloat(selected.data("price"))
        });
    }

    renderCart();
    $("#orderQty").val("");
    $("#selectItem").val("");
    resetItemInfo();
});

function renderCart() {
    const tbody = $("#cartTable");
    tbody.empty();
    let total = 0;

    cart.forEach(item => {
        const rowTotal = item.qty * item.price;
        total += rowTotal;

        tbody.append(`<tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.qty}</td>
            <td>${item.price.toFixed(2)}</td>
            <td>${rowTotal.toFixed(2)}</td>
        </tr>`);
    });

    $("#grandTotal").text(total.toFixed(2));
}

$("#placeOrderBtn").click(function() {
    const customerId = $("#cusid").text();
    if (!customerId) return alert("Select customer!");
    if (cart.length === 0) return alert("Cart is empty!");

    const paymentType = $("#paymentType").val() || "CASH";

    const orderDTO = {
        orderId: "ORD-" + new Date().getTime(),
        customerId: customerId,
        paymentType: paymentType,
        total: cart.reduce((sum, i) => sum + i.qty * i.price, 0),
        orderDetails: cart.map(i => ({ itemId: i.id, qty: i.qty, price: i.price }))
    };

    $.ajax({
        url: orderApi,
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(orderDTO),
        success: function(res) {
            alert(res.message || "Order placed successfully!");
            resetOrderForm();
        },
        error: function(err) {
            alert("Failed to place order!");
            console.error(err);
        }
    });
});

$("#updateOrderBtn").click(function() {
    const orderId = $("#orderId").val();
    const customerId = $("#cusid").text();
    if (!orderId) return alert("Enter Order ID!");
    if (!customerId) return alert("Select customer!");
    if (cart.length === 0) return alert("Cart is empty!");

    const paymentType = $("#paymentType").val() || "CASH";

    const orderDTO = {
        customerId: customerId,
        paymentType: paymentType,
        total: cart.reduce((sum, i) => sum + i.qty * i.price, 0),
        orderDetails: cart.map(i => ({ itemId: i.id, qty: i.qty, price: i.price }))
    };

    $.ajax({
        url: orderApi + "/" + orderId,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(orderDTO),
        success: function(res) {
            alert(res.message || "Order updated successfully!");
            resetOrderForm();
        },
        error: function(err) {
            alert("Failed to update order!");
            console.error(err);
        }
    });
});

$("#deleteOrderBtn").click(function() {
    const orderId = $("#orderId").val();
    if (!orderId) return alert("Enter Order ID!");

    $.ajax({
        url: orderApi + "/" + orderId,
        method: "DELETE",
        success: function(res) {
            alert(res.message || "Order deleted successfully!");
            resetOrderForm();
        },
        error: function(err) {
            alert("Failed to delete order!");
            console.error(err);
        }
    });
});

function resetOrderForm() {
    cart = [];
    renderCart();
    resetCustomerInfo();
    $("#orderId").val("");
    $("#selectItem").val("");
    resetItemInfo();
}

$(document).ready(function() {
    loadItems();
});
