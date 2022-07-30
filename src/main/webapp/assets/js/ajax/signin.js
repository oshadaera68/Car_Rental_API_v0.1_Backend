/*
var baseURL = "http://localhost:8080/Car_Rental_API_war/guest/user";

$("#btn").click(function () {
    saveUser();
})

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
}*/
