$(document).ready(function(){
getData();
    });

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
                        var columnRow = "<tr><td>" + value.id + "</td><td>" +
                        value.firstName + "</td><td>" +
                        value.lastName + "</td><td>" +
                        value.address + "</td><td>" +
                        value.country + "</td><td>" +
                        value.town + "</td><td>" +
                         value.postalCode + "</td><td>" +
                         value.telephoneNumber + "</td><td>" +
                         value.emailAddress + "</td><td>" +
                         "<button type='button' class='btn btn-danger' data-dismiss='modal' data-target='#modalDelete'  name='deleted[]' id='" + value.id + "' onclick='deleteGuest(this)';> Delete </button>" + "</td><td>" +
                         "<button type='button' class='btn btn-info' data-dismiss='modal' data-target='#editGuestModal' id='value.id' onclick='editGuest(" + value.id + ")'> Edit </button>" + "</td></tr>";



                        guestList+=columnRow;
                    });
             $("#guestTable").html(guestList);
        }
    });
}

//<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="postData();">Add</button>
// remove data by POST information to java //url delete
function deleteGuest(obj){

    //$("#deleteThisGuest").html("Are you sure you want to delete guest #" + id + "?");
    console.log("you are going to delete");
    // popup deleteGuestModal
    $('#modalDelete').modal('show');

   //remember the information from that table
    // you want to data from id=deleted after the button is pushed

                         var idDeleted = $(obj).attr("id");
                         console.log(idDeleted);
                         $("#finalDelete").click(function(){
                            console.log("final delete");
                            $.ajax({
                                url: "http://localhost:8080/api/guest/"+idDeleted,
                                type:"delete",
                                contentType: "application/json",
                                success:function(){
                                    console.log("Deletion is initiated");
                                    $("#guestTable").html("");
                                    getData();
                                }
                            });
                         });

}
//


// begin edit guest

function editModalValues(){
    $("#guestEdit").val("");
}

function editGuest(id){
    console.log("Trying to edit data");
    console.log("Dit is ID: " + id);


    $('#editGuestModal').modal('show');


    $("#finalEdit").click(function(){
    console.log("clicked Edit");

     //$("#lastnameEdit").val(value.lastName);
     //$("#firstnameEdit").val(value.firstName);
     //$("#addressEdit").val(value.address);
     //$("#countryEdit").val(value.country);
     //$("#postalcodeEdit").val(value.postalCode);
     //$("#telephoneNumberEdit").val(value.telephoneNumber);
     //$("#emailAddressEdit").val(value.emailAddress);



    var inputID = id;
    var inputLastname = $("#lastnameEdit").val();
    var inputFirstname = $("#firstnameEdit").val();
    var inputAddress = $("#addressEdit").val();
    var inputPostalcode = $("#postalcodeEdit").val();
    var inputTown = $("#townEdit").val();
    var inputCountry = $("#countryEdit").val();
    var inputTelephonenumber = $("#telephonenumberEdit").val();
    var inputEmail = $("#emailEdit").val();

    console.log(inputID);

    var newGuestUpdateObject = {
                id : inputID,
                lastName : inputLastname,
                firstName : inputFirstname,
                address : inputAddress,
                postalCode : inputPostalcode,
                town : inputTown,
                country : inputCountry,
                telephoneNumber : inputTelephonenumber,
                emailAddress : inputEmail
                };
    console.log(newGuestUpdateObject);
    var newGuestUpdate = JSON.stringify(newGuestUpdateObject);
    console.log(newGuestUpdate);


    $.ajax({
        url : "http://localhost:8080/api/guest/edit/"+id,
        type : "put",
        data : newGuestUpdate,
        contentType : "application/json",
        success : function(data){
            console.log("successful put")

            getData();
        }

    });
    });
};

// einde van edit guest


// begin van add new guest
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

//    alert(inputsearchTerm);
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
        url : "http://localhost:8080/api/guest/search/"+inputsearchTerm,
        type : "get",
        contentType : "application/json",
        success : function(data) {
            console.log("na de get");
            console.log(data);
            $("#searchTerm").val("");
            var guestSearch = '';

            $.each(data, function(index, value){
                        var columnRow = "<tr><td>" + value.id + "</td><td>" +
                        value.firstName + "</td><td>" +
                        value.lastName + "<td>" + value.address + "</td><td>" + value.country +
                        "</td><td>" + value.town + "</td><td>" + value.postalCode + "</td><td>" +
                         value.telephoneNumber + "</td><td>" + value.emailAddress + "</td><td>" +
                         "<button type='button' class='btn btn-danger' data-dismiss='modal' data-target='#modalDelete'  name='deleted[]' id='" + value.id + "' onclick='deleteGuest(this)';> Delete </button>" + "</td><td>" +
                         "<button type='button' class='btn btn-info' data-dismiss='modal' data-target='#editGuestModal' id='value.id' onclick='editGuest(" + value.id + ")'> Edit </button>" + "</td></tr>";


                         guestSearch+=columnRow;
                    });
             $("#guestTable").html(guestSearch);
        }
    });
}


