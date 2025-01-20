<#import "customer/home.ftl" as p>

<@p.pages>

    <h3> Форма аутентифікації користувача у системі</h3>

    <form action="/login" method="post">
        <label for="username">Username</label>
        <input type="text" name="username" placeholder="username" id="username"><br>

        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="password"><br>

        <input type="submit" value="Add">
        <a href="/registration"> Перехід на сторінку реєстрації </a>
    </form>

</@p.pages>