<%-- 
    Document   : perguntasproprias
    Created on : 16/06/2017, 15:53:23
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
        <title>Minhas Perguntas</title>
    </head>
    <body>
        <div class="container">
            
            <a button type="button" class="btn btn-default" href="/forumH/IndexController">Home</a>
            <a button type="button" class="btn btn-default" href="/forumH/UsuarioController?acao=verperguntas">Ver Perguntas</a>
            <a button type="button" class="btn btn-default" href="/forumH/${applicationScope.link}.jsp">${applicationScope.loginOuUsuario}</a><br>
            
         <h1>Minhas Perguntas</h1>

        <c:forEach items="${requestScope.listaperguntas}" var="p">
            
            <form action="UsuarioController" method="post">
                <input name="acao" id="${p.id}" type="text" value="" readonly="readonly" style="display: none">
                <br><input type="text" name="id" value="${p.id}" readonly="readonly" style="display: none">
                <br><input type="text" name="idusuario" value="${p.usuario.id}" readonly="readonly" style="display: none">
                <br>Período: <input type="text" name="periodo" value="${p.periodo}" readonly="readonly">
                <br>Matéria: <input type="text" name="materia" value="${p.materia}" readonly="readonly">
                <br>Data da Postagem: <input type="text" name="data" value="${p.datapostagem}" readonly="readonly">
                <br>Pergunta: <textarea id="pergunta${p.id}" name="textopergunta" readonly="">${p.textopergunta}</textarea>
                <a onclick="document.getElementById('pergunta${p.id}').removeAttribute('readonly')" href="#pergunta${p.id}">${p.editar}</a>
                <br>Autor: <input type="text" name="nome" value="${p.nomeAutor}" readonly="readonly">
                <br><input type="submit" value="${p.editar}" onmouseover="document.getElementById('${p.id}').value = '${p.editar}pergunta'">
                <input type="submit" value="${p.excluir}" onmouseover="document.getElementById('${p.id}').value = '${p.excluir}pergunta'">
                <input type="submit" value="Ver Pergunta" onmouseover="document.getElementById('${p.id}').value = 'verperguntaerespostas'">
            </form>
                
        </c:forEach>
         </div>
    </body>
</html>
