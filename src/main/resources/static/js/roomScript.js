// Javascript bestand roompagina @Daniëlle
//

// AJAX gebruiken om backend data in te laden naar jquery
$(document).ready(function(){
getData();
    });


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

    });
};




function deleteRoom(id){

$("#deleteThisRoom").html("Are you sure you want to delete room #" + id + "?");

    $("#finalDelete").click(function(){

                console.log("function modalDeleteRoom is being used")

                $.ajax({
                        url : "http://localhost:8080/api/rooms/"+id,
                        type : "delete",
                        contentType : "application/json",
                        success : function() {
                            console.log("Deletion is initiated");

                            $("#roomTable").html("");

                            getData();
                            }

                });
            });
}

function editRoom(id){
    console.log("Trying to edit data");
    console.log("Dit is het ID: " + id);
        
    var roomNumber1 = "";
    var roomNumber = "";

       $("#tableRoomId").each(function(){
            roomNumber = '#roomNumber' + id;
            console.log(roomNumber);
            roomNumber1 = $(roomNumber).html();
            console.log(roomNumber1);
       });


    console.log("Change placeholder")
//    $("#firstnameEdit").attr('placeholder', 'some text');
    $("#roomNumberEdit").val(roomNumber1);

    $("#editRoom").click(function(){
        console.log("clicked Edit");
        var inputID = id;
        var inputRoomNumber = $("#roomNumberEdit").val();
        var inputRoomType = $("#roomTypeEdit").val();
        var inputRoomName = $("#roomNameEdit").val();
        var inputPrice = $("#roomPriceEdit").val();
        var inputAvailability = $("#occupiedEdit").val();

        console.log(inputID);

        var newRoomUpdateObject = {
                    id : inputID,
                    roomNumber : inputRoomNumber,
                    roomType : inputRoomType,
                    roomName : inputRoomName,
                    defaultPrice : inputPrice,
                    isOccupied : inputAvailability
                    };
        console.log(newRoomUpdateObject);
        var newRoomUpdate = JSON.stringify(newRoomUpdateObject);
        console.log(newRoomUpdate);


        $.ajax({
            url : "http://localhost:8080/api/rooms/"+id,
            type : "put",
            data : newRoomUpdate,
            contentType : "application/json",
            success : function(data){
                console.log("successful put")

                getData();
            }

        });
    });
};


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

                    // Here true is printed as occupied and false as available
                    var boolOccupiedStr = current.occupied.toString();
                        if(current.occupied){
                             boolOccupiedStr = "occupied";
                              } else {
                              boolOccupiedStr = "available";
                              }
                     console.log(current.occupied);
                     console.log(boolOccupiedStr);

                    // Here the roomprice is printed based on the type of room selected in dropdown from modal
                    var intPriceRoomStr = current.roomType.toString();
                    console.log("Ik ben je current roomtype: " + current.roomType);
                        if (current.roomType == "STANDARD"){
                                intPriceRoomStr = "€89,-"
                            } else if (current.roomType == "LUXURY"){
                                intPriceRoomStr = "149,-"
                            } else if (current.roomType == "HONEYMOON_SUITE"){
                                intPriceRoomStr = "345,-"
                            }
                    console.log(current.roomType);
                    console.log(intPriceRoomStr);

                    //var firstnameID = "firstname" +(value.id);
                    var roomNumberID = "roomNumber" + (current.id);
                    console.log(roomNumberID);

                    // columnRow is being created with all the values out of the database
				 	var columnRow = "<tr><td>" + 
                    current.id + "</td><td id='"+ roomNumberID+ "'>" + 
                    current.roomNumber + "</td><td>" + 
                    current.roomName + "</td><td>" + 
                    current.roomType + "</td><td>"+ 
                    intPriceRoomStr + "</td><td>" + 
                    boolOccupiedStr + "</td><td>" +
                    "<button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteRoomModal' id='"+ current.id +"' onclick='deleteRoom(" + current.id + ")'> Delete </button>" + "</td><td>"
                    + "<button type='button' class='btn btn-info' data-toggle='modal' data-target='#editRoomModal' id='"+ current.id + "' onclick='editRoom(" + current.id + ")'> Edit </button>" + "</td></tr>";

                    // Prefilling values in the edit modal
                    $("#roomNumberEdit").val(current.roomNumber);
                    $("#roomNameEdit").val(current.roomName);
                    $("#roomPriceEdit").val(current.defaultPrice);


				 	roomTableContent += columnRow;

				});

                console.log(roomTableContent);

                $("#roomTable").empty();
				$("#roomTable").append(roomTableContent);

				}

		});
    });

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


                







