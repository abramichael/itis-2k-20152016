<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">

</head>
<body>
    <#if username?? && username?has_content>
        <#if greetings?has_content>
            <#list greetings as g>
                <p>${g}, ${username}!</p>
            </#list>
        <#else>
            <p>Sorry, nobody wanna greet you!</p>
        </#if>
    </#if>
    <form action="${form_url}" method="get">
        <input type="text" name="name"/>
        <input type="submit" value="say hi"/>
    </form>

</body>
</html>