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
        <script type="text/javascript" src="../js/perguntasProprias.js"></script>
        <title>Minhas Perguntas</title>
    </head>
    <body>

        <a button type="button" href="../index.jsp">Home</a>
        <a button type="button" href="../UsuarioController?acao=verperguntas">Ver Perguntas</a>
        <a button id="link" type="button"></a>

        <h1>Minhas Perguntas</h1>

        <div id="perguntas">
            
        </div>
        
    </body>
</html>
