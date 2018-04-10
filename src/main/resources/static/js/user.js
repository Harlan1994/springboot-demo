$(document).ready(function () {
    console.log("heellowssdfasfsdfasf");
    var username = "halrna";
    var birthday = "1994-02-02";
    var realName = "harlanreal";
    var password = "1123";

    var $login =

    $.ajax({
        type: 'post',
        url: "/user",
        contentType: "application/json",
        processData: false,
        // dataType: 'jsonp',
        traditional : true,
        async : false,
        data: {
            "username": username,
            "birthday": birthday,
            "realName": realName,
            "password": password
        },
        success: function (data) {
            alert("success");
            console.log(data);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("出现异常，异常信息：" + textStatus, " error");
        }
    })
});