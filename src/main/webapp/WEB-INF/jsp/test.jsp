<%--
  Created by IntelliJ IDEA.
  User: SDD
  Date: 16-3-23
  Time: 下午11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <title>uploadfile</title>
    <meta charset="utf-8">
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <link href="/css/uploadfile.css" rel="stylesheet">
    <script src="/js/jquery-1.12.0.min.js"></script>
    <script src="/js/jquery.form.js"></script>
    <script src="/js/jquery.uploadfile.js"></script>
</head>
<body>
<div id="fileuploader">Upload</div>
<script>
    $(document).ready(function()
    {
        $("#fileuploader").uploadFile({
            url:"/upload.json",
            fileName:"file",
            showProgress: true,
            showPreview: true,
            showDownload: true
        });
    });
</script>
</body>
</html>