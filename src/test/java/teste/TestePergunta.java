package teste;

import dao.Conexao;
import java.util.Date;
import javax.persistence.EntityManager;
import model.Pergunta;
import model.Usuario;

public class TestePergunta {
    
    public static void main(String[] args) {
        
        Usuario usu = new Usuario();
        usu.setId(1);
        
        Pergunta perg = new Pergunta(new Date(), "1", "LPOO", "oi");
        perg.setUsuario(usu);
        
        EntityManager em = Conexao.getConexao();
        
//        em.getTransaction().begin();
//        //em.persist(usu);
//        em.persist(perg);
//        em.getTransaction().commit();
//        em.close();

        Pergunta p = em.find(Pergunta.class, 1);
        
        System.out.println(p.getNomeUsuario());
    }
}
