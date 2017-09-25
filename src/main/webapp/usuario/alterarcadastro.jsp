<%-- 
    Document   : alterarcadastro
    Created on : 16/06/2017, 15:52:40
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Alteração de cadastro</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/chamaLogin.js"></script>
    </head>
    <body>
        <div class="container">
            <a button type="button" class="btn btn-default" href="index.jsp">Home</a>
            <a button type="button" class="btn btn-default" href="../UsuarioController?acao=verperguntas">Ver Perguntas</a>
            <a button id="link" type="button" class="btn btn-default"></a>

            <h2>Alteração de Cadastro</h2>

            <form action="/forumHibernate/UsuarioController" method="post">
                <input name="acao" id ="${sessionScope.usuario.id}" value="" readonly="readonly" style="display: none">
                <input type="text" name="id" readonly="readonly" value="${sessionScope.usuario.id}" style="display: none">

                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input id="nome" value="${sessionScope.usuario.nome}" type="text" class="form-control" placeholder=" Digite seu nome completo" name="nome">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input id="email" value="${sessionScope.usuario.email}"  type="email" class="form-control" placeholder="Digite seu email" name="email">
                </div>
                <div class="form-group">
                    <label for="senha">Senha:</label>
                    <input id="senha" value="${sessionScope.usuario.senha}" type="password" class="form-control" placeholder="Digite sua senha" name="senha">
                </div>
                <input type="text" name="tipousuario" readonly="readonly" value="${sessionScope.usuario.tipoUsuario}" style="display: none">

                <input type="submit" class="btn btn-default" value="Salvar" onmouseover="document.getElementById('${sessionScope.usuario.id}').value = 'editarusuario'">
                <input type="submit" class="btn btn-default" value="Excluir" onmouseover="document.getElementById('${sessionScope.usuario.id}').value = 'excluirusuario'">
            </form>
        </div>

    </body> 
</html>