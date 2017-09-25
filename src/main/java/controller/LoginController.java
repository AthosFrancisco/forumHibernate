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
            sessao = request.getSession();

            UsuarioFachada usuarioFachada = CriarUsuario.criar(request.getParameter("email"), request.getParameter("senha"));

            sessao.setAttribute("usuario", usuarioFachada);

            RequestDispatcher saida = request.getRequestDispatcher("usuario/index.jsp");
            saida.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", "Login ou senha incorreta");
            RequestDispatcher saida = request.getRequestDispatcher("login.jsp");
            saida.forward(request, response);
        }
    }

    public static void deslogar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession(false);

        if (sessao == null) {
            sessao = request.getSession(true);
        }

        sessao.setAttribute("usuario", new UsuarioFachada());

        RequestDispatcher saida = request.getRequestDispatcher("index.jsp");
        saida.forward(request, response);
    }


public static UsuarioFachada retornaUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession(false);
        UsuarioFachada usuarioFachada = (UsuarioFachada) sessao.getAttribute("usuario");
        
        if(sessao == null || usuarioFachada == null){
            sessao = request.getSession(true);
            usuarioFachada = new UsuarioFachada();
            sessao.setAttribute("usuario", usuarioFachada);
            
            System.out.println(usuarioFachada);
        }else{
            usuarioFachada = (UsuarioFachada) sessao.getAttribute("usuario");
        }
        
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
