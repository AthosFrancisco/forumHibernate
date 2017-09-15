/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fachada.PerguntaFachada;
import fachada.RespostaFachada;
import fachada.UsuarioFachada;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class UsuarioController extends HttpServlet {

    private static UsuarioFachada usuarioFachada;

    /**
     * VerUsuarios Criar Usuario Alterar Usuario Excluir Usuario
     *
     * Ver Perguntas Criar Pergunta Alterar Pergunta Excluir Pergunta
     *
     * Ver Pergunta e Respostas
     *
     * Criar Resposta Alterar Resposta Excluir Resposta
     */
    private void verUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("listaUsuarios", usuarioFachada.todosUsuarios());

        RequestDispatcher saida = request.getRequestDispatcher("usuario/listausuarios.jsp");
        saida.forward(request, response);
    }

    private void criarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            UsuarioFachada usu = new UsuarioFachada();
            usu.setNome(request.getParameter("nome"));
            usu.setEmail(request.getParameter("email"));
            usu.setSenha(request.getParameter("senha"));
            usu.setTipousuario("Comum");

            usuarioFachada.criarUsuario(usu);

            LoginController.logar(request, response);

        } catch (Exception e) {
            request.setAttribute("mensagem", "Email já existe");
            RequestDispatcher saida = request.getRequestDispatcher("cadastro.jsp");
            saida.forward(request, response);
        }
    }

    private void alterarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            System.out.println(Integer.parseInt(request.getParameter("id")));
            UsuarioFachada usu = new UsuarioFachada();
            usu.setId(Integer.parseInt(request.getParameter("id")));
            usu.setNome(request.getParameter("nome"));
            usu.setEmail(request.getParameter("email"));
            usu.setSenha(request.getParameter("senha"));
            usu.setTipousuario(request.getParameter("tipousuario"));

            usuarioFachada.alterarUsuario(usu);

            if (usuarioFachada.getId() == usu.getId()) {
                LoginController.logar(request, response);
            } else {
                verUsuarios(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void excluirUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuarioFachada.excluirUsuario(Integer.parseInt(request.getParameter("id")));

        if (usuarioFachada.getId() != Integer.parseInt(request.getParameter("id"))) {
            verUsuarios(request, response);
        } else {
            LoginController.deslogar(request, response);
        }
    }

    private void verPerguntas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("listaperguntas", usuarioFachada.verPerguntas());

        RequestDispatcher saida = request.getRequestDispatcher("perguntas.jsp");
        saida.forward(request, response);

    }

    private void verPerguntasProprias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("listaperguntas", usuarioFachada.verPerguntasProprias());

        RequestDispatcher saida = request.getRequestDispatcher("usuario/perguntasproprias.jsp");
        saida.forward(request, response);
    }

    //tentar recuperar pergunta criada e abrir diretamente a página com esta pergunta
    private void criarPergunta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PerguntaFachada perg = new PerguntaFachada();
        perg.setUsuario(usuarioFachada);
        perg.setPeriodo(request.getParameter("periodo"));
        perg.setMateria(request.getParameter("materia"));
        perg.setDatapostagem(new Date(System.currentTimeMillis()));
        perg.setTextopergunta(request.getParameter("textopergunta"));

        usuarioFachada.criarPergunta(perg);

        //tentar recuperar pergunta criada e abrir diretamente a página com esta pergunta
        request.setAttribute("listaperguntas", usuarioFachada.verPerguntas());

        RequestDispatcher saida = request.getRequestDispatcher("perguntas.jsp");
        saida.forward(request, response);
    }

    private void alterarPergunta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idPergunta = Integer.parseInt(request.getParameter("id"));

        PerguntaFachada perg = new PerguntaFachada();
        perg.setId(idPergunta);
        perg.setUsuario(usuarioFachada);
        perg.setPeriodo(request.getParameter("periodo"));
        perg.setMateria(request.getParameter("mateira"));
        perg.setDatapostagem(Date.valueOf(request.getParameter("data")));
        perg.setTextopergunta(request.getParameter("textopergunta"));

        usuarioFachada.editarPergunta(perg);

        verPerguntas(request, response);
    }

    private void excluirPergunta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(Integer.parseInt(request.getParameter("id")));

        usuarioFachada.excluirPergunta(Integer.parseInt(request.getParameter("id")));

        verPerguntas(request, response);
    }

    private void verPerguntaERespostas(HttpServletRequest request, HttpServletResponse response, int idPergunta)
            throws ServletException, IOException {

        request.setAttribute("pergunta", usuarioFachada.verPergunta(idPergunta));
        request.setAttribute("listarespostas", usuarioFachada.verRespostas(idPergunta));

        RequestDispatcher saida = request.getRequestDispatcher("perguntaerespostas.jsp");
        saida.forward(request, response);
    }

    private void criarResposta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idPergunta = Integer.parseInt(request.getParameter("idpergunta"));

        RespostaFachada resp = new RespostaFachada();
        resp.setUsuario(usuarioFachada);
        resp.setPergunta(new PerguntaFachada(idPergunta));
        resp.setDatapostagem(new Date(System.currentTimeMillis()));
        resp.setTextoresposta(request.getParameter("textoresposta"));

        usuarioFachada.criarResposta(resp);

        verPerguntaERespostas(request, response, idPergunta);
    }

    private void alterarResposta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idPergunta = Integer.parseInt(request.getParameter("idpergunta"));

        RespostaFachada resp = new RespostaFachada();
        resp.setId(Integer.parseInt(request.getParameter("id")));
        resp.setUsuario(usuarioFachada);
        resp.setPergunta(new PerguntaFachada(idPergunta));
        resp.setDatapostagem(Date.valueOf(request.getParameter("data")));
        resp.setTextoresposta(request.getParameter("textoresposta"));

        usuarioFachada.editarResposta(resp);

        verPerguntaERespostas(request, response, idPergunta);
    }

    private void excluirResposta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idPergunta = Integer.parseInt(request.getParameter("idpergunta"));

        usuarioFachada.excluirResposta(Integer.parseInt(request.getParameter("id")));

        verPerguntaERespostas(request, response, idPergunta);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuarioFachada = LoginController.retornaUsuario(request, response);

        String acao = request.getParameter("acao").toUpperCase();
        System.out.println(acao);
        System.out.println(usuarioFachada.getTipousuario());

        switch (acao) {
            case "VERUSUARIOS":
                verUsuarios(request, response);
                break;
            case "CRIARUSUARIO":
                criarUsuario(request, response);
                break;
            case "EDITARUSUARIO":
                alterarUsuario(request, response);
                break;
            case "EXCLUIRUSUARIO":
                excluirUsuario(request, response);
                break;
            case "VERPERGUNTAS":
                verPerguntas(request, response);
                break;
            case "VERPERGUNTASPROPRIAS":
                verPerguntasProprias(request, response);
                break;
            case "CRIARPERGUNTA":
                criarPergunta(request, response);
                break;
            case "EDITARPERGUNTA":
                alterarPergunta(request, response);
                break;
            case "EXCLUIRPERGUNTA":
                excluirPergunta(request, response);
                break;
            case "VERPERGUNTAERESPOSTAS":
                verPerguntaERespostas(request, response, Integer.parseInt(request.getParameter("id")));
                break;
            case "CRIARRESPOSTA":
                criarResposta(request, response);
                break;
            case "EDITARRESPOSTA":
                alterarResposta(request, response);
                break;
            case "EXCLUIRRESPOSTA":
                excluirResposta(request, response);
                break;
            default:
                System.out.println("opção inválida");
                response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuarioFachada = LoginController.retornaUsuario(request, response);

        System.out.println(usuarioFachada.getNome());

        String acao = request.getParameter("acao").toUpperCase();
        System.out.println(acao);
        System.out.println(usuarioFachada.getTipousuario());

        switch (acao) {
            case "VERUSUARIOS":
                verUsuarios(request, response);
                break;
            case "CRIARUSUARIO":
                criarUsuario(request, response);
                break;
            case "EDITARUSUARIO":
                alterarUsuario(request, response);
                break;
            case "EXCLUIRUSUARIO":
                excluirUsuario(request, response);
                break;
            case "VERPERGUNTAS":
                verPerguntas(request, response);
                break;
            case "VERPERGUNTASPROPRIAS":
                verPerguntasProprias(request, response);
                break;
            case "CRIARPERGUNTA":
                criarPergunta(request, response);
                break;
            case "EDITARPERGUNTA":
                alterarPergunta(request, response);
                break;
            case "EXCLUIRPERGUNTA":
                excluirPergunta(request, response);
                break;
            case "VERPERGUNTAERESPOSTAS":
                verPerguntaERespostas(request, response, Integer.parseInt(request.getParameter("id")));
                break;
            case "CRIARRESPOSTA":
                criarResposta(request, response);
                break;
            case "EDITARRESPOSTA":
                alterarResposta(request, response);
                break;
            case "EXCLUIRRESPOSTA":
                excluirResposta(request, response);
                break;
            default:
                System.out.println("opção inválida");
                response.sendRedirect("index.jsp");
        }
    }

}