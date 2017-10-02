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
        <script type="text/javascript" src="../js/chamaLogin.js"></script>
        <title>Lista de Usuários</title>
    </head>
    <body>

            <a type="button" href="index.jsp">Home</a>
            <a type="button" href="../perguntas.jsp">Ver Perguntas</a>
            <a id="link" type="button"></a>


            <h1>Lista Usuarios</h1>

            <c:forEach items="${requestScope.listaUsuarios}" var="u">

                <form action="/forumHibernate/UsuarioController" method="post">
                    <input name="acao" id="${u.id}" type="text" value="" readonly="readonly" style="display: none">
                    <input name="senha" type="text" value="${u.senha}" readonly="readonly" style="display: none">
                    <br>Id: <input type="text" name="id" value="${u.id}" readonly="readonly">
                    <br>Nome: <input type="text" name="nome" value="${u.nome}" readonly="readonly">
                    <br>Email: <input type="text" name="email" value="${u.email}" readonly="readonly">
                    <br>Tipo Usuário: <input type="text" value="${u.tipoUsuario}" readonly="readonly">
                    <br><input type="radio" name="tipousuario" value="COMUM"> Comum
                    <input type="radio" name="tipousuario" value="MODERADOR"> Moderador
                    <input type="radio" name="tipousuario" value="ADMINISTRADOR"> Administrador
                    <br><input type="submit" value="editar" onmouseover="document.getElementById('${u.id}').value = 'editarusuario'">
                    <input type="submit" value="excluir" onmouseover="document.getElementById('${u.id}').value = 'excluirusuario'">
                </form>
            </c:forEach>
        </div>
    </body>
</html>
