<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/5
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajax</title>
</head>
<body>
    <form action="" enctype="application/x-www-form-urlencoded"></form>
    <input type="text" id="name">
    <button id="btn">发送请求</button>
    <div id="result"></div>


<script>
    (function () {
        //创建XMLHttpRequest对象
        function createXmlHttp() {
            var xmlHttp = null;
            if(window.ActiveXObject){
                //IE
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#btn").onclick = function () {
            var name = document.querySelector("#name").value;
            //sendGet(name);
            sendPost(name);
        }
        function sendGet(name) {
            //1.获取Ajax引擎
            var xmlHttp = createXmlHttp();
            //2.指定请求方式和请求地址
            xmlHttp.open("get","/ajax?name="+name);
            //3.发出请求
            xmlHttp.send();
        }
        function sendPost(name) {
            //1.获取Ajax引擎
            var xmlHttp = createXmlHttp();
            //2.指定请求方式和地址
            xmlHttp.open("post","/ajax");
            xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            //3.配置回调函数
            xmlHttp.onreadystatechange = function () {
                var state = xmlHttp.readyState;
                if(state == 4){
                    //获取http状态码
                    var httpStat = xmlHttp.status;
                    if(httpStat == 200){
                        //获取服务端返回的字符串
                        var result = xmlHttp.responseText;
                        var div = document.querySelector("#result");
                        if(result == "成功"){
                            div.innerText = "该账号可以使用";
                        }else {
                            div.innerText = "该账号已存在";
                        }
                    }else {
                        alert("服务器错误"+httpStat);
                    }
                }
            }

            //4.发出请求
            xmlHttp.send("name="+name)
        }


    })();
</script>
</body>
</html>
