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
public class Comum extends UsuarioFachada {

    public Comum() {
    }

    public Comum(Usuario u) {
        setId(u.getId());
        setNome(u.getNome());
        setEmail(u.getEmail());
        setTipoUsuario(u.getTipoUsuario());
    }

    @Override
    public void alterarUsuario(UsuarioFachada usu) {
        if (getId() == usu.getId()) {

            Usuario u = new Usuario(usu.getId(), usu.getNome(), usu.getEmail(), usu.getSenha(), usu.getTipoUsuario());
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
            em.close();
        }
    }

    //o usuário comum só exclui a sí mesmo
    @Override
    public void excluirUsuario(int idUsuario) {
        if (getId() == idUsuario) {
            em.getTransaction().begin();

            Usuario u = em.find(Usuario.class, idUsuario);

            em.remove(u);
            em.getTransaction().commit();
            em.close();
        }
    }

    //Pergunta
    @Override
    public List<Pergunta> verPerguntas() {

        List<Pergunta> listaPergunta = em.createQuery("select p from Pergunta p").getResultList();

        for (int i = 0; i < listaPergunta.size(); i++) {

            if (getId() == listaPergunta.get(i).getUsuario().getId()) {
                listaPergunta.get(i).setEditar("editar");
                listaPergunta.get(i).setExcluir("excluir");
            }
        }

        return listaPergunta;
    }

    @Override
    public List<Pergunta> verPerguntasProprias() {

        List<Pergunta> listaPergunta = em.createQuery("select p from Pergunta p").getResultList();

        for (int i = 0; i < listaPergunta.size(); i++) {

            listaPergunta.get(i).setEditar("editar");
            listaPergunta.get(i).setExcluir("excluir");
        }

        return listaPergunta;
    }

    @Override
    public void criarPergunta(Pergunta p) {
        if (getId() == p.getUsuario().getId()) {

            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public void editarPergunta(Pergunta p) {
        if (getId() == p.getUsuario().getId()) {

            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public void excluirPergunta(int idPergunta) {
        Pergunta p = em.find(Pergunta.class, idPergunta);

        if (getId() == p.getUsuario().getId()) {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            em.close();
        }
    }

    //Resposta
    @Override
    public List<Resposta> verRespostas(int idPergunta) {

        Query q = em.createQuery("select r from Resposta r where pergunta = :p");
        q.setParameter("p", new Pergunta(idPergunta));
        
        List<Resposta> listaResposta = q.getResultList();
        
        
        for (int i = 0; i < listaResposta.size(); i++) {

            if (getId() == listaResposta.get(i).getUsuario().getId()) {
                listaResposta.get(i).setEditar("editar");
                listaResposta.get(i).setExcluir("excluir");
            }
        }

        return listaResposta;
    }

    @Override
    public void criarResposta(Resposta r) {
        if (getId() == r.getUsuario().getId()) {
            
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public void editarResposta(Resposta r) {
        if (getId() == r.getUsuario().getId()) {
            
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public void excluirResposta(int idResposta) {
        Resposta r = em.find(Resposta.class, idResposta);
                
        if (getId() == r.getUsuario().getId()) {
            
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
            em.close();
        }
    }
}
