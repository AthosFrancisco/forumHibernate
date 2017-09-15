/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Pergunta;
import org.hibernate.Query;

/**
 *
 * @author Aluno
 */
public class PerguntaDAO {
    
    private static EntityManager em;

    //cria lista de perguntas para qualquer pessoa ver
    public List<Pergunta> buscarTodas() {
        em = Conexao.getConexao();
        em.getTransaction().begin();
        List<Pergunta> lista = em.;
        em.close();
        return lista;
    }

    public Pergunta buscar(int idPergunta) {
        em = Conexao.getConexao();
        em.getTransaction();
        Pergunta p = (Pergunta) em.get(Pergunta.class, idPergunta);
        em.close();
        return p;
    }

    public void criar(Pergunta p) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        s.saveOrUpdate(p);
        s.getTransaction().commit();
        s.close();
    }

    public void alterar(Pergunta p) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        s.saveOrUpdate(p);
        s.getTransaction().commit();
        s.close();
    }

    public void excluir(int idPergunta) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        Query q = s.createQuery("delete from Pergunta p where id = :id");
        q.setParameter("id", idPergunta);
        q.executeUpdate();
        s.getTransaction().commit();
        s.close();
    }

    //quando o usuario excluir sua conta excluirá todas as perguntas feitas por ele
    public void excluirPorUsuario(int idUsuario) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        Query q = s.createQuery("delete from Pergunta p where idusuario = :idusuario");
        q.setParameter("idusuario", idUsuario);
        q.executeUpdate();
        s.getTransaction().commit();
        s.close();
    }

    //cria lista de perguntas que usuario para o mesmo ver
    public List<Pergunta> buscarPorUsuario(int idUsuario) {
        s = Conexao.getInstancia().getSessao();
        Query q = s.createQuery("select p from Pergunta p where idusuario = :idusuario");
        q.setParameter("idusuario", idUsuario);
        List<Pergunta> lista = q.list();
        s.close();
        return lista;
    }
}
