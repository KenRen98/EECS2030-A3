<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
    <head>
        <title>MLS Info</title>
        <style>body{
                    text-align: center
                    }</style>
    </head>
    <body>
    <h1>MLS Info</h1>
    <p>${mls}</p>
    <br/>
    <h1>Make Changes</h1>
    <form method="post" action="mlschanged">
    Change on UUID: ${id}<br/>
    Enter MLS Name : <input type="text" name="name"/><br/>
    Enter Type : <input type="text" name="type"/><br/>
    Enter List Date : <input type="text" name="date"/><br/>
    <input type="submit" value="Submit Changes">
    <br/><br/>
    <a href="index" class="button">Back to Home</a>
    <br/><br/>
    <a href="index" class="button">Apply all Changes to DB(Not implemented)</a>
    </body>
</html>