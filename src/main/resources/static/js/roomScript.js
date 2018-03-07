// Javascript bestand roompagina @Daniëlle
//

// AJAX gebruiken om backend data in te laden naar jquery
$(document).ready(function(){
getData()
var deleteId = id;
    });

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

                    var boolOccupiedStr = current.occupied.toString();
                        if(current.occupied){
                             boolOccupiedStr = "occupied";
                              } else {
                              boolOccupiedStr = "available";
                              }
                     console.log(current.occupied);
                     console.log(boolOccupiedStr);


				 	var columnRow = "<tr><td>" + current.id + "</td><td>" + current.roomNumber + "</td><td>"
				 	+ current.roomName + "</td><td>" + current.roomType + "</td><td>"
                    + current.defaultPrice + "</td><td>" + boolOccupiedStr + "</td><td>" +
                    "<button type='button' class='btn btn-danger' onclick='modalDeleteRoom(" + current.id + ")'> Delete </button>" + "</td><td>" 
                    + "<button type='button' class='btn btn-info' onclick='modalEditRoom(" + current.id + ")'> Edit </button>" + "</td></tr>";

				 	roomTableContent += columnRow;

				});

                console.log(roomTableContent);
                            
                $("#roomTable").empty();
				$("#roomTable").append(roomTableContent);

				}

		});
    });

}


function modalDeleteRoom(id){
                console.log("function modalDeleteRoom is being used")

                deleteId = id;

                $("#deleteThisRoom").html("Are you sure you want to delete room #" + deleteId + "?");
                $("#deleteRoomModal").modal('show');
                
}

 function deleteRoom(){
                console.log("function deleteroom is being used")


                    $.ajax({
                        url : "http://localhost:8080/api/rooms/"+deleteId,
                        type : "delete",
                        contentType : "application/json",
                        success : function() {
                            console.log("Delete is initiated");
                            $("#roomTable").html("");
                             getData();
                        }
                    })
                   
                }

function modalEditRoom(id){
                console.log("function modalDeleteRoom is being used")

                $("#editRoomModal").modal('show');
                
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


function searchRoom(){
    console.log("Trying to search for rooms");

    var inputSearchTerm = $("#searchRoomName").val();

    // searchTerm comes from the backend room object
    var newRoomSearchObject = {
        searchTerm : inputSearchTerm
    };

    var newRoomSearch = JSON.stringify(newRoomSearchObject);
    console.log(newRoomSearch);

    $.ajax({
        url : "http://localhost:8080/api/rooms/search/"+inputSearchTerm,
        type : "get",
//        data : newRoomSearch,
        contentType : "application/json",
        success : function(data){
        console.log("Successful get of item: " + newRoomSearch);




            var roomSearch = "";
            console.log("roomSearch: " + roomSearch);
            $.each(data, function(index, current){

            var boolOccupiedStr = current.occupied.toString();
                                    if(current.occupied){
                                         boolOccupiedStr = "occupied";
                                          } else {
                                          boolOccupiedStr = "available";
                                          }
                                 console.log(current.occupied);
                                 console.log(boolOccupiedStr);

                var columnRow = "<tr><td>" + current.id + "</td><td>" + current.roomNumber + "</td><td>"
                				 	+ current.roomName + "</td><td>" + current.roomType + "</td><td>"
                                    + current.defaultPrice + "</td><td>" + boolOccupiedStr + "</td><td>" +
                                    "<button type='button' class='btn btn-danger' onclick='modalDeleteRoom(" + current.id + ")'> Delete </button>" + "</td><td>"
                                    + "<button type='button' class='btn btn-info' onclick='modalEditRoom(" + current.id + ")'> Edit </button>" + "</td></tr>";


                roomSearch +=columnRow;
                console.log("roomSearch: " + roomSearch);
            });

            $(".roomTable").html(roomSearch);
            $("#searchRoom").val("");


        }

    });

}


                







