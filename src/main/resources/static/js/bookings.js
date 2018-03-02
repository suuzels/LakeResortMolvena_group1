$(document).ready(function(){
getData();
    });

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
        var inputGuest = $("#bookingGuest").val();
        var inputRoom = $("#bookingRoom").val();
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
}

function deleteBooking(id){
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
}

function getData(){
$(document).ready(function(){

    console.log("Trying to get the data.")

    $.ajax({
        url : "http://localhost:8080/api/bookings/get",
        type : "get",
        success : function(data){

        var bookingTableContent = "";
        	$.each(data, function(index, current) {
            console.log("each function");
            console.log(current);

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

            var columnRow = "<tr><td>" + current.id + "</td><td>" + current.checkInDate + "</td><td>" + current.checkOutDate + "</td><td>" + current.guest + "</td><td>" + current.room + "</td><td>" + boolBreakfastStr + "</td><td>" + boolBabybedStr + "</td><td>" + "<button type='button' class='btn btn-danger' onclick='deleteBooking(" + current.id + ")'> Delete </button>" + "</td><td>" + "<button type='button' class='btn btn-info' data-toggle='modal' data-target='#editBookingModal' id='current.id' onclick='editBooking(" + current.id + ")'> Edit </button>" + "</td></tr>";




            bookingTableContent += columnRow;
            });


                        console.log(bookingTableContent);
                        $(".bookingTable").empty();
        				$(".bookingTable").append(bookingTableContent);


        }

    });
    });
}
