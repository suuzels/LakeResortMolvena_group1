
function deleteRoom(){

$.ajax({
    url : "http://localhost:8080/api/rooms/delete",
    type : "delete",
    contentType : "application/json",
    success : function(){

       console.log("delete initiated");
        $("#roomsTbl").html("");
        getData();
    }
});
}

function addRoom(){

var roomNumberInput = $("#roomNumberInput").val();
var roomTypeInput = $("#roomTypeInput").val();
var priceInput = $("#priceInput").val();
var availableInput = $("#availableInput").val();

var newRoomObject = {
                    roomID : roomNumberInput,
                    roomType : roomTypeInput,
                    defaultPrice : priceInput,
                    available : availableInput
                    }
var newRoom = JSON.stringify(newRoomObject);

$.ajax({
    url : "http://localhost:8080/api/rooms/save",
    type : "post",
    data : newRoom,
    contentType : "application/json",
    success : function(data) {
    console.log("something was posted.");

    $("#roomNumberInput").val("");
    $("#roomTypeInput").val("");
    $("#priceInput").val("");
    $("#availableInput").val("");

     getData();
    }
});
};

function getData(){
$.ajax({
    url : "http://localhost:8080/api/rooms/get",
    type : "get",
    contentType : "application/json",
    success : function(data) {
        console.log("Got the data: " + data);

        var tblContents = "";

        $.each(data, function(index, current){
            var dataRow = "<tr><td>" + current.roomID + "</td><td>" + current.roomType + "</td><td>" + current.defaultPrice + "</td><td>" + current.available;
            tblContents += dataRow;
        });
        $("#roomsTbl").html(tblContents);
    }
});
}

$(document).ready(function(){
    getData();
});