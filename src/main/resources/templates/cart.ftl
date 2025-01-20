<#import "customer/home.ftl" as p>
<@p.pages>

    <h2>Cart</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>name</th>
            <th>image</th>
            <th>quantity</th>
            <th>price</th>
            <th>value</th>
            <th>update</th>
            <th>delete</th>
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
                    <form method="post" action="/updateItemInCart">
                        <td><input type="number" name="quantity" value="${item.quantity}" min="0" max="100" step="1"/> </td>
                        <td>${item.product.price}</td>
                        <td>${item.product.price * item.quantity}</td>
                        <td>
                            <input type="hidden" name="id" value="${item.product.id}">
                            <button>update</button>
                        </td>
                    </form>

                    <td>
                        <form method="post" action="/deleteItemFromCart">
                            <input type="hidden" name="id" value="${item.product.id}">
                            <button>delete</button>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>


    <h3> Вартість покупки:  ${totalValue} </h3>
    <h3> Загальна кількість елементів кошику: ${el}</h3>

    <form action="/deleteAllItems" method="post">
        <button> delete All</button>
    </form>

    <hr>

    <form method="get" action="/order">

        <button> Перейти на форму підтвердження замовлення </button>
    </form>

</@p.pages>