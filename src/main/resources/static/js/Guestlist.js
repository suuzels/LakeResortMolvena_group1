// get data for the table
function getData() {
    console.log("i am in getting data for list")
    $.ajax({
        url:"http://localhost:8080/api/guest/get",
        type:"get",
        success : function(data){
            console.log("in success")
            console.log(data);
            var guestList = '';

            $.each(data, function(index, value){
                        var columnRow = "<tr><td>" + value.firstName + "</td><td>" +
                        value.lastName + "<td>" + value.address + "</td><td>" + value.country +
                        "</td><td>" + value.town + "</td><td>" + value.postalCode + "</td><td>" +
                         value.telephoneNumber + "</td><td>" + value.emailAddress + "</td><td>" +
                         "<button type='button' class='btn btn-danger' data-dismiss='modal' onclick='editGuest(" + value.FirstName + ")'> Edit </button>" + "</td><td>" +
                         "<button type='button' class='btn btn-danger' id='deleted' onclick='deleteGuest(" + value.FirstName + ")'> Delete </button>" + "</td></tr>";

                        guestList+=columnRow;
                    });
             $("#guest").append(guestList);
        }
    });
}

//<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="postData();">Add</button>
// remove data by POST information to java //url delete
function deleteGuest(){
    console.log("you are going to edit");

    // first illustrate delete in a pop up modal
    // popup deleteGuestModal
    $('#deleteGuestModal').modal('show');

   //remember the information from that table
    // you want to data from id=deleted after the button is pushed
//    var table = $('#guest').DataTable();
//    console.log(table);
//    console.log( table.row( this ).data());

}

function finalDeleteData(){
    console.log("you are going to delete");
                    $.ajax({
                        url : "http://localhost:8080/api/guests/delete",
                        type : "delete",
                        contentType : "application/json",
                        success : function() {
                            console.log("Delete is initiated");
                            $("#guest").html("");

                        }
                    })
                    getData();
}

function editGuest(){
    console.log("you are going to edit");
}

getData();
// post data into java
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



// search all the data
function searchData() {
    console.log("you clicked");
    var inputsearchTerm = $("#searchTerm").val();


    console.log(inputsearchTerm);

    if(inputsearchTerm == "") {
        $("#errorMessage").val("Fill in search term.")
        return;
    }

    var newsearchObject = {
        searchTerm : inputsearchTerm,
    };

    console.log("new search object")
    console.log(newsearchObject);

    var newSearch = JSON.stringify(newsearchObject);
    console.log("new search")
    console.log(newSearch);

    $.ajax({
        url : "http://localhost:8080/api/search/{searchTerm}",
        type : "post",
        data : newSearch,
        contentType : "application/json",
        success : function(data) {

            console.log(data);
            $("#searchTerm").val("");
            $.each(data, function(index, value){
                        var columnRow = "<tr><td><input type='checkbox' id='checkbox' </td><td>" + value.firstName + "</td><td>" +
                        value.lastName + "<td>" + value.address + "</td><td>" + value.country +
                        "</td><td>" + value.town + "</td><td>" + value.postalCode + "</td><td>" +
                         value.telephoneNumber + "</td><td>" + value.emailAddress + "</td></tr>";
                        guestList+=columnRow;
                    });
             $("#guest").append(searchResults);
        }
    });
}


