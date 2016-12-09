
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="result"></div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $(function(){
        var maxid = 0;

        function call(){
            $.get("/timeline",{"maxid":maxid}).done(function(data){
                if(data.length){
                    for(var i = 0;i < data.length;i++){
                        var item = data[i];
                        var html = "<h3>"+item.message+"</h3>";
                        if(maxid == 0){
                            $(html).appendTo($("#result"));

                        }else{
                            $(html).prependTo($("#result"));
                        }
                    }
                    maxid = data[0].id;
                }
            })
                .error(function(){
                    alert("服务器错误");
                    clearInterval(st);
                });
        }
        call();
        var st = setInterval(call,5000);
    });

</script>


</body>
</html>
