/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fachada;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class Administrador extends Moderador{
    
    public Administrador(){}
    
    public Administrador(Usuario usu){
        super(usu);
    }
    
    @Override
    public List<UsuarioFachada> todosUsuarios(){
        
        List<Usuario> lista = em.createQuery("select u from Usuario u").getResultList();
        List<UsuarioFachada> listaFachada = new ArrayList<>();
        
        for(Usuario usu: lista){
            
            listaFachada.add(new Administrador(usu));
        }
        
        return listaFachada;
    }
    
    @Override
    public void alterarUsuario(UsuarioFachada usu) {
            
            Usuario u = new Usuario(usu.getId(), usu.getNome(), usu.getEmail(), usu.getSenha(), usu.getTipoUsuario());
            
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
            em.close();
    }
    
    @Override
    public void excluirUsuario(int idUsuario) {
        
        em.getTransaction().begin();
        
        Usuario u = em.find(Usuario.class, idUsuario);
        
        em.remove(u);
        em.getTransaction().commit();
        em.close();
    }
}
