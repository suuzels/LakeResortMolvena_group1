$(document).ready(function(){
getData();
    });

// get data for the table: tonen van guest list op scherm

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
                        var firstnameID = "firstname" +(value.id);
                        var lastnameID = "lastname" +(value.id);
                        var addressID = "address" +(value.id);
                        var countryID = "country" +(value.id);
                        var townID = "town" +(value.id);
                        var postalcodeID = "postcalcode" + (value.id);
                        var telephonenumberID= "telephonennumber" +(value.id);
                        var emailAddressID  = "email" +(value.id);

                        console.log(firstnameID);
                        var columnRow = "<tr><td id='"+ firstnameID+ "'>" +
                        value.firstName + "</td><td id='"+ lastnameID+ "'>" +
                        value.lastName + "</td><td id='"+ addressID +"'>" +
                        value.address + "</td><td id='"+ countryID + "'>" +
                        value.country + "</td><td id='"+ townID + "'>" +
                        value.town + "</td><td id='"+ postalcodeID + "'>" +
                        value.postalCode + "</td><td id='"+ telephonenumberID + "'>" +
                        value.telephoneNumber + "</td><td id='"+ emailAddressID + "'>" +
                        value.emailAddress + "</td><td>" +

                        "<button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteGuestModal' id='" + value.id + "' onclick='deleteGuest(" + value.id + ")'> Delete </button>" + "</td><td>" +
                        "<button type='button' class='btn btn-info' data-toggle='modal' data-target='#editGuestModal' id='" + value.id + "' onclick='editGuest(" + value.id + ")'> Edit </button>" + "</td></tr>";
                        console.log(value.firstName + value.id);
                        guestList+=columnRow;
                    });
             $("#guestTable").html(guestList);
        }
    });
}

function deleteGuest(id){
   var name1 = "";
   var namelast = "";

   $("#guestTable").each(function(){
        var firstname = '#firstname' + id;
        console.log(firstname);
        name1 = $(firstname).html();
        var lastname = '#lastname' + id;
        namelast = $(lastname).html();
        console.log(lastname);
   });

    $("#deleteThisGuest").html("Are you sure you want to delete guest " + name1 + " " + namelast +"?");
    $("#finalDelete").click(function(){
    $.ajax({
        url : "http://localhost:8080/api/guest/"+id,
        type : "delete",
        contentType : "application/json",
        success : function() {
            console.log("Deletion is initiated");
            $("#guestTable").html("");
            getData();
        }

    });
});
}



function editGuest(id){


 var name1 = "";
   var namelast = "";
   var nametown ="";
   var nameaddress="";
   var namepostal="";
   var namecountry="";
   var namephone= "";
   var namemail= "";

   $("#guestTable").each(function(){
        var firstname = '#firstname' + id;
        console.log(firstname);
        name1 = $(firstname).html();

        var lastname = '#lastname' + id;
        namelast = $(lastname).html();
        console.log(lastname);

        var town = '#town' + id;
        nametown = $(town).html();
        console.log(nametown);

        var address = '#address' + id;
        nameaddress = $(address).html();
        console.log(nameaddress);

        var postalcode = '#postcalcode' + id;
        namepostal =$(postalcode).html();
        console.log(namepostal);

        var country = '#country' +id;
        namecountry = $(country).html();
        console.log(namecountry);

        var telephonenumber = '#telephonennumber' + id;
        namephone = $(telephonenumber).html();
        console.log(namephone);

        var email = '#email' +id;
        namemail = $(email).html();
        console.log(namemail);

   });


    console.log("Change placeholder")
//    $("#firstnameEdit").attr('placeholder', 'some text');
    $("#firstnameEdit").val(name1);
    $("#lastnameEdit").val(namelast);
      $("#addressEdit").val(nameaddress);
      $("#postalcodeEdit").val(namepostal);
      $("#townEdit").val(nametown);
      $("#countryEdit").val(namecountry);
      $("#telephonenumberEdit").val(namephone);
      $("#emailEdit").val(namemail);



    //$('#editGuestModal').modal('show');

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

      if(inputLastname == "" ||inputFirstname == "" || inputTelephonenumber == "" || inputEmail == "") {
                $("#errorMessage").val("Fill in last name.");
                return;
            }


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
            location.reload();
        }

    });
    });
};

// einde van edit guest


// begin van add new guest:
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

    if(inputLastname == "" ||inputFirstname == "" || inputTelephonenumber == "" || inputEmail == "") {
        $("#errorMessage").val("Fill in last name.");
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
// einde van "add new guest"

// begin search guest
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
                         var firstnameID = "firstname" +(value.id);
                                                var lastnameID = "lastname" +(value.id);
                                                var addressID = "address" +(value.id);
                                                var countryID = "country" +(value.id);
                                                var townID = "town" +(value.id);
                                                var postalcodeID = "postcalcode" + (value.id);
                                                var telephonenumberID= "telephonennumber" +(value.id);
                                                var emailAddressID  = "email" +(value.id);

                                                console.log(firstnameID);
                                                var columnRow = "<tr><td id='"+ firstnameID+ "'>" +
                                                value.firstName + "</td><td id='"+ lastnameID+ "'>" +
                                                value.lastName + "</td><td id='"+ addressID +"'>" +
                                                value.address + "</td><td id='"+ countryID + "'>" +
                                                value.country + "</td><td id='"+ townID + "'>" +
                                                value.town + "</td><td id='"+ postalcodeID + "'>" +
                                                value.postalCode + "</td><td id='"+ telephonenumberID + "'>" +
                                                value.telephoneNumber + "</td><td id='"+ emailAddressID + "'>" +
                                                value.emailAddress + "</td><td>" +

                                                "<button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteGuestModal' id='" + value.id + "' onclick='deleteGuest(" + value.id + ")'> Delete </button>" + "</td><td>" +
                                                "<button type='button' class='btn btn-info' data-toggle='modal' data-target='#editGuestModal' id='" + value.id + "' onclick='editGuest(" + value.id + ")'> Edit </button>" + "</td></tr>";
                                                console.log(value.firstName + value.id);
                         guestSearch+=columnRow;
                    });
             $("#guestTable").html(guestSearch);
        }
    });
}

