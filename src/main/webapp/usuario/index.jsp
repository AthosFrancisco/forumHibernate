<%-- 
    Document   : index
    Created on : 16/06/2017, 15:52:25
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="../js/chamaLogin.js"></script>
        <title>Index</title>
    </head>
    <body>
        <a button type="button" class="btn btn-default" href="../index.jsp">Home</a>
        <a button type="button" class="btn btn-default" href="../perguntas.jsp">Ver Perguntas</a>
        <a id="link" type="button"></a>


        <h1>Seja bem vindo ${sessionScope.usuario.nome}!</h1>
        <p><a type="button" href="alterarcadastro.jsp">Alterar Cadastro</a></p>
        <p><a type="button" href="fazerpergunta.jsp">Fazer Pergunta</a></p>
        <p><a button type="button" href="../UsuarioController?acao=verusuarios">Listar Usuarios</a></p>
        <p><a button type="button" class="btn btn-default" href="perguntasproprias.jsp">Perguntas Proprias</a></p>
        <p><a button type="button" class="btn btn-default" href="../LoginController">Sair</a></p>

    </body>
</html>
