if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
};

$(document).ready(function(){


         $('#signUp').on("click",function(){
         jsRoutes.controllers.Application.signUp().ajax({
                      success: function(data){
                        $('#body').html(data);
                      },
                      error: function(){
                      $('#body').html("hello");
                      alert("fail")
                    }

          })



      })

      $('#signIn').on("click",function(){
                jsRoutes.controllers.Application.signIn().ajax({
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