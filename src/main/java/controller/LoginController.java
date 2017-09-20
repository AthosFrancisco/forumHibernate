/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fachada.CriarUsuario;
import fachada.UsuarioFachada;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aluno
 */
public class LoginController extends HttpServlet {

    public static void logar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession(false);

        if (sessao != null) {
            sessao.invalidate();
        }
        
        try {
            ServletContext contexto = request.getServletContext();
            sessao = request.getSession();

            UsuarioFachada usuarioFachada = CriarUsuario.criar(request.getParameter("email"), request.getParameter("senha"));

            sessao.setAttribute("usuario", usuarioFachada);
            contexto.setAttribute("usuario", sessao.getAttribute("usuario"));

            contexto.setAttribute("link", "usuario/index");
            contexto.setAttribute("loginOuUsuario", "Página do Usuário");

            RequestDispatcher saida = request.getRequestDispatcher("usuario/index.jsp");
            saida.forward(request, response);
        } 
        catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", "Login ou senha incorreta");
            RequestDispatcher saida = request.getRequestDispatcher("login.jsp");
            saida.forward(request, response);
        }
    }

    public static void deslogar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession(false);

        if (sessao != null) {
            sessao.invalidate();
        }

        ServletContext contexto = request.getServletContext();
        contexto.setAttribute("usuario", new UsuarioFachada());

        contexto.setAttribute("link", "login");
        contexto.setAttribute("loginOuUsuario", "Login");

        RequestDispatcher saida = request.getRequestDispatcher("index.jsp");

        synchronized (LoginController.class) {
            if (!response.isCommitted()) {
                saida.forward(request, response);
            } else {
                System.out.println("foi comitado");
                response.sendRedirect("index.jsp");
            }

        }
    }

    public static UsuarioFachada retornaUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto = request.getServletContext();
        UsuarioFachada usuarioFachada = (UsuarioFachada) request.getSession(false).getAttribute("usuario");

        if (usuarioFachada == null) {

            usuarioFachada = new UsuarioFachada();
            contexto.setAttribute("link", "login");
            contexto.setAttribute("loginOuUsuario", "Login");
            System.out.println("primeiro se");

        } /*else if(usuarioFachada.getTipousuario().equals("Deslogado")){

         contexto.setAttribute("link", "login");
         contexto.setAttribute("loginOuUsuario", "Login");
         System.out.println("segundo se");
         }*/ else {
            contexto.setAttribute("link", "usuario/index");
            contexto.setAttribute("loginOuUsuario", "Página do Usuário");
            System.out.println("terceiro se");
        }

        contexto.setAttribute("usuario", usuarioFachada);
        return usuarioFachada;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Deslogar
        deslogar(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logar(request, response);
    }

}
