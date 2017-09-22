/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fachada;

import model.Conexao;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class CriarUsuario {
    
    public static UsuarioFachada criar(String login, String senha){
        
        EntityManager em = Conexao.getConexao();
        
        Query q = em.createQuery("select u from Usuario u where u.email = :email and u.senha = :senha");
        
        q.setParameter("email", login);
        q.setParameter("senha", senha);
        
        Usuario usu = (Usuario)q.getSingleResult();
        
        String tipoUsuario = usu.getTipoUsuario();
        
        switch(tipoUsuario.toUpperCase()){
            case "COMUM":
                return new Comum(usu);
            case "MODERADOR":
                return new Moderador(usu);
            case "ADMINISTRADOR":
                return new Administrador(usu);
            default:
                return new UsuarioFachada();
        }
    }
    
}
