
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="/static/js/webuploader/webuploader.css">
</head>
<body>
<div id="picker">选择文件</div>
<div id="result"></div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/webuploader/webuploader.min.js"></script>
<script>
    $(function(){
        var upload = WebUploader.create({
            swf:"/static/js/webuploader/Uploader.swf",
            server:"http://up-z1.qiniu.com/",
            fileVal:"file",
            formData:{"token":"${token}","x:uid":"${id}"},
            pick:"#picker",
            auto:true
        });
        upload.on("uploadSuccess",function (file,data) {
            var img = $("#result").find("img");
            if(img[0]){
                img.remove();
            }
            var url = "http://oi1y0qaj2.bkt.clouddn.com/"+data.key+"?imageView2/1/w/300/h/300";
            $("<img>").attr("src",url).addClass("img-circle").appendTo($("#result"));
            alert(data["x:uid"]);

        });
        upload.on("uploadError",function(file){
            alert("上传错误 ")
        });

    });



</script>
</body>
</html>
