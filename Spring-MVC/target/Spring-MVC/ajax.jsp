<%--
  Created by IntelliJ IDEA.
  User: vector
  Date: 2020/12/2
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script>
        var userList=new Array();
        userList.push({username:"aaa",age:20,sex:"a",address:"aaa"});

        $.ajax({
            type:"post",
            url:"/test8",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
