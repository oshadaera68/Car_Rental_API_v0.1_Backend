var baseURL = "http://localhost:8080/Car_Rental_API_war/car";
$("#save").click(function () {
    saveVehicle();
})

$("#loadAll").click(function () {
    loadAllVehicle();
})

$("#update").click(function () {
    updateVehicle();
})

$("#delete").click(function () {
    deleteVehicle()
})

function deleteVehicle() {
    let driverId = $("#txtVehicleId").val();

    $.ajax({
        url: baseURL + "?id=" + driverId,
        method: "DELETE",
        success: function (res) {
            if (res.code == 200) {
                alert("Customer Successfully Deleted");
                loadAllDriver();
                clearForm();
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function updateVehicle() {
    var driverOb = {
        id: $("#txtVehicleId").val(),
        name: $("#txtVehicleName").val(),
        transmission: $("#selectTransmission").val(),
        fuel: $("#selectFuel").val(),
        passengers: $("#txtNoOfPassengers").val(),
        brand: $("#txtBrand").val()
    }

    $.ajax({
        url: baseURL,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(driverOb),
        success: function (res) {
            if (res.code == 200) {
                alert("Successfully Updated");
                loadAllVehicle();
                clearForm();
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function loadAllVehicle() {
    $("#vehicleTable").empty();
    $.ajax({
        url: baseURL,
        method: "GET",
        success: function (resp) {
            for (const vehicle of resp.data) {
                let row = `<tr><td>${vehicle.id}</td><td>${vehicle.name}</td><td>${vehicle.transmissionType}</td><td>${vehicle.fuelType}</td><td>${vehicle.noOfPassengers}</td><td>${vehicle.brand}</td></tr>`;
                $("#vehicleTable").append(row);
            }
            bindClickEvents();
            clearForm();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function saveVehicle() {
    var data = $("#vehicleTable").serialize();
    $.ajax({
        url: baseURL,
        method: "POST",
        data: data,
        success: function (res) {
            if (res.code == 200) {
                alert("Success");
                loadAllVehicle()
                clearForm();
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

    function clearForm() {
        $("#txtVehicleId").val("");
        $("#txtVehicleName").val("");
        $("#selectTransmission").val("");
        $("#selectFuel").val("");
        $("#txtNoOfPassengers").val("");
        $("#txtBrand").val("");
    }
}