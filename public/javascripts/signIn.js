
$(document).ready(function(){


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