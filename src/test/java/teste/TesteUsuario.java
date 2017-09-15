/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.UsuarioDAO;
import java.util.List;
import model.Usuario;

/**
 *
 * @author ATHOS
 */
public class TesteUsuario {
    
    public static void main(String[] args) {
        
        Usuario u = new Usuario();
        //u.setId(3);
        u.setNome("miria");
        u.setEmail("miria@hotmail.com");
        u.setSenha("123");
        u.setTipousuario("Comum");
        
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.criar(u);
        
        //Usuario usu = usuDAO.busca(u);
        //System.out.println(usu.getNome() +" "+usu.getSenha());
        
        //String nome = usuDAO.buscarNome(usu.getId());
        //System.out.println(nome);
        
        //List<Usuario> usu = usuDAO.buscarTodos();
        
        /*for(int i = 0; i < usu.size(); i++){
            Usuario a = usu.get(i);
            
            System.out.println(a.getId()+" "+a.getNome()+" "+a.getEmail()+" "+a.getSenha()+" "+a.getTipousuario());
        }*/
        
        //usuDAO.excluir(u.getId());
        
        //Usuario a = usuDAO.busca(u);
        
        //System.out.println(a.getTipoUsuario());
    }
}
