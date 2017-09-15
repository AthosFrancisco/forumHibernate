/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import dao.RespostaDAO;
import java.sql.Date;
import java.util.List;
import model.Pergunta;
import model.Resposta;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class TesteResposta {
    
    public static void main(String[] args) {
        
        Usuario u = new Usuario();
        u.setId(4);
        
        Pergunta p = new Pergunta();
        p.setId(3);
        
        Resposta resposta = new Resposta();
        //resposta.setId(1);
        resposta.setDatapostagem(new Date(System.currentTimeMillis()));
        resposta.setPergunta(p);
        resposta.setUsuario(u);
        resposta.setTextoresposta("olá");
        
        
        RespostaDAO respostaDAO = new RespostaDAO();
        
        /*List<Resposta> lista = respostaDAO.buscarPorPergunta(p.getId());
        for(int i = 0; i < lista.size(); i++){
            Resposta r = lista.get(i);
            
            System.out.println(r.getId()+" "+r.getTextoresposta()+" "+r.getDatapostagem());
        }*/
        
        //respostaDAO.excluir(1);
        //respostaDAO.excluirPorPergunta(p.getId());
        //respostaDAO.excluirPorUsuario(u.getId());
        respostaDAO.criar(resposta);
    }
}
