
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/animate.css/3.5.2/animate.min.css" rel="stylesheet">

</head>
<body>

<div class="container">
    <form id="loginForm" class="animated bounce">
        <div class="form-group">
            <lable>账号</lable>
            <input type="text" class="form-control" name="username" id="username">
        </div>
        <div class="form-group">
            <lable>密码</lable>
            <input type="password" class="form-control" name="password" id="password">
        </div>
        <div class="form-group">
            <button class="btn btn-primary" type="button" id="loginBtn">登录</button>
        </div>
    </form>

</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>

<%--
<script>
    $(function(){
        $("#loginBtn").click(function(){
            $("#loginForm").submit();
        });
        $("#loginForm").validate({
            errorElement:"span",
            errorClass:"text-danger",
            rules:{
                username:{
                    required:true
                },
                password:{
                    required:true
                }
            },
            messages:{
                username:{
                    required:"请输入账号"
                },
                password:{
                    required:"请输入密码"
                }
            },
            submitHandler:function(){
                $.ajax({
                    url : "/login",
                    type : "post",
                    data : $("#loginForm").serialize(),
                    beforeSend:function(){
                        $("#loginBtn").append($("<i class='fa fa-spinner fa-spin'></i>")).attr("disabled","disabled");
                    },
                    complete:function(){
                        $("#loginBtn").html("登录").removeAttr("disabled");
                    },
                    success : function(data) {
                        if(data.state == "error") {
                            alert(data.message);
                        } else {
                            window.location.href = "/jq/demo1.jsp";
                        }
                    },
                    error : function() {
                        alert("服务器错误");
                    }
                });
            }
        });
    });
    </script>--%>


<script>
    $(function () {
        $("#loginBtn").click(function () {
                $("#loginForm").submit();
            });
        $("#loginForm").validate({
            errorElement:"span",
            errorClass:"text-danger",
            rules:{
                username:{
                    required:true
                },
                password:{
                    required:true
                }
            },
            messages:{
                username:{
                    required:"请输入账号"
                },
                password:{
                    required:"请输入密码"
                }
            },
            submitHandler:function(){
                $.ajax({
                    url : "/login",
                    type : "post",
                    data : $("#loginForm").serialize(),
                    beforeSend:function(){
                        $("#loginBtn").append($("<i class='fa fa-spinner fa-spin'></i>")).attr("disabled","disabled");
                    },
                    complete:function(){
                        $("#loginBtn").html("登录").removeAttr("disabled");
                    },
                    success : function(data) {
                        if(data.state == "error") {
                            alert(data.message);
                        } else {
                            window.location.href = "/jq/demo1.jsp";
                        }
                    },
                    error : function() {
                        alert("服务器错误");
                    }

                })
            }
        });

    });
    
</script>

</body>
</html>
