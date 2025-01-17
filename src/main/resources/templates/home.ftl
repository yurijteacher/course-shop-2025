<#import "customer/home.ftl" as p>
<@p.pages>

<h2>Work area</h2>
<h2> Category </h2>

<div class="row row-cols-2 row-cols-md-3 g-4">

    <#if categories??>

        <#list categories as category>

            <div class="col">
                <div class="card">
                    <a href="/category/${category.id}">
                        <img src="${category.images}" class="card-img-top" alt="${category.name}">
                    </a>
                    <div class="card-body">
                        <h5 class="card-title">${category.name}</h5>
                        <p class="card-text">${category.description}</p>
                    </div>
                </div>
            </div>

        </#list>
    </#if>

</div>


</@p.pages>