/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Resposta;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Aluno
 */
public class RespostaDAO {

    private static Session s;

    public void criar(Resposta r) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        s.saveOrUpdate(r);
        s.getTransaction().commit();
        s.close();
    }

    public void alterar(Resposta r) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        s.saveOrUpdate(r);
        s.getTransaction().commit();
        s.close();
    }

    public void excluir(int idResposta) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        Query q = s.createQuery("delete from Resposta r where id = :id");
        q.setParameter("id", idResposta);
        q.executeUpdate();
        s.getTransaction().commit();
        s.close();
    }

    //quando a pergunta for excluída todas as respostas vinculadas à ela também serão excluídos
    public void excluirPorPergunta(int idPergunta) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        Query q = s.createQuery("delete from Resposta r where idpergunta = :idpergunta");
        q.setParameter("idpergunta", idPergunta);
        q.executeUpdate();
        s.getTransaction().commit();
        s.close();

    }

    //quando o usuario excluir sua conta excluirá todas as respostas feitas por ele
    public void excluirPorUsuario(int idUsuario) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        Query q = s.createQuery("delete from Resposta r where idusuario = :idusuario");
        q.setParameter("idusuario", idUsuario);
        q.executeUpdate();
        s.getTransaction().commit();
        s.close();
    }

    //cria lista de respostas vinculadas à pergunta
    public List<Resposta> buscarPorPergunta(int idPergunta) {
        s = Conexao.getInstancia().getSessao();
        Query q = s.createQuery("select r from Resposta r where idpergunta = :idpergunta");
        q.setParameter("idpergunta", idPergunta);
        List<Resposta> lista = q.list();
        s.close();
        return lista;
    }
}
