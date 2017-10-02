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
        <script type="text/javascript" src="../js/chamaLogin.js"></script>
    </head>
    <body>
        <a type="button" class="btn btn-default" href="index.jsp">Home</a>
        <a type="button" class="btn btn-default" href="../perguntas.jsp">Ver Perguntas</a>
        <a id="link" type="button"></a>

        <h2>Alteração de Cadastro</h2>

        <form action="../UsuarioController" method="post">
            <input name="acao" id ="${sessionScope.usuario.id}" value="" readonly="readonly" style="display: none">
            <input type="text" name="id" readonly="readonly" value="${sessionScope.usuario.id}" style="display: none">

            <label for="nome">Nome:</label>
            <input id="nome" value="${sessionScope.usuario.nome}" type="text" class="form-control" placeholder=" Digite seu nome completo" name="nome">
            <label for="email">Email:</label>
            <input id="email" value="${sessionScope.usuario.email}"  type="email" class="form-control" placeholder="Digite seu email" name="email">
            <label for="senha">Senha:</label>
            <input id="senha" value="${sessionScope.usuario.senha}" type="password" class="form-control" placeholder="Digite sua senha" name="senha">
            <input type="text" name="tipousuario" readonly="readonly" value="${sessionScope.usuario.tipoUsuario}" style="display: none">

            <input type="submit" value="Salvar" onmouseover="document.getElementById('${sessionScope.usuario.id}').value = 'editarusuario'">
            <input type="submit" value="Excluir" onmouseover="document.getElementById('${sessionScope.usuario.id}').value = 'excluirusuario'">
        </form>

    </body> 
</html>