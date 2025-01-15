<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<h1>${message}</h1>

<#if categories??>
<#list categories as category>
    ${category.id}
    ${category.name}
    ${category.description}
    ${category.images}
</#list>
</#if>

</body>
</html>