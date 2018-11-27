$(function(){
	
	alert("111");
});

$('#submit').click(function(){
	alert("111");
    $.ajax({
    	type: "post",
    	url: "http://59.110.218.127:8080/JD/loginServlet",
        data: "login_name="+$("#username").val()+"&password="+$("#password").val(),
        dataType: "json",
        success: function (msg)
        {
            alert(msg);
        }
    });
});