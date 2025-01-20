<#import "customer/home.ftl" as p>

<@p.pages>

<h3> Order </h3>

    <ul>
        <li>${client.firstName}</li>
        <li>${client.lastName}</li>
        <li>${client.email}</li>
        <li>${client.phone}</li>
    </ul>


    <table class="table table-striped">
        <thead>
        <tr>
            <th>name</th>
            <th>image</th>
            <th>quantity</th>
            <th>price</th>
            <th>value</th>
        </tr>
        </thead>
        <tbody>
        <#if cart??>
            <#list cart as item>
                <tr>
                    <td>${item.product.name}</td>
                    <td>
                        <img src="${item.product.image}" height="25px" alt="${item.product.name}">
                    </td>
                        <td>${item.quantity}</td>
                        <td>${item.product.price}</td>
                        <td>${item.product.price * item.quantity}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>


    <h4> Загальна вартість купівлі: ${totalValue} </h4>
    <h4> Загальна кількість нуменклатурних позицій у кошику: ${el}</h4>


    <form>
        <button> Підтвердити замовлення </button>
    </form>




</@p.pages>