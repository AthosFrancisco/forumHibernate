/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fachada.UsuarioFachada;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ATHOS
 */
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto = request.getServletContext();
        UsuarioFachada usuarioFachada = (UsuarioFachada) request.getSession(false).getAttribute("usuario");

        if (request.getSession(false) == null || usuarioFachada == null) {

            usuarioFachada = new UsuarioFachada();
            contexto.setAttribute("link", "login");
            contexto.setAttribute("loginOuUsuario", "Login");
            System.out.println("primeiro se");
            
        } /*else if(usuarioFachada.getTipousuario().equals("Deslogado")){

            contexto.setAttribute("link", "login");
            contexto.setAttribute("loginOuUsuario", "Login");
            System.out.println("segundo se");
        }*/
        else{
            contexto.setAttribute("link", "usuario/index");
            contexto.setAttribute("loginOuUsuario", "Página do Usuário");
            System.out.println("terceiro se");
        }
        
        contexto.setAttribute("usuario", usuarioFachada);
        
        RequestDispatcher saida = request.getRequestDispatcher("index.jsp");
        saida.forward(request, response);
    }

}
