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
        <script type="text/javascript" src="js/chamaLogin.js"></script>
    </head>
    <body>

        <a href="index.jsp">Home</a>
        <a type="button" href="perguntas.jsp">Ver Perguntas</a>
        <a button id="link" type="button"></a>
        <h2>Formulário de Cadastro</h2>

        <form action="UsuarioController" method="post">
            <input name="acao" type="text" value="criarusuario" readonly="readonly" style="display: none">

            <label for="nome">Nome:</label>
            <input id="nome" type="text" placeholder="Digite seu nome completo" name="nome">
            <label for="email">Email:</label>
            <input id="email" type="email" placeholder="Digite seu email" name="email">
            ${requestScope.mensagem}
            <label for="senha">Senha:</label>
            <input id="senha" type="password" placeholder="Digite sua senha" name="senha">
            <button type="submit">Salvar</button>
        </form>

    </body>
</html>