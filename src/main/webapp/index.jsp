<%-- 
    Document   : index
    Created on : 16/06/2017, 15:47:12
    Author     : Aluno
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tela inicial</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/chamaLogin.js"></script>
    </head>
    <body>
        <div class="container">
            <a button type="button" class="btn btn-default" href="index.jsp">Home</a>
            <a button type="button" class="btn btn-default" href="perguntas.jsp">Ver Perguntas</a>
            <a button id="link" type="button" class="btn btn-default"></a>

            <div class="alert alert-success alert-dismissable">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                <strong>Seja bem vindo!</strong> Você está na página inicial do fórum.
            </div>


        </div>
    </body>
</html>
