<%-- 
    Document   : cadastro
    Created on : 16/06/2017, 15:48:23
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cadastro</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">
            <a button type="button" class="btn btn-default" href="IndexController">Home</a>
            <a button type="button" class="btn btn-default" href="UsuarioController?acao=verperguntas">Ver Perguntas</a>
            <a button type="button" class="btn btn-default" href="${applicationScope.link}.jsp">${applicationScope.loginOuUsuario}</a>
            
            <h2>Formulário de Cadastro</h2>

            <form action="UsuarioController" method="post">
                <input name="acao" type="text" value="criarusuario" readonly="readonly" style="display: none">

                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input id="nome" type="text" class="form-control" placeholder="Digite seu nome completo" name="nome">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input id="email" type="email" class="form-control" placeholder="Digite seu email" name="email">
                    ${requestScope.mensagem}
                </div>
                <div class="form-group">
                    <label for="senha">Senha:</label>
                    <input id="senha" type="password" class="form-control" placeholder="Digite sua senha" name="senha">
                </div>
                <button type="submit" class="btn btn-default">Salvar</button>
            </form>
        </div>

    </body>
</html>