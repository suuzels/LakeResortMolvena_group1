//// print out the list of guests
//     $(document).ready(function(){
//         $.ajax({
//             url:"http://localhost:8080/api/guest/index",
//             type:"get",
//             success : function(data){
//                 console.log(data);
//
//                 $.each(data, function(index, value){
//                        console.log(value.lastName);
//                               $("#lastName").attr(value.lastName);
//                         });
//
//             }
//         });
//     });