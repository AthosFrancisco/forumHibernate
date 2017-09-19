/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.Conexao;
import javax.persistence.EntityManager;
import model.Usuario;

/**
 *
 * @author ATHOS
 */
public class TesteUsuario {
    
    public static void main(String[] args) {
        
        Usuario u = new Usuario("Athos", "athos@gmail.com", "123", "ADMINISTRADOR");
        
        EntityManager em = Conexao.getConexao();
        
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }
}
