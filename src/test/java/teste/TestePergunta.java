/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import dao.PerguntaDAO;
import java.sql.Date;
import java.util.List;
import model.Pergunta;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class TestePergunta {
    
    public static void main(String[] args) {
        
        Usuario u = new Usuario();
        u.setId(10);
        
        Pergunta pergunta = new Pergunta();
        //pergunta.setId(2);
        pergunta.setUsuario(u);
        pergunta.setPeriodo("1");
        pergunta.setMateria("PPOS");
        pergunta.setDatapostagem(new Date(System.currentTimeMillis()));
        pergunta.setTextopergunta("olá");
        
        PerguntaDAO perguntaDAO = new PerguntaDAO();
        
        //pergunta = perguntaDAO.buscar(1);
        //System.out.println(pergunta.getDatapostagem()+" "+pergunta.getTextopergunta());
        
        /*List<Pergunta> lista = perguntaDAO.buscarPorUsuario(3);
        for(int i = 0; i < lista.size(); i++){
            Pergunta p = lista.get(i);
            
            System.out.println(p.getDatapostagem()+" "+p.getTextopergunta());
        }*/
        
        List<Pergunta> lista = perguntaDAO.buscarTodas();
        for(int i = 0; i < lista.size(); i++){
            Pergunta p = lista.get(i);
            
            System.out.println(p.getDatapostagem()+" "+p.getTextopergunta());
        }
        
        //perguntaDAO.excluir(2);
        //perguntaDAO.excluirPorUsuario(3);
        
        //perguntaDAO.criar(pergunta);
        
    }
}
