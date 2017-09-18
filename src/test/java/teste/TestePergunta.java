package teste;

import dao.Conexao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import model.Pergunta;
import model.Usuario;

public class TestePergunta {
    
    public static void main(String[] args) {
        
        Calendar data = Calendar.getInstance();
        data.set(2017, Calendar.SEPTEMBER, 4);
        
        Usuario usu = new Usuario("athos", "athos@gmail.com", "123", "ADMINISTRADOR");
        
        //Pergunta perg = new Pergunta(data, "1", "LPOO", "oi");
        
        EntityManager em = Conexao.getConexao();
        
        em.getTransaction().begin();
        em.persist(usu);
        //em.persist(perg);
        em.getTransaction().commit();
        em.close();
    }
}
