<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
    <head>
        <title>Parking Info</title>
        <style>body{
                    text-align: center
                    }</style>
    </head>
    <body>
    <h1>Parking Info</h1>
    <p>${parking}</p>
    <br/>
        <h1>Make Changes</h1>
        <form method="post" action="changed">
        Change on UUID: ${id}<br/>
        Enter Type : <input type="text" name="type"/><br/>
        Enter Size : <input type="text" name="size"/><br/>
        Enter YES if RVOK : <input type="text" name="rvok"/><br/><br/>
        <input type="submit" value="Submit Changes">
        <br/><br/>
            <a href="../mlschanged" class="button">Back to MLS</a>
    </body>
</html>