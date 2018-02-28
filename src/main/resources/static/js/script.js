// Javascript bestand HOTELPROJECT
//

// AJAX gebruiken om backend data in te laden naar jquery
$(document).ready(function(){
   getData();

});

function getData() {
	$.ajax({
		url : "http://localhost:8080/api/rooms/get",
		type : "get",
		success: function(data){

			var roomTableContent = "";
			console.log("roomObject");

				$.each(data, function(index, current) {
                    console.log("each function");
				 	var columnRow = "<tr><td>" + current.roomID + "</td><td>" + current.roomType + "</td><td>" + current.defaultPrice + "</td><td>" + current.available + "</td><td>" + "<button type='button' class='btn btn-danger' onclick='deleteRoom(" + current.roomID + ")'> Delete </button>" + "</td></tr>";

				 	roomTableContent += columnRow;

				});

                console.log(roomTableContent);
                $(".roomTable").empty();
				$(".roomTable").append(roomTableContent);

				}


		});
}

function deleteRoom(roomID){
                console.log("function deleteroom is being used")
                    $.ajax({
                        url : "http://localhost:8080/api/rooms/delete", 
                        type : "delete",
                        contentType : "application/json",
                        success : function() {
                            console.log("Delete is initiated");
                            $("#roomTable").html("");
                        }
                    })
                    getData();
                }


function postData(){
	// The postData function is triggered by the add new room button. This function has to post the filled in data into the table.

    // First we need to put the values of the input fields into variables
    var inputRoomID = $("#roomId").val();
    var inputRoomType = $("#roomType").val();
    var inputPrice = $("#roomPrice").val();
    var inputAvailability = $("#roomAvailability").val();

    if(inputRoomID == "") {
            $("#errorMessage").val("Fill in RoomID")
            return;
        }

    // Here we make a new object
    var newRoomObject = {
    roomType : inputRoomType,
    roomID : inputRoomID,
    defaultPrice : inputPrice,
    available : inputAvailability
    };

    // Make the object readable for the backend by parsing it to JSON
    var newRoom = JSON.stringify(newRoomObject);
    console.log(newRoom);

    // Save the actual data to the repository
    $.ajax({
        url : "http://localhost:8080/api/rooms/save",
        type : "post",
        data : newRoom,
        contentType : "application/json",
        success: function(data){
            console.log("Success post!");
            getData();

        }

    })

}


                







