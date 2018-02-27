

function getData() {
    $.ajax({
        url:"http://localhost:8080/api/guest/get",
        type:"get",
        success : function(data){
            console.log(data);
            var guestList = '';

            $.each(data, function(index, value){
                        var columnRow = "<tr><td>" + value.firstName + "</td><td>" +
                        value.lastName + "<td>" + value.address + "</td><td>" + value.country +
                        "</td><td>" + value.town + "</td><td>" + value.postalCode + "</td><td>" +
                         value.telephoneNumber + "</td><td>" + value.emailAddress + "</td><td>" +
                         "<button type='button' class='btn btn-danger' onclick='editRoom(" + value.FirstName + ")'> Edit </button>" + "</td><td>" +
                         "<button type='button' class='btn btn-danger' onclick='deleteRoom(" + value.FirstName + ")'> Delete </button>" + "</td></tr>";

                        guestList+=columnRow;
                    });

             $("#guest").append(guestList);
        }
    });
}

getData();

function postData() {
    var inputLastname = $("#lastname").val();
    var inputFirstname = $("#firstname").val();
    var inputAddress = $("#address").val();
    var inputPostalcode = $("#postalcode").val();
    var inputTown = $("#town").val();
    var inputCountry = $("#country").val();
    var inputTelephonenumber = $("#telephonenumber").val();
    var inputEmail = $("#email").val();

    if(inputLastname == "") {
        $("#errorMessage").val("Fill in last name.")
        return;
    }

    if(inputFirstname == "") {
        $("#errorMessage").val("Fill in first name.")
        return;
    }

    if(inputAddress == "") {
        $("#errorMessage").val("Fill in address.")
        return;
    }

    if(inputPostalcode == "") {
        $("#errorMessage").val("Fill in postal code.")
        return;
    }

    if(inputTown == "") {
        $("#errorMessage").val("Fill in town.")
        return;
    }

    if(inputTelephonenumber == "") {
        $("#errorMessage").val("Fill in telephone number.")
        return;
    }

    if(inputEmail == "") {
        $("#errorMessage").val("Fill in e-mail.")
        return;
    }

    var newGuestObject = {
        lastName : inputLastname,
        firstName : inputFirstname,
        address : inputAddress,
        postalCode : inputPostalcode,
        town : inputTown,
        country : inputCountry,
        telephoneNumber : inputTelephonenumber,
        emailAddress : inputEmail
    };

    var newGuest = JSON.stringify(newGuestObject);
    console.log(newGuest);

    $.ajax({
        url : "http://localhost:8080/api/guest/change",
        type : "post",
        data : newGuest,
        contentType : "application/json",
        success : function(data) {
        console.log("succes post van guest!");
            $("#lastname").val("");
            $("#firstname").val("");
            $("#address").val("");
            $("#postalcode").val("");
            $("#town").val("");
            $("#country").val("");
            $("#telephonenumber").val("");
            $("#email").val("");
            getData();
        }
    });
}




////when click on checkbox, go to alter website
//$(document).ready(function(){
//    $("#alterBtn").click(function(){
//        $("#checkbox").trigger("select");
//        location.href="http://localhost:8080/alterguest.html";
//    });
//
//});

//
//function alterData() {
//      //iterate over the table to find the checkbox
// $("#alterBtn").click(function(){
//      $("#guest tr").each(function(){
//
//          $("input:checked").each(function(){
//
//              console.log("found");
//
//          });
//      });
//
//      });
//}