<%-- 
    Document   : fazerpergunta
    Created on : 16/06/2017, 15:53:05
    Author     : Aluno
--%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
    <head>
        <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
                    <title>Fazer pergunta</title>
                    <style type="text/css">
                        #materias option{
                            display: none;
                        }
                    </style>
                    <script type="text/javascript">
                        function mostraVisibilidade(nome) {
                            var x = document.getElementsByClassName(nome);
                            var i = x.length;

                            apagarVisibilidade();

                            while (i--) {
                                x[i].style.display = "block";
                            }
                        }

                        function apagarVisibilidade() {
                            var x = document.getElementById("materias").children;
                            var i = x.length;

                            while (i--) {
                                x[i].style.display = "none";
                            }
                        }
                    </script>
                    <title>Fazer Pergunta</title>
                    </head>
                    <body>
                        <div class="container">

                            <a button type="button" class="btn btn-default" href="/forumH/IndexController">Home</a>
                            <a button type="button" class="btn btn-default" href="/forumH/UsuarioController?acao=verperguntas">Ver Perguntas</a>
                            <a button type="button" class="btn btn-default" href="/forumH/${applicationScope.link}.jsp">${applicationScope.loginOuUsuario}</a><br>
                                <h1>Fazer Pergunta</h1><br><br>

                                        <form action="/forumH/UsuarioController" method="post">
                                            <input name="acao" type="text" value="criarpergunta" readonly="readonly" style="display: none">
                                                <div class="form-group">
                                                    <label>Per�odo:</label><br> 
                                                        <select name="periodo" id="periodos"><br><br>

                                                                    <option></option>
                                                                    <option value="1" onclick="mostraVisibilidade('periodo1')">1</option>
                                                                    <option value="2" onclick="mostraVisibilidade('periodo2')">2</option>
                                                                    <option value="3" onclick="mostraVisibilidade('periodo3')">3</option>
                                                                    <option value="4" onclick="mostraVisibilidade('periodo4')">4</option>
                                                                    <option value="5" onclick="mostraVisibilidade('periodo5')">5</option>
                                                                    <option value="6" onclick="mostraVisibilidade('periodo6')">6</option>
                                                                    <option value="eletiva" onclick="mostraVisibilidade('eletivas')">eletiva</option>
                                                                    </select>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label>Mat�ria:</label><br> 
                                                                            <select name="materia" id="materias"><br><br>

                                                                                        <option></option>
                                                                                        <option class="periodo1" value="Lingua Inglesa Aplicado">Lingua Inglesa Aplicado</option>
                                                                                        <option class="periodo1" value="Inicia��o � Informatica">Inicia��o � Informatica</option>
                                                                                        <option class="periodo1" value="Introdu��o a Programa��o">Introdu��o a Programa��o</option>
                                                                                        <option class="periodo1" value="Matem�tica Aplicada">Matem�tica Aplicada</option>
                                                                                        <option class="periodo1" value="L�gica Aplicada">L�gica Aplicada</option>
                                                                                        <option class="periodo1" value="Rela��es Humanas do Trabalho">Rela��es Humanas do Trabalho</option>
                                                                                        <option class="periodo1" value="Empreendedoris em Neg�cios de TIC">Empreendedoris em Neg�cios de TIC</option>

                                                                                        <option class="periodo2" value="Arquitetura de Computadores">Arquitetura de Computadores</option>
                                                                                        <option class="periodo2" value="Linguagem de Programa��o Orientada a Objetos">Linguagem de Programa��o Orientada a Objetos</option>
                                                                                        <option class="periodo2" value="Banco de Dados I">Banco de Dados I</option>
                                                                                        <option class="periodo2" value="Engenharia de Requisitos">Engenharia de Requisitos</option>
                                                                                        <option class="periodo2" value="Engenharia de Software">Engenharia de Software</option>
                                                                                        <option class="periodo2" value="�tica e Responsabilidade Socioambiental em TI">�tica e Responsabilidade Socioambiental em TI</option>

                                                                                        <option class="periodo3" value="Linguagem de Defini��o de Dados">Linguagem de Defini��o de Dados</option>
                                                                                        <option class="periodo3" value="Algoritmo e Estrutura de Dados">Algoritmo e Estrutura de Dados</option>
                                                                                        <option class="periodo3" value="Desenvolvimento de Sistemas Web I">Desenvolvimento de Sistemas Web I</option>
                                                                                        <option class="periodo3" value="Banco de Dados II">Banco de Dados II</option>
                                                                                        <option class="periodo3" value="An�lise e Projeto de Sistema">An�lise e Projeto de Sistema</option>
                                                                                        <option class="periodo3" value="Redes de Computadores">Redes de Computadores</option>

                                                                                        <option class="periodo4" value="Sistemas Operacionais">Sistemas Operacionais</option>
                                                                                        <option class="periodo4" value="Padr�es de Projeto de Software Orientado a Objetos">Padr�es de Projeto de Software Orientado a Objetos</option>
                                                                                        <option class="periodo4" value="Desenvolvimento de Sistemas Web II">Desenvolvimento de Sistemas Web II</option>
                                                                                        <option class="periodo4" value="Ger�ncia de Configura��o e Mudan�a de Software">Ger�ncia de Configura��o e Mudan�a de Software</option>
                                                                                        <option class="periodo4" value="Processo de Desenvolvimento de Software">Processo de Desenvolvimento de Software</option>
                                                                                        <option class="periodo4" value="Metodologia Cient�fica e Aplicada">Metodologia Cient�fica e Aplicada</option>
                                                                                        <option class="periodo4" value="Sistemas Distribu�dos">Sistemas Distribu�dos</option>

                                                                                        <option class="periodo5" value="Projeto de Desenvolvimento de Sistemas Web">Projeto de Desenvolvimento de Sistemas Web</option>
                                                                                        <option class="periodo5" value="Desenvolvimento de Software Corporativo">Desenvolvimento de Software Corporativo</option>
                                                                                        <option class="periodo5" value="Desenvolvimento de Sistemas Web III">Desenvolvimento de Sistemas Web III</option>
                                                                                        <option class="periodo5" value="Teste de Software">Teste de Software</option>
                                                                                        <option class="periodo5" value="Modelagem de Processo de Neg�cio">Modelagem de Processo de Neg�cio</option>
                                                                                        <option class="periodo5" value="Orienta��o de Trabalho de Conclus�o de Curso I">Orienta��o de Trabalho de Conclus�o de Curso I</option>

                                                                                        <option class="periodo6" value="Programa��o para Dispositivos M�veis">Programa��o para Dispositivos M�veis</option>
                                                                                        <option class="periodo6" value="Projeto de Desenvolvimento de Sistema Corporativo">Projeto de Desenvolvimento de Sistema Corporativo</option>
                                                                                        <option class="periodo6" value="Seguran�a da Informa��o">Seguran�a da Informa��o</option>
                                                                                        <option class="periodo6" value="Gerenciamento de Projetos">Gerenciamento de Projetos</option>
                                                                                        <option class="periodo6" value="Modelos de Melhoria de Processo de Software">Modelos de Melhoria de Processo de Software</option>
                                                                                        <option class="periodo6" value="Legisla��o para Inform�tica">Legisla��o para Inform�tica</option>
                                                                                        <option class="periodo6" value="Orienta��o de Trabalho de Conclus�o de Curso II">Orienta��o de Trabalho de Conclus�o de Curso II</option>

                                                                                        <option class="eletivas" value="An�lise e Modelagem Multidimensional">An�lise e Modelagem Multidimensional</option>
                                                                                        <option class="eletivas" value="Arquitetura Orientada a Servi�os">Arquitetura Orientada a Servi�os</option>
                                                                                        <option class="eletivas" value="Educa��o Inclusiva">Educa��o Inclusiva</option>
                                                                                        <option class="eletivas" value="Processos �geis de Desenvolvimento de Software">Processos �geis de Desenvolvimento de Software</option>
                                                                                        <option class="eletivas" value="Sistemas de Tempo Real">Sistemas de Tempo Real</option>
                                                                                        <option class="eletivas" value="Intelig�ncia Artificial">Intelig�ncia Artificial</option>
                                                                                        <option class="eletivas" value="Linguagem de Programa��o Orientada a Aspectos">Linguagem de Programa��o Orientada a Aspectos</option>
                                                                                        <option class="eletivas" value="Otimiza��o e Programa��o Linear">Otimiza��o e Programa��o Linear</option>
                                                                                        <option class="eletivas" value="Seguran�a no Desenvolvimento de Software">Seguran�a no Desenvolvimento de Software</option>
                                                                                        <option class="eletivas" value="Sistemas Embarcados">Sistemas Embarcados</option>
                                                                                        </select>
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <label>Pergunta:</label><br> 
                                                                                                <textarea name="textopergunta"></textarea>
                                                                                        </div>
                                                                                        <input type="submit" value="Perguntar">
                                                                                            </form>
                                                                                            </div>
                                                                                            </body>
                                                                                            </html>
