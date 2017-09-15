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
                                                    <label>Período:</label><br> 
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
                                                                        <label>Matéria:</label><br> 
                                                                            <select name="materia" id="materias"><br><br>

                                                                                        <option></option>
                                                                                        <option class="periodo1" value="Lingua Inglesa Aplicado">Lingua Inglesa Aplicado</option>
                                                                                        <option class="periodo1" value="Iniciação à Informatica">Iniciação à Informatica</option>
                                                                                        <option class="periodo1" value="Introdução a Programação">Introdução a Programação</option>
                                                                                        <option class="periodo1" value="Matemática Aplicada">Matemática Aplicada</option>
                                                                                        <option class="periodo1" value="Lógica Aplicada">Lógica Aplicada</option>
                                                                                        <option class="periodo1" value="Relações Humanas do Trabalho">Relações Humanas do Trabalho</option>
                                                                                        <option class="periodo1" value="Empreendedoris em Negócios de TIC">Empreendedoris em Negócios de TIC</option>

                                                                                        <option class="periodo2" value="Arquitetura de Computadores">Arquitetura de Computadores</option>
                                                                                        <option class="periodo2" value="Linguagem de Programação Orientada a Objetos">Linguagem de Programação Orientada a Objetos</option>
                                                                                        <option class="periodo2" value="Banco de Dados I">Banco de Dados I</option>
                                                                                        <option class="periodo2" value="Engenharia de Requisitos">Engenharia de Requisitos</option>
                                                                                        <option class="periodo2" value="Engenharia de Software">Engenharia de Software</option>
                                                                                        <option class="periodo2" value="Ética e Responsabilidade Socioambiental em TI">Ética e Responsabilidade Socioambiental em TI</option>

                                                                                        <option class="periodo3" value="Linguagem de Definição de Dados">Linguagem de Definição de Dados</option>
                                                                                        <option class="periodo3" value="Algoritmo e Estrutura de Dados">Algoritmo e Estrutura de Dados</option>
                                                                                        <option class="periodo3" value="Desenvolvimento de Sistemas Web I">Desenvolvimento de Sistemas Web I</option>
                                                                                        <option class="periodo3" value="Banco de Dados II">Banco de Dados II</option>
                                                                                        <option class="periodo3" value="Análise e Projeto de Sistema">Análise e Projeto de Sistema</option>
                                                                                        <option class="periodo3" value="Redes de Computadores">Redes de Computadores</option>

                                                                                        <option class="periodo4" value="Sistemas Operacionais">Sistemas Operacionais</option>
                                                                                        <option class="periodo4" value="Padrões de Projeto de Software Orientado a Objetos">Padrões de Projeto de Software Orientado a Objetos</option>
                                                                                        <option class="periodo4" value="Desenvolvimento de Sistemas Web II">Desenvolvimento de Sistemas Web II</option>
                                                                                        <option class="periodo4" value="Gerência de Configuração e Mudança de Software">Gerência de Configuração e Mudança de Software</option>
                                                                                        <option class="periodo4" value="Processo de Desenvolvimento de Software">Processo de Desenvolvimento de Software</option>
                                                                                        <option class="periodo4" value="Metodologia Científica e Aplicada">Metodologia Científica e Aplicada</option>
                                                                                        <option class="periodo4" value="Sistemas Distribuídos">Sistemas Distribuídos</option>

                                                                                        <option class="periodo5" value="Projeto de Desenvolvimento de Sistemas Web">Projeto de Desenvolvimento de Sistemas Web</option>
                                                                                        <option class="periodo5" value="Desenvolvimento de Software Corporativo">Desenvolvimento de Software Corporativo</option>
                                                                                        <option class="periodo5" value="Desenvolvimento de Sistemas Web III">Desenvolvimento de Sistemas Web III</option>
                                                                                        <option class="periodo5" value="Teste de Software">Teste de Software</option>
                                                                                        <option class="periodo5" value="Modelagem de Processo de Negócio">Modelagem de Processo de Negócio</option>
                                                                                        <option class="periodo5" value="Orientação de Trabalho de Conclusão de Curso I">Orientação de Trabalho de Conclusão de Curso I</option>

                                                                                        <option class="periodo6" value="Programação para Dispositivos Móveis">Programação para Dispositivos Móveis</option>
                                                                                        <option class="periodo6" value="Projeto de Desenvolvimento de Sistema Corporativo">Projeto de Desenvolvimento de Sistema Corporativo</option>
                                                                                        <option class="periodo6" value="Segurança da Informação">Segurança da Informação</option>
                                                                                        <option class="periodo6" value="Gerenciamento de Projetos">Gerenciamento de Projetos</option>
                                                                                        <option class="periodo6" value="Modelos de Melhoria de Processo de Software">Modelos de Melhoria de Processo de Software</option>
                                                                                        <option class="periodo6" value="Legislação para Informática">Legislação para Informática</option>
                                                                                        <option class="periodo6" value="Orientação de Trabalho de Conclusão de Curso II">Orientação de Trabalho de Conclusão de Curso II</option>

                                                                                        <option class="eletivas" value="Análise e Modelagem Multidimensional">Análise e Modelagem Multidimensional</option>
                                                                                        <option class="eletivas" value="Arquitetura Orientada a Serviços">Arquitetura Orientada a Serviços</option>
                                                                                        <option class="eletivas" value="Educação Inclusiva">Educação Inclusiva</option>
                                                                                        <option class="eletivas" value="Processos Ágeis de Desenvolvimento de Software">Processos Ágeis de Desenvolvimento de Software</option>
                                                                                        <option class="eletivas" value="Sistemas de Tempo Real">Sistemas de Tempo Real</option>
                                                                                        <option class="eletivas" value="Inteligência Artificial">Inteligência Artificial</option>
                                                                                        <option class="eletivas" value="Linguagem de Programação Orientada a Aspectos">Linguagem de Programação Orientada a Aspectos</option>
                                                                                        <option class="eletivas" value="Otimização e Programação Linear">Otimização e Programação Linear</option>
                                                                                        <option class="eletivas" value="Segurança no Desenvolvimento de Software">Segurança no Desenvolvimento de Software</option>
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
