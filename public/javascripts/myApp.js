$(document).ready(function() {

alert("called");
$("#signin-btn").click(function(){

renderAjaxOne();

	ajaxCall();

	var testAjax = jsRoutes.controllers.Application.ajaxCall();
	$.ajax({
		url : testAjax.url
	}).done(function() {
		$("body").append("<br/>");
		$("body").append("");
	}).fail(function() {
		$("body").append("<br/>");
		$("body").append("");
	});
});
});


var ajaxSuccess = function(action, data) {
     $("#content").html(data);

};

var ajaxError = function(action, error) {
	alert(action + " : " +error);
}

var renderAjaxOne = function() {
	var ajaxCallBack = {
		success : function(data) {
			ajaxSuccess("", data);
		},
		error : function(error) {
			ajaxError("", error);
		}
	}

	jsRoutes.controllers.Application.ajaxCall().ajax(ajaxCallBack);
};

var renderAjaxTwo = function() {
	var ajaxCallBack = {
		success : function(data) {
			ajaxSuccess("AJAX 2:", data);
		},
		error : function(error) {
			ajaxError("AJAX 2:", error);
		}
	}

	jsRoutes.controllers.Application.ajaxCall().ajax(ajaxCallBack);
};

var ajaxCall = function() {
	var ajaxCallBack = {
		success : onSuccess,
		error : onError
	}

	jsRoutes.controllers.Application.ajaxCall().ajax(ajaxCallBack);
};

var onSuccess = function(data) {
	alert(data);
}

var onError = function(error) {
	alert(error);
}