<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
    <head>
        <title>Owner Info</title>
        <style>body{
                    text-align: center
                    }</style>
    </head>
    <body>
    <h1>Owner Info</h1>
    <p>${owner}</p>
    <br/>
    <h1>Make Changes</h1>
    <form method="post" action="changed">
    Change on UUID: ${id}<br/>
    Enter First Name : <input type="text" name="firstname"/><br/>
    Enter Last Name : <input type="text" name="lastname"/><br/>
    Enter Phone Number : <input type="text" name="phone"/><br/>
    Enter Email Address: <input type="email" name="email"><br/><br/>
    <input type="submit" value="Submit Changes"><br/><br/>
    <a href="../mlschanged" class="button">Back to MLS</a>
    </body>
</html>