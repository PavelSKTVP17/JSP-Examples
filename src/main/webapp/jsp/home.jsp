<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Title</title>
    </head>
    <body>
        <span style="color:${cookie.color.value}">Hello</span>
        <form method="post" action="/home">
            <label for="color">
                <select name="color" id="color">
                    <option value="red">Красный</option>
                    <option value="black">Чёрный</option>
                    <option value="white">Белый</option>
                </select>
            </label>
            <input type="submit" value="Color send">
        </form>
    </body>
</html>
