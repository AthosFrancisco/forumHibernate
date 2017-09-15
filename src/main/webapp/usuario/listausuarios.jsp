<%-- 
    Document   : listausuarios
    Created on : 16/06/2017, 15:55:19
    Author     : Aluno
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Lista de Usuários</title>
    </head>
    <body>
        <div class="container">

            <a button type="button" class="btn btn-default" href="/forumH/IndexController">Home</a>
            <a button type="button" class="btn btn-default" href="/forumH/UsuarioController?acao=verperguntas">Ver Perguntas</a>
            <a button type="button" class="btn btn-default" href="/forumH/${applicationScope.link}.jsp">${applicationScope.loginOuUsuario}</a><br>


            <h1>Lista Usuarios</h1>

            <c:forEach items="${requestScope.listaUsuarios}" var="u">

                <form action="/forumH/UsuarioController" method="post">
                    <input name="acao" id="${u.id}" type="text" value="" readonly="readonly" style="display: none">
                    <input name="senha" type="text" value="${u.senha}" readonly="readonly" style="display: none">
                    <br>Id: <input type="text" name="id" value="${u.id}" readonly="readonly">
                    <br>Nome: <input type="text" name="nome" value="${u.nome}" readonly="readonly">
                    <br>Email: <input type="text" name="email" value="${u.email}" readonly="readonly">
                    <br>Tipo Usuário: <input type="text" value="${u.tipousuario}" readonly="readonly">
                    <br><input type="radio" name="tipousuario" value="Comum"> Comum
                    <input type="radio" name="tipousuario" value="Moderador"> Moderador
                    <input type="radio" name="tipousuario" value="Administrador"> Administrador
                    <br><input type="submit" value="editar" onmouseover="document.getElementById('${u.id}').value = 'editarusuario'">
                    <input type="submit" value="excluir" onmouseover="document.getElementById('${u.id}').value = 'excluirusuario'">
                </form>
            </c:forEach>
        </div>
    </body>
</html>
