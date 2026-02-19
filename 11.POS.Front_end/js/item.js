console.log("Load Item JS");

const apiUrl = "http://localhost:8080/api/v1/items";

$(document).ready(function() {
    loadItems();
});

function loadItems(){
    $.ajax({
        url: apiUrl,
        method: "GET",
        success: function (items){
            const tbody = $("table tbody");
            tbody.empty();

            items.forEach(i => {
                const row = `<tr>
                                <td>${i.itemId}</td>
                                <td>${i.itemName}</td>
                                <td>${i.qty}</td>
                                <td>${i.buyPrice}</td>
                                <td>${i.sellPrice}</td>
                            </tr>`;
                tbody.append(row);
            });
        },
        error:function (err){
            console.log("Error loading items:",err)
        }
    });
}

$("#addBtn").click(function (){
    const item = {
        itemId: $("#itemid").val(),
        itemName: $("#itemname").val(),
        qty: parseInt($("#itemqty").val()),
        buyPrice: parseFloat($("#itembuyprice").val()),
        sellPrice: parseFloat($("#itemsellprice").val())
    };

    $.ajax({
        url: apiUrl,
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(item),
        success: function() {
            alert("Item Added!");
            loadItems();
            clearForm();
        },
        error: function(err) {
            console.error("Error adding item:", err);
        }
    });
});

$("#updateBtn").click(function () {

    const id = $("#itemid").val();

    if (!id) {
        alert("Please select an item first!");
        return;
    }

    const item = {
        itemId: id,
        itemName: $("#itemname").val(),
        qty: parseInt($("#itemqty").val()),
        buyPrice: parseFloat($("#itembuyprice").val()),
        sellPrice: parseFloat($("#itemsellprice").val())
    };

    $.ajax({
        url: apiUrl + "/" + id,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(item),
        success: function () {
            alert("Item Updated Successfully!");
            loadItems();
            clearForm();
        },
        error: function (xhr) {
            console.error("Update Error:", xhr.responseText);
            alert("Update Failed!");
        }
    });
});


$("#deleteBtn").click(function () {
    const selectedId = $("#itemid").val();

    if (!selectedId) {
        alert("Please select an item first!");
        return;
    }

    $.ajax({
        url: apiUrl + "/" + selectedId,
        method: "DELETE",
        success: function() {
            alert("Item Deleted!");
            loadItems();
            clearForm();
        },
        error: function(xhr) {
            console.error("Error deleting item:", xhr.responseText);
        }
    });
});

$("table tbody").on("click", "tr", function() {

    const selectedRow = $(this);

    const id = selectedRow.find("td:eq(0)").text();
    const name = selectedRow.find("td:eq(1)").text();
    const qty = selectedRow.find("td:eq(2)").text();
    const buy = selectedRow.find("td:eq(3)").text();
    const sell = selectedRow.find("td:eq(4)").text();

    $("#itemid").val(id);
    $("#itemname").val(name);
    $("#itemqty").val(qty);
    $("#itembuyprice").val(buy);
    $("#itemsellprice").val(sell);

    $(this).addClass("selected").siblings().removeClass("selected");
});

function clearForm() {
    $("#itemid").val("");
    $("#itemname").val("");
    $("#itemqty").val("");
    $("#itembuyprice").val("");
    $("#itemsellprice").val("");
}
