/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import dao.Conexao;
import java.util.Date;
import javax.persistence.EntityManager;
import model.Pergunta;
import model.Resposta;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class TesteResposta {
    
    public static void main(String[] args) {
        
        Resposta resp = new Resposta(new Date(), "oi");
        resp.setPergunta(new Pergunta(1));
        resp.setUsuario(new Usuario(1));
        
        EntityManager em = Conexao.getConexao();
        
        em.getTransaction().begin();
        em.persist(resp);
        em.getTransaction().commit();
        em.close();
        
    }
}
