<#import "customer/home.ftl" as p>
<#import "/spring.ftl" as s>
<@p.pages>

<h3> Форма реєстрації нового користувача </h3>

<form method="post" action="/registration">

    <@s.bind "users"/>



    <label for="username">Username</label><br>
    <@s.formInput "users.username" 'placeholder="username" id="username"'/><br>
    <@s.showErrors "<br>"/>
    <#if error??>${error}</#if>

    <br>

    <label for="password">Password</label><br>
    <@s.formInput "users.password" 'placeholder="password" id="password"'/><br>
    <@s.showErrors "<br>"/>
    <br>

    <@s.bind "clients"/>

    <label for="firstName">First Name</label><br>
    <@s.formInput "clients.firstName" 'placeholder="firstName" id="firstName"'/><br>
    <@s.showErrors "<br>"/>
    <br>

    <label for="lastName">Last Name</label><br>
    <@s.formInput "clients.lastName" 'placeholder="lastName" id="lastName"'/><br>
    <@s.showErrors "<br>"/>
    <br>

    <label for="phone">Phone</label><br>
    <@s.formInput "clients.phone" 'placeholder="phone" id="phone"'/><br>
    <@s.showErrors "<br>"/>
    <br>

    <label for="email">Email</label><br>
    <@s.formInput "clients.email" 'placeholder="email" id="email"'/><br>
    <@s.showErrors "<br>"/>
    <br>

    <label for="age">Age</label><br>
    <@s.formInput "clients.age" 'placeholder="age" id="age" type="number"'/><br>
    <@s.showErrors "<br>"/>
    <br>


    <input type="submit" value="Add New User">

</form>

</@p.pages>