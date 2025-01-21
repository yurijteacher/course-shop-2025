<#import "customer/home.ftl" as p>

<@p.pages>

<h3> Оформлення замовлення </h3>

    <h4> Інформація про користувача </h4>
    <hr>
    <ul>
        <li>${client.firstName}</li>
        <li>${client.lastName}</li>
        <li>${client.email}</li>
        <li>${client.phone}</li>
    </ul>

    <hr>
    <h4> Дані про обрану продукцію </h4>
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


    <form method="post" action="/buy">

        <hr>
    <h4> Вибір способу доставки </h4>
        <select name="delivery">
            <option value="1">Самовивіз</option>
            <option value="2">Нова пошта</option>
            <option value="3">Доставка кур'єром</option>
        </select>

    <hr>
    <h4> Вибір способу оплати </h4>
        <input type="radio" name="payment" value="1"> Готівка <br>
        <input type="radio" name="payment" value="2"> Банківська карта <br>


    <hr>


        <button> Підтвердити замовлення </button>
    </form>


</@p.pages>