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

    var bookingObject = JSON.stringify(newBookingObject);


    $.ajax({
    url : "http://localhost:8080/api/bookings/save",
    type : "post",
    data : bookingObject,
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
        			console.log("bookingObject");

        				$.each(data, function(index, current) {
                            console.log("each function");
        				 	var columnRow = "<tr><td>" + current.bookingId + "</td><td>" + current.checkInDate + "</td><td>" + current.checkOutDate + "</td><td>" + current.guest + "</td><td>" + current.room + "</td><td>" + current.wantsBreakfast + "</td><td>" + current.wantsBabybed + "</td><td>" + "<button type='button' class='btn btn-danger' onclick='deleteBooking(" + current.bookingId + ")'> Delete </button>" + "</td></tr>";

        				 	bookingTableContent += columnRow;

        				});

                        console.log(bookingTableContent);
                        $(".bookingTable").empty();
        				$(".bookingTable").append(bookingTableContent);
        }

    });
}

getData();