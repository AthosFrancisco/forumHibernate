/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.Conexao;
import java.util.List;
import javax.persistence.EntityManager;
import model.Pergunta;
import model.Usuario;

/**
 *
 * @author ATHOS
 */
public class TesteUsuario {
    
    public static void main(String[] args) {
        
//        Usuario u = new Usuario("Athos", "athos@gmail.com", "123", "MODERADOR");
        
        EntityManager em = Conexao.getConexao();
        
//        em.getTransaction().begin();
//        em.persist(u);
//        em.getTransaction().commit();
//        em.close();
        
        Usuario usu = em.find(Usuario.class, 1);
        
        List<Pergunta> p = usu.getPerguntas();
        
        System.out.println(p.get(0).getDataPostagem());
    }
}
