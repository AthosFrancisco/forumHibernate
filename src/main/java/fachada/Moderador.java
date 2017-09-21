/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.Pergunta;
import model.Resposta;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class Moderador extends Comum {

    public Moderador() {}

    public Moderador(Usuario usu) {
        super(usu);
    }

    //Pergunta
    @Override
    public List<Pergunta> verPerguntas() {

        em.getTransaction().begin();
        List<Pergunta> listaPergunta = em.createQuery("select p from Pergunta p").getResultList();
        em.close();
        
        for (int i = 0; i < listaPergunta.size(); i++) {

            listaPergunta.get(i).setExcluir("excluir");

            if (getId() == listaPergunta.get(i).getUsuario().getId()) {
                listaPergunta.get(i).setEditar("editar");
            }
        }

        return listaPergunta;
    }

    @Override
    public void excluirPergunta(int idPergunta) {
        
        em.getTransaction().begin();
        Pergunta p = em.find(Pergunta.class, idPergunta);
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    //Resposta
    @Override
    public List<Resposta> verRespostas(int idPergunta) {

        em.getTransaction().begin();
        Query q = em.createQuery("select r from Resposta r where pergunta = :p");
        q.setParameter("p", new Pergunta(idPergunta));
        em.close();
        
        List<Resposta> listaResposta = q.getResultList();
        
        
        for (int i = 0; i < listaResposta.size(); i++) {

            listaResposta.get(i).setExcluir("excluir");
            
            if (getId() == listaResposta.get(i).getUsuario().getId()) {
                listaResposta.get(i).setEditar("editar");
            }
        }

        return listaResposta;
    }
}
