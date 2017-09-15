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
    
    public Administrador(){
        super();
    }
    
    public Administrador(Usuario usu){
        super(usu);
    }
    
    @Override
    public List<UsuarioFachada> todosUsuarios(){
        
        List<Usuario> lista = usuDAO.buscarTodos();
        List<UsuarioFachada> listaFachada = new ArrayList<>();
        
        for(Usuario usu: lista){
            
            listaFachada.add(new Administrador(usu));
        }
        
        return listaFachada;
    }
    
    @Override
    public void alterarUsuario(UsuarioFachada usu) {
            
            Usuario u = new Usuario();
            u.setId(usu.getId());
            u.setNome(usu.getNome());
            u.setEmail(usu.getEmail());
            u.setSenha(usu.getSenha());
            u.setTipousuario(usu.getTipousuario());
            
            usuDAO.alterar(u);
    }
    
    @Override
    public void excluirUsuario(int idUsuario) {
        respostaFachada.excluirPorUsuario(idUsuario);
        perguntaFachada.excluirPorUsuario(idUsuario);
        usuDAO.excluir(idUsuario);
    }
}
