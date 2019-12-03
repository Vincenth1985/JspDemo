<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>

<head>

    <title>Title</title>


</head>

<body>
<form method="get">


    <h2> Enter your firtsname <input type="text" name="firstname"/></h2>
    <h1><input type="submit" value="Submit"/></h1>


</form>



<h1>Hello ${firstname}</h1>
<p>${newfriend}</p>
<p>${oldfriend} this is your ${counter} visit on the web page</p>




</body>

</html>