console.log("Loard Customer js")

const apiUrl = "http://localhost:8080/api/v1/customers";

$(document).ready(function() {
    loadCustomer();
});
function loadCustomer(){
    $.ajax({
        url: apiUrl,
        method: "GET",
        success: function (res){
            if(res.status === 200){
                const customers = res.data;   // IMPORTANT
                const tbody = $("table tbody");
                tbody.empty();

                customers.forEach(c => {
                    const row = `<tr>
                                    <td>${c.id}</td>
                                    <td>${c.name}</td>
                                    <td>${c.address}</td>
                                    <td>${c.phone}</td>
                                </tr>`;
                    tbody.append(row);
                });
            }
        },
        error:function (err){
            console.log("Error loading customers:", err);
        }
    });
}

$("#addBtn").click(function (){
    const customer = {
        id: $("#customerid").val(),
        name: $("#customername").val(),
        address: $("#customeraddress").val(),
        phone: $("#customerphonenumber").val()
    };
    $.ajax({
        url: apiUrl,
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(customer),
        success: function(res) {
            if (res.status===201){
                alert(res.message)
            }else{
                alert(" Internal server error !")
            }
            console.log(res);
            loadCustomer();
            clearForm();
        },
        error: function(err) {
            console.error("Error adding customer:", err);
        }
    });
})

$("#updateBtn").click(function () {

    const id = $("#customerid").val();

    if (!id) {
        alert("Please select a customer first!");
        return;
    }

    const customer = {
        id: id,   
        name: $("#customername").val(),
        address: $("#customeraddress").val(),
        phone: $("#customerphonenumber").val()
    };

    $.ajax({
        url: apiUrl + "/" + id,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(customer),
        success: function (res) {
            if(res.status === 200){
                alert(res.message);
                loadCustomer();
                clearForm();
            }
        },
        error: function (xhr) {
            console.error("Error updating customer:", xhr.responseText);
            alert(xhr.responseText);
        }
    });
});

$("table tbody").on("click", "tr", function() {
    const selectedRow = $(this);
    const id = selectedRow.find("td:eq(0)").text();
    const name = selectedRow.find("td:eq(1)").text();
    const address = selectedRow.find("td:eq(2)").text();
    const phone = selectedRow.find("td:eq(3)").text();

    // Fill the form inputs
    $("#customerid").val(id);
    $("#customername").val(name);
    $("#customeraddress").val(address);
    $("#customerphonenumber").val(phone);
    $(this).addClass("selected").siblings().removeClass("selected");

});

function clearForm() {
    $("#customerid").val("");
    $("#customername").val("");
    $("#customeraddress").val("");
    $("#customerphonenumber").val("");
}

$("#deleteBtn").click(function () {
    const selectedId = $("#customerid").val();

    if (!selectedId) {
        alert("Please select a customer first!");
        return;
    }

    $.ajax({
        url: apiUrl + "/" + selectedId,
        method: "DELETE",
        success: function(res) {
            if(res.status === 200){
                alert(res.message);
                loadCustomer();
                clearForm();
            }
        },
        error: function(xhr) {
            console.error("Error deleting customer:", xhr.responseText);
            alert("Failed to delete customer!");
        }
    });
});

