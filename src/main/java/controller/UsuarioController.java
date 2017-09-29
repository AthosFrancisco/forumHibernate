/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import model.Pergunta;
import model.Resposta;
import fachada.UsuarioFachada;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

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
            usu.setTipoUsuario("COMUM");

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
            usu.setTipoUsuario(request.getParameter("tipousuario"));

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

//        request.setAttribute("listaperguntas", usuarioFachada.verPerguntas());
//        RequestDispatcher saida = request.getRequestDispatcher("perguntas.jsp");
//        saida.forward(request, response);
        List<Pergunta> lista = usuarioFachada.verPerguntas();
        JSONArray array = new JSONArray();

        for (Pergunta p : lista) {
            array.put(p.getJSONObject());
        }

        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().print(array.toString());
    }

    private void verPerguntasProprias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        request.setAttribute("listaperguntas", usuarioFachada.verPerguntasProprias());
//
//        RequestDispatcher saida = request.getRequestDispatcher("usuario/perguntasproprias.jsp");
//        saida.forward(request, response);
        List<Pergunta> lista = usuarioFachada.verPerguntasProprias();
        JSONArray array = new JSONArray();

        for (Pergunta p : lista) {
            array.put(p.getJSONObject());
        }

        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().print(array.toString());
    }

    //tentar recuperar pergunta criada e abrir diretamente a página com esta pergunta
    private void criarPergunta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pergunta perg = new Pergunta(new Date(), request.getParameter("periodo"), request.getParameter("materia"), request.getParameter("textopergunta"));
        perg.setUsuario(usuarioFachada);

        usuarioFachada.criarPergunta(perg);

        //tentar recuperar pergunta criada e abrir diretamente a página com esta pergunta
        request.setAttribute("listaperguntas", usuarioFachada.verPerguntas());

        RequestDispatcher saida = request.getRequestDispatcher("perguntas.jsp");
        saida.forward(request, response);
    }

    private void alterarPergunta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idPergunta = Integer.parseInt(request.getParameter("id"));

        Pergunta perg = new Pergunta(request.getParameter("periodo"), request.getParameter("materia"), request.getParameter("textopergunta"));
        perg.setDataUltimaAlteracao(new Date());
        perg.setId(idPergunta);

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

        Resposta resp = new Resposta(new Date(), request.getParameter("textoresposta"));
        resp.setUsuario(usuarioFachada);
        resp.setPergunta(new Pergunta(idPergunta));

        usuarioFachada.criarResposta(resp);

        verPerguntaERespostas(request, response, idPergunta);
    }

    private void alterarResposta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idPergunta = Integer.parseInt(request.getParameter("idpergunta"));

        Resposta resp = new Resposta(request.getParameter("textoresposta"));
        resp.setDataUltimaAlteracao(new Date());
        resp.setId(Integer.parseInt(request.getParameter("id")));
        resp.setUsuario(usuarioFachada);
        resp.setPergunta(new Pergunta(idPergunta));

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

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuarioFachada = LoginController.retornaUsuario(request, response);

        String acao = request.getParameter("acao").toUpperCase();

        System.out.println(acao);

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
