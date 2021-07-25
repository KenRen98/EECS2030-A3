<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
    <head>
        <title>MLS Info System</title>
        <style>body{
                    text-align: center
                    }</style>
    </head>
    <body>
    <h1>This is a Multiple Listing System</h1><br/><br/>
        <form method="post" action="mlssearch">
            Search By UUID: : <input type="text" name="id"/>
        <input type="submit" value="Search"><br/><br/>
        <a href="mlsnew" class="button">Creat New Record?</a><br/>
        <br/><br/>
        <p>
        Here is a small list of existing elements you can try searching:<br/>
        03b9cbea-a90d-406c-9e5b-623da6e2736d<br/>
        813c28a7-2f9b-4085-8168-a94b3c1f91a5<br/>
        c492ff7d-eb9f-4ab2-9c57-72e0fb59c51b<br/>
        c492ff7d-eb9f-4ab2-9c57-72e0fb59c52b<br/>
        c492ff7d-eb9f-4ab2-9c57-72e0fb69c52b<br/>
        </p>
    </body>
</html>