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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/chamaLogin.js"></script>
        <title>Index</title>
    </head>
    <body>
        <div class="container">

            <a button type="button" class="btn btn-default" href="../index.jsp">Home</a>
            <a button type="button" class="btn btn-default" href="../UsuarioController?acao=verperguntas">Ver Perguntas</a>
            <a button id="link" type="button" class="btn btn-default"></a>
            <form>
                <div class="form-group">
                    <h3>Seja bem vindo ${sessionScope.usuario.nome}!</h3>
                </div>
                <div class="form-group">
                    <a button type="button" class="btn btn-default" href="alterarcadastro.jsp">Alterar Cadastro</a>
                </div>
                <div class="form-group">
                    <a button type="button" class="btn btn-default" href="fazerpergunta.jsp">Fazer Pergunta</a>
                </div>

                <div class="form-group">
                    <a button type="button" class="btn btn-default" href="../UsuarioController?acao=verusuarios">Listar Usuarios</a>
                </div>
                <div class="form-group">
                    <a button type="button" class="btn btn-default" href="perguntasproprias.jsp">Perguntas Proprias</a>
                </div>
                <div class="form-group">
                    <a button type="button" class="btn btn-default" href="../LoginController">Sair</a>
                </div>
            </form>

        </div>
    </body>
</html>
