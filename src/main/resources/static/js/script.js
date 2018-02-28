// Javascript bestand HOTELPROJECT
//

// AJAX gebruiken om backend data in te laden naar jquery


function getData() {

    $(document).ready(function(){
   
	$.ajax({
		url : "http://localhost:8080/api/rooms",
		type : "get",
		success: function(data){

			var roomTableContent = "";
			console.log("roomObject");

				$.each(data, function(index, current) {
                    console.log("each function is initiated");
				 	var columnRow = "<tr><td>" + current.roomNumber + "</td><td>" + current.roomName + "</td><td>" + current.roomType + "</td><td>" 
                    + current.defaultPrice + "</td><td>" + current.occupied + "</td><td>" + "<button type='button' class='btn btn-danger' onclick='deleteRoom(" + current.id + ")'> Delete </button>" + "</td></tr>";

				 	roomTableContent += columnRow;

				});

                console.log(roomTableContent);
                            
                $(".roomTable").empty();
				$(".roomTable").append(roomTableContent);

				}

		});
    });

}

function deleteRoom(id){
                console.log("function deleteroom is being used")

                    $.ajax({
                        url : "http://localhost:8080/api/rooms/"+id,
                        type : "delete",
                        contentType : "application/json",
                        success : function() {
                            console.log("Delete is initiated");
                            $("#roomTable").html("");
                             getData();
                        }
                    })
                   
                }


function postData(){
	// The postData function is triggered by the add new room button. This function has to post the filled in data into the table.

    // First we need to put the values of the input fields into variables
    var inputRoomNumber = $("#roomNumber").val();
    var inputRoomType = $("#roomType").val();
    var inputRoomName = $("#roomName").val();
    var inputPrice = $("#roomPrice").val();
    var inputAvailability = $("#occupied").val();



    // Here we make a new object
    var newRoomObject = {
    roomNumber : inputRoomNumber,
    roomType : inputRoomType,
    defaultPrice : inputPrice,
    roomName : inputRoomName,
    occupied : inputAvailability
    };

    // Make the object readable for the backend by parsing it to JSON
    var newRoom = JSON.stringify(newRoomObject);
    console.log(newRoom);

    // Save the actual data to the repository
    $.ajax({
        url : "http://localhost:8080/api/rooms",
        type : "post",
        data : newRoom,
        contentType : "application/json",
        success: function(data){
            console.log("Success post!");
            getData();

        }

    })

}


                







