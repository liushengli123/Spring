<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/test7" method="post">
        <label>
            <input type="text" name="users[0].username">
        </label><br/>
        <label>
            <input type="text" name="users[0].age">
        </label><br/>
        <label>
            <input type="text" name="users[0].sex">
        </label><br/>
        <label>
            <input type="text" name="users[0].address">
        </label><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
