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
        <script type="text/javascript" src="js/chamaLogin.js"></script>
        <title>Login</title>
    </head>
    <body>

        <div class="container">
            <a type="button" href="index.jsp">Home</a>
            <a type="button" href="perguntas.jsp">Ver Perguntas</a>
            <a id="link" type="button" class="btn btn-default"></a>

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
