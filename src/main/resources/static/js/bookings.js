$(document).ready(function(){
getData();
});

function deleteBooking(){
    $.ajax({
        url : "http://localhost:8080/api/bookings/delete",
        type : "delete",
        contentType : "application/json",
        success : function() {
            console.log("Deletion is initiated");
            $("#bookingTable").html("");

            getData();

        }

    });
}

function postData(){
    console.log("Trying to post data");

        var inputBookingId = $("#bookingId").val();
        var inputCheckInDate = $("#checkInDate").val();
        var inputCheckOutDate = $("#checkOutDate").val();
        var inputGuest = $("#bookingGuest").val();
        var inputRoom = $("#bookingRoom").val();
        var inputBreakfast = $("#bookingBreakfast").val();
        var inputBabybed = $("#bookingBabybed").val();

        var newBookingObject = {
            bookingId : inputBookingId,
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

function getData(){
    console.log("Trying to get the data.")

    $.ajax({
        url : "http://localhost:8080/api/bookings/get",
        type : "get",
        success : function(data){

        var bookingTableContent = "";

        				$.each(data, function(index, current) {
                            console.log("each function");
                            console.log(current);
        				 	var columnRow = "<tr><td>" + current.bookingId + "</td><td>" + current.checkInDate + "</td><td>" + current.checkOutDate + "</td><td>" + current.guest + "</td><td>" + current.room + "</td><td>" + current.wantsBreakfast + "</td><td>" + current.wantsBabybed + "</td><td>" + "<button type='button' class='btn btn-danger' onclick='deleteBooking(" + current.bookingId + ")'> Delete </button>" + "</td></tr>";

        				 	bookingTableContent += columnRow;

        				});

                        console.log(bookingTableContent);
                        $(".bookingTable").empty();
        				$(".bookingTable").append(bookingTableContent);
        }

    });
}

