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
        url : "http://localhost:8080/api/guest/saved",
        type : "post",
        data : newGuest,
        contentType : "application/json",
        success : function(data) {
            $("#lastname").val("");
            $("#firstname").val("");
            $("#address").val("");
            $("#postalcode").val("");
            $("#town").val("");
            $("#country").val("");
            $("#telephonenumber").val("");
            $("#email").val("");

        }
    });
}


