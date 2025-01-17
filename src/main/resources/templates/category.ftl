<#import "customer/home.ftl" as p>

<@p.pages>
    <h1>${category}</h1>
    <div class="row row-cols-2 row-cols-md-3 g-4">
        <#if products??>
        <#list products as product>
            <form method="post" action="/addToCart">
            <div class="col">
                <div class="card">
                        <img src="${product.image}" class="card-img-top" alt="${product.name}">
                    <div class="card-body">
                        <h5 class="card-title text-center">${product.name}</h5>
                        <p class="card-text text-center">${product.categories.name}</p>
                        <p class="card-text text-center">${product.description}</p>
                        <p class="card-text text-center"><b> ${product.price?c} </b>грн.</p>
                    </div>

                    <div class="d-flex justify-content-center align-items-center">
                        <input type="hidden" name="id" value="${product.id}">
                        <input type="number" name="quantity" value="0" min="0" max="1000" step="1">
                    </div>

                    <div class="d-flex justify-content-center align-items-center mt-2">
<#--                        <input type="submit" value="Add To Cart" class="btn btn-success mt-b">-->
                        <button class="btn btn-success mt-b"> Add To Cart</button>
                    </div>
                    <div class="mt-2"></div>
                </div>
            </div>
            </form>
        </#list>
    </#if>
    </div>

</@p.pages>