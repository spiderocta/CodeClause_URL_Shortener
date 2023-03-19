$(document).ready(function() {
    $("button").click(function() {
        $.ajax({
            type : 'POST',
            url : 'http://localhost:1010/api/v1/shorten',
            data : JSON.stringify({
                "expiresDate": "2023-05-15T07:32:59.357Z",
                "longUrl": $("#urlinput").val()
            }),
            contentType : "application/json; charset=utf-8",
            success : function(data) {
                $("#shorturltext").val("http://localhost:1010/api/v1/"+data);
            }
        });
    });
});