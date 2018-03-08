$(document).ready(function(){
getData();
searchListOfRooms();
searchAllGuests();
    });

function searchAllGuests(){
    console.log("Trying to find existing guests...")

    $.ajax({
        url : "http://localhost:8080/api/guest/get",
        type : "get",
        contentType : "application/json",
        success : function(data){
            console.log("Successfully found guests.")

            var guestSearch = "";
            $.each(data, function(index, value){
                var searchGuestItem = "<option>" + value.lastName + ", " + value.firstName + "</option>"
                guestSearch += searchGuestItem;
            });

            $("#bookingGuestSelect").html(guestSearch);
            $("#bookingGuestEdit").html(guestSearch);
        }

    });

}

function searchListOfRooms(){
    console.log("Trying to find available rooms");

        var searchBool = false;


        $.ajax({
            url : "http://localhost:8080/api/rooms/available/"+searchBool,
            type : "get",
            contentType : "application/json",
            success : function(data){
            console.log("Successful get of item: " );


                var roomSearch = "";
                $.each(data, function(index, value){
                    var searchRoomItem = "<option>" + value.roomNumber + "</option>"
                    roomSearch +=searchRoomItem;
                });

                $("#bookingRoomSelect").html(roomSearch);
                $("#bookingRoomEdit").html(roomSearch);
            }

        });



}

function editBooking(id){
    console.log("Trying to edit data");
    console.log("Dit is ID: " + id);

    $("#finalEdit").click(function(){
    console.log("clicked Edit");
    var inputID = id;
    var inputCheckInDate = $("#checkInDateEdit").val();
    var inputCheckOutDate = $("#checkOutDateEdit").val();
    var inputGuest = $("#bookingGuestEdit").val();
    var inputRoom = $("#bookingRoomEdit").val();
    var inputBreakfast = $("#bookingBreakfastEdit").val();
    var inputBabybed = $("#bookingBabybedEdit").val();

    console.log(inputID);

    var newBookingUpdateObject = {
                id : inputID,
                checkInDate : inputCheckInDate,
                checkOutDate : inputCheckOutDate,
                guest : inputGuest,
                room : inputRoom,
                wantsBreakfast : inputBreakfast,
                wantsBabybed : inputBabybed
                };
    console.log(newBookingUpdateObject);
    var newBookingUpdate = JSON.stringify(newBookingUpdateObject);
    console.log(newBookingUpdate);


    $.ajax({
        url : "http://localhost:8080/api/bookings/"+id,
        type : "put",
        data : newBookingUpdate,
        contentType : "application/json",
        success : function(data){
            console.log("successful put")

            getData();
        }

    });
    });
};


function postData(){
    console.log("Trying to post data");

        var inputCheckInDate = $("#checkInDate").val();
        var inputCheckOutDate = $("#checkOutDate").val();
        var inputGuest = $("#bookingGuestSelect").val();
        var inputRoom = $("#bookingRoomSelect").val();
        var inputBreakfast = $("#bookingBreakfast").val();
        var inputBabybed = $("#bookingBabybed").val();

        var newBookingObject = {
            checkInDate : inputCheckInDate,
            checkOutDate : inputCheckOutDate,
            guest : inputGuest,
            room : inputRoom,
            wantsBreakfast : inputBreakfast,
            wantsBabybed : inputBabybed
            };

            console.log(newBookingObject);

        var newBooking = JSON.stringify(newBookingObject);
            console.log(newBooking);

    $.ajax({
        url : "http://localhost:8080/api/bookings/save",
        type : "post",
        data : newBooking,
        contentType : "application/json",
        success : function(data) {
            console.log("Successful post")

            getData();
    }

    });
};

function deleteBooking(id){
$("#deleteThisBooking").html("Are you sure you want to delete booking #" + id + "?");
$("#finalDelete").click(function(){
    $.ajax({
        url : "http://localhost:8080/api/bookings/"+id,
        type : "delete",
        contentType : "application/json",
        success : function() {
            console.log("Deletion is initiated");


            $("#bookingTable").html("");

            getData();
        }

    });
});
}

function getData(){
$(document).ready(function(){

    console.log("Trying to get the data.")

    $.ajax({
        url : "http://localhost:8080/api/bookings/get",
        type : "get",
        success : function(data){

        var bookingList = "";

        	$.each(data, function(index, current) {
            console.log("each function");

            var boolBreakfastStr = current.wantsBreakfast.toString();
                    if(current.wantsBreakfast){
                         boolBreakfastStr = "yes";
                         } else {
                         boolBreakfastStr = "no";
                         }

            var boolBabybedStr = current.wantsBabybed.toString();
                    if(current.wantsBabybed){
                          boolBabybedStr = "yes";
                          } else {
                          boolBabybedStr = "no";
                          }

            var roomNumberValue="";
            $.each(current.rooms, function(values, roomsNumberValues){
                roomNumberValue=roomsNumberValues.roomNumber;
            });

            var bookingString = "<tr><td>" + current.guest.firstName + "</td><td>" +
            current.checkInDate + "</td><td>" + current.checkOutDate + "</td><td>" + roomNumberValue + "</td><td>" +
            boolBreakfastStr +"</td><td>" + boolBabybedStr +  "</td><td>" +
            "<button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteBookingModal' id='current.id' onclick='deleteBooking(" + current.id + ")'> Delete </button>" +
            "</td><td>" + "<button type='button' class='btn btn-info' data-toggle='modal' data-target='#editBookingModal' id='current.id' onclick='editBooking(" + current.id + ")'> Edit </button>" +
            "</td></tr>";



            $("#checkInDateEdit").val(current.checkInDate);
            $("#checkOutDateEdit").val(current.checkOutDate);
            $("#bookingRoomEdit").val(current.room);
            $("#bookingGuestEdit").val(current.guest);

            bookingList += bookingString;
            });


            console.log(bookingList);
            $(".bookingTable").empty();
            $(".bookingTable").append(bookingList);

                        console.log(bookingTableContent);
                        $(".bookingTable").empty();
        				$(".bookingTable").append(bookingTableContent);

        }
    });
    });
}

function searchBooking(){
    console.log("Trying to search data");

    var inputSearchTerm = $("#searchBookingNumber").val();

    var newBookingSearchObject = {
        searchTerm : inputSearchTerm
    };

    var newBookingSearch = JSON.stringify(newBookingSearchObject);
    console.log(newBookingSearch);

    $.ajax({
        url : "http://localhost:8080/api/bookings/search/"+inputSearchTerm,
        type : "get",
//        data : newBookingSearch,
        contentType : "application/json",
        success : function(data){
        console.log("Successful get of item: " + newBookingSearch);


            var bookingSearch = "";
            console.log("bookingSearch: " + bookingSearch);
            $.each(data, function(index, value){
                var columnRow = "<tr><td>" + value.id + "</td><td>" + value.checkInDate +
                "</td><td>" + value.checkOutDate + "</td><td>" + value.guest + "</td><td>" + value.room +
                "</td><td>" + value.wantsBreakfast + "</td><td>" + value.wantsBabybed + "</td><td>" +
                "<button type='button' class='btn btn-danger' onclick='deleteBooking(" + value.id + ")'> Delete </button>" +
                "</td><td>" + "<button type='button' class='btn btn-secondary' data-toggle='modal' data-target='#editBookingModal' id='current.id' onclick='editBooking(" + value.id + ")'> Edit </button>" + "</td></tr>";


                bookingSearch +=columnRow;
                console.log("bookingSearch: " + bookingSearch);
            });

            $(".bookingTable").html(bookingSearch);
            $("#searchBookingNumber").val("");


        }

    });

}

