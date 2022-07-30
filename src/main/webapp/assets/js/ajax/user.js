var baseURL = "http://localhost:8080/Car_Rental_API_war/user";

$("#id").click(function () {
    searchUser();
})

$("#save").click(function () {
    saveUser();
})

$("#loadAll").click(function () {
    loadAllUser();
})

$("#update").click(function () {
    updateUser();
})

$("#delete").click(function () {
    deleteUser()
})


function searchUser() {
    var userId = $("#txtUserId").val();

    $.ajax({
        url: baseURL + "/" + userId,
        method: "GET",
        success: function (res) {
            if (res.code = 200) {
                var user = res.data;
                $("#txtUserId").val(user.id);
                $("#txtUserName").val(user.name);
                $("#txtUserNic").val(user.address);
                $("#txtUserAddress").val(user.address);
                $("#txtUserContact").val(user.contact);
                $("#txtUserEmail").val(user.email);
            } else {
                clearForm();
            }
        },
        error:function (ob){
            alert(ob.responseJSON.message);
        }
    });
}

function deleteUser() {
    let userId = $("#txtUserId").val();

    $.ajax({
        url: baseURL + "?id=" + userId,
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

function updateUser() {
    var userOb = {
        id: $("#txtUserId").val(),
        name: $("#txtUserName").val(),
        Nic: $("#txtUserNic").val(),
        address: $("#txtUserAddress").val(),
        passengers: $("#txtUserContact").val(),
        email: $("#txtUserEmail").val()
    }

    $.ajax({
        url: baseURL,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(userOb),
        success: function (res) {
            if (res.code == 200) {
                alert("Successfully Updated");
                loadAllUser();
                clearForm();
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function loadAllUser() {
    $("#userTable").empty();
    $.ajax({
        url: baseURL,
        method: "GET",
        success: function (resp) {
            for (const user of resp.data) {
                let row = `<tr><td>${user.id}</td><td>${user.name}</td><td>${user.nic}</td><td>${user.address}</td><td>${user.contact}</td><td>${user.email}</td></tr>`;
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

function saveUser() {
    var data = $("#userTable").serialize();
    $.ajax({
        url: baseURL,
        method: "POST",
        data: data,
        success: function (res) {
            if (res.code == 200) {
                alert("Success");
                loadAllUser();
                clearForm();
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

    function clearForm() {
        $("#txtUserId").val("");
        $("#txtUserName").val("");
        $("#txtUserNic").val("");
        $("#txtUserAddress").val("");
        $("#txtUserContact").val("");
        $("#txtUserEmail").val("");
    }
}