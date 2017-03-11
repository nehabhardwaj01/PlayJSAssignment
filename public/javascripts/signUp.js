
$(document).ready(function(){

 $('#signUpSubmit').on("click",function(){
            /*alert("clicked")*/
                console.log($('#fname').val())
                console.log("clicked")
                jsRoutes.controllers.SignUpController.addUser(
                $('#fname').val(),
                $('#lname').val(),
                $('#gender').val()),
                $('#username').val(),
                $('#password').val(),
                $('#repassword').val(),
                $('#hobbies').val()).ajax({
                            success: function(data){
                              $('#body').html(data);

                            },
                            error: function(){
                            $('#body').html("hello");
                            alert("fail")
                          }

                })


            })

             $('#home').on("click",function(){
                     jsRoutes.controllers.Application.index().ajax({
                                  success: function(data){
                                    $('#body').html(data);
                                  },
                                  error: function(){
                                  $('#body').html("hello");
                                  alert("fail")
                                }

                      })


                  })

});