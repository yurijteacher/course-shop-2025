<#import "templ_manager/templ_manager.ftl" as p>

<@p.pages>

<h2> Адміністрування категорій </h2>

<h3> Form </h3>
<form method="post" action="saveNewCategory">

    <label for="name">Name</label>
    <input type="text" name="name" placeholder="name" id="name"><br>

    <label for="description">Description</label>
    <input type="text" name="description" placeholder="description" id="description"><br>

    <label for="image">Image</label>
    <input type="text" name="image" placeholder="image" id="image"><br>

    <button type="submit" class="btn btn-primary">Add</button>

</form>


<h3> List Categories</h3>

<table>
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>description</td>
        <td>image</td>
    </tr>
    </thead>
    <tbody>
    <#if categories??>

        <#list categories as category>
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>${category.description}</td>
                <td>${category.images}</td>
            </tr>
        </#list>
    </#if>
    </tbody>
</table>

<h3> Delete/Update</h3>
<h5> List Categories</h5>

<table class="table table-striped">
    <thead>
    <tr>
        <#--        <td>id</td>-->
        <td>name</td>
        <td>description</td>
        <td>image</td>
        <td>update</td>
        <td>delete</td>
    </tr>
    </thead>
    <tbody>
    <#if categories??>
        <#list categories as category>
            <form method="post" action="/updateCategory">
                <tr>
                    <input type="hidden" name="id" value="${category.id}">
                    <td><input type="text" name="name" value="${category.name}"></td>
                    <td><input type="text" name="description" value="${category.description}"></td>
                    <td><input type="text" name="image" value="${category.images}"></td>
                    <td>
                        <button type="submit" class="btn btn-success">Update</button>
                    </td>

            </form>

            <form method="post" action="/deleteCategory">
                <input type="hidden" name="id" value="${category.id}">
                <td>
                    <button class="btn btn-success" type="submit">Delete</button>
                </td>
            </form>
            </tr>
        </#list>
    </#if>
    </tbody>
</table>

</@p.pages>
