<%-- 
    Document   : login
    Created on : 23/06/2017, 02:12:49
    Author     : ATHOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Login</title>
    </head>
    <body>

        <div class="container">
            <a button type="button" class="btn btn-default" href="IndexController">Home</a>
            <a button type="button" class="btn btn-default" href="UsuarioController?acao=verperguntas">Ver Perguntas</a>
            <a button type="button" class="btn btn-default" href="${applicationScope.link}.jsp">${applicationScope.loginOuUsuario}</a>

            <form action="LoginController" method="post">
                <h3>Login</h3>
                <div class="form-group">
                    <label>Email:</label><br>
                    <input name="email" type="email">
                </div>
                <div class="form-group">
                    <label>Senha:</label><br>
                    <input name="senha" type="password">
                </div>
                <input type="submit" value="Enviar"><br><br>
                ${requestScope.mensagem}
                <a button type="button" class="btn btn-default" href="cadastro.jsp">Fazer Cadastro</a>
            </form>
        </div>

    </body>
</html>
