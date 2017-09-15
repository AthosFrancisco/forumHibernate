/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fachada;

import dao.UsuarioDAO;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class CriarUsuario {
    
    public static UsuarioFachada criar(String login, String senha){
        
        Usuario usu = new Usuario();
        usu.setEmail(login);
        usu.setSenha(senha);
        
        UsuarioDAO usuDAO = new UsuarioDAO();
        Usuario a = usuDAO.busca(usu);
        String tipoUsuario = a.getTipousuario();
        
        switch(tipoUsuario.toUpperCase()){
            case "COMUM":
                return new Comum(a);
            case "MODERADOR":
                return new Moderador(a);
            case "ADMINISTRADOR":
                return new Administrador(a);
            default:
                return new UsuarioFachada();
        }
    }
    
}
