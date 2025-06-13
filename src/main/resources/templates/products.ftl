<#import "templ_manager/templ_manager.ftl" as p>

<@p.pages>

<h2> List Products </h2>

<#if products??>
    <#list products as product>
        <ul>
            <li> name: ${product.name}</li>
            <li> description: ${product.description}</li>
            <li> price: ${product.price}</li>
            <li> image: ${product.image}</li>
            <li> category: ${product.categories.name}</li>
        </ul>
    </#list>
</#if>


<h2> Save New Product </h2>
<form action="/saveNewProducts" method="POST">

    <label for="name">Name</label>
    <input type="text" name="name" placeholder="name" id="name"><br>

    <label for="description">Description</label>
    <input type="text" name="description" placeholder="description" id="description"><br>

    <label for="price">Price</label>
    <input type="number" name="price" placeholder="price" id="price"><br>

    <label for="image">Image</label>
    <input type="text" name="image" placeholder="image" id="image"><br>

    <label for="category">Category</label>
    <#if categories??>
    <select name="category" id="category">
        <#list categories as category>
            <option value="${category.id}">${category.name}</option>
        </#list>
    </select>
    </#if><br><br>

    <button type="submit">Add New Product</button>

</form>
<h2> Update/Delete </h2>
<table>
    <thead>
    <tr>
        <th>name</th>
        <th>description</th>
        <th>price</th>
        <th>image</th>
        <th>category</th>
        <th>update</th>
        <th>delete</th>
    </tr>
    </thead>
    <tbody>
    <#if products??>
        <#list products as product>
            <tr>
            <form method="post" action="/updateProduct">
                <td> name: <input type="text" name="name1" value="${product.name}"></td>
                <td> description: <input type="text" name="description1" value="${product.description}"></td>
                <td> price: <input type="number" name="price1" value="${product.price?c}"></td>
                <td> image: <input type="text" name="image1" value="${product.image}"></td>
                <td>
                    category:
                    <select name="categories">
                        <#if categories??>
                            <#list categories as category>
                                <#if category.id==product.categories.id>
                                    <option value="${category.id}" selected>${category.name}</option>
                                <#else>
                                    <option value="${category.id}">${category.name}</option>
                                </#if>
                            </#list>
                        </#if>
                    </select>

                </td>
                <input type="hidden" name="id1" value="${product.id}">
                <td>
                    <button type="submit">Update</button>
                </td>
            </form>

            <form method="post" action="/deleteProduct">
                <input type="hidden" name="id2" value="${product.id}">
                <td>
                    <button type="submit">Delete</button>
                </td>
            </form>
        </#list>
        </tr>
    </#if>

    </tbody>


</table>


<h2> Delete All Products</h2>

</@p.pages>