<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">

</head>
<body>
    <#if username?? >
        <#if greetings?has_content>
            <#list greetings as g>
                <li>${g}, ${username}!</li>
            </#list>
        <#else>
            Sorry, nobody wanna greet you...
        </#if>
    </#if>
    <form action="${form_url}" method="GET" >
        <input type="text" name="name" />
        <input type="submit" value="say hello" />
    </form>
</body>
</html>