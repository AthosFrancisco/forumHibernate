<%-- 
    Document   : perguntaerespostas
    Created on : 16/06/2017, 15:51:42
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
        <title>Perguntas e Respostas</title>
        <style>
            /* Note: Try to remove the following lines to see the effect of CSS positioning */
            .affix {
                top: 0;
                width: 100%;
            }

            .affix + .container-fluid {
                padding-top: 70px;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <a button type="button" class="btn btn-default" href="IndexController">Home</a>
            <a button type="button" class="btn btn-default" href="UsuarioController?acao=verperguntas">Ver Perguntas</a>
            <a button type="button" class="btn btn-default" href="${applicationScope.link}.jsp">${applicationScope.loginOuUsuario}</a><br>

            <div class="container-fluid">
                <h2>Pergunta</h2>
                <p>Autor: ${requestScope.pergunta.nomeUsuario}</p>
                <p>Periodo: ${requestScope.pergunta.periodo}</p>
                <p>Materia: ${requestScope.pergunta.materia}</p>
                <p>Data da postagem: ${requestScope.pergunta.dataPostagem}</p>
                <p>Data da Ultima Alteração: ${requestScope.pergunta.dataUltimaAlteracao}</p>
                <p>Pergunta: ${requestScope.pergunta.textoPergunta}</p>
            </div>

            <h3>Respostas</h3>

            <c:forEach items="${requestScope.listarespostas}" var="r">

                <form action="UsuarioController" method="post">
                    <input name="acao" id="${r.id}" type="text" value="" readonly="readonly" style="display: none">
                    <input type="text" name="id" value="${r.id}" readonly="readonly" style="display: none">
                    <input type="text" name="idusuario" value="${r.usuario.id}" readonly="readonly" style="display: none">
                    <input type="text" name="idpergunta" value="${r.pergunta.id}" readonly="readonly" style="display: none">
                    <input type="text" value="${r.dataPostagem}" readonly="readonly">
                    <input type="text" value="${r.dataUltimaAlteracao}" readonly="readonly">
                    <input type="text" name="nome" value="${r.nomeUsuario}" readonly="readonly">
                    <textarea id="resposta${r.id}" name="textoresposta" readonly="">${r.textoResposta}</textarea>
                    <a onclick="document.getElementById('resposta${r.id}').removeAttribute('readonly')" href="#resposta${r.id}">${r.editar}</a>
                    <input type="submit" value="${r.editar}" onmouseover="document.getElementById('${r.id}').value = '${r.editar}resposta'">
                    <input type="submit" value="${r.excluir}" onmouseover="document.getElementById('${r.id}').value = '${r.excluir}resposta'">
                </form>
                <br>

            </c:forEach>
            <form action="UsuarioController" method="post">
                <input name="acao" type="text" value="criarresposta" readonly="readonly" style="display: none">
                <input type="text" name="idpergunta" value="${requestScope.pergunta.id}" readonly="readonly" style="display: none">
                <textarea type="text" name="textoresposta"></textarea>
                <input type="submit" value="Responder">
            </form>
        </div>
    </body>
</html>
