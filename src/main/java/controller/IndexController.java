/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fachada.UsuarioFachada;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

/**
 *
 * @author ATHOS
 */
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> textos = new ArrayList<String>();

        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            UsuarioFachada usuarioFachada = (UsuarioFachada) request.getSession(false).getAttribute("usuario");

            if (request.getSession(false) == null || usuarioFachada == null) {

                textos.add("login.jsp");
                textos.add("Login");

            } else {
                if (usuarioFachada.getTipoUsuario() == null) {
                    textos.add("../login.jsp");
                    textos.add("Login");
                } else {
                    textos.add("index.jsp");
                    textos.add("Página Usuário");
                }
            }

            JSONArray array = new JSONArray(textos);

            out.print(array.toString());
        }
    }

}
