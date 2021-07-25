<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
    <head>
        <title>Building Info</title>
        <style>body{
                 text-align: center
               }</style>
    </head>
    <body>
    <h1>Building Info</h1>
        <p>${building}</p>
        <br/>
                <h1>Make Changes</h1>
                <form method="post" action="changed">
                Change on UUID: ${id}<br/>
                Enter Size : <input type="text" name="size"/><br/>
                Enter Address : <input type="text" name="address"/><br/>
                Enter Country : <input type="text" name="country"/><br/>
                Currently not support for changing all values, due to short in time.<br/><br/>
                <input type="submit" value="Submit Changes">
                <br/><br/>
                <a href="../mlschanged" class="button">Back to MLS</a>
    </body>
</html>