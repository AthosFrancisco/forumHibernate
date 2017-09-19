/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dao.Conexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Pergunta;
import model.Usuario;
import model.Resposta;

/**
 *
 * @author Aluno
 */
public class UsuarioFachada extends Usuario {
    
    
    protected static EntityManager em = Conexao.getConexao();
    
    protected static Usuario passarParaUsuario(UsuarioFachada usu){
        Usuario u = new Usuario(usu.getNome(), usu.getEmail(), usu.getSenha(), usu.getTipoUsuario());
        return u;
    }
    
    public void criarUsuario(UsuarioFachada usu) {
        
        em.getTransaction().begin();
        em.persist(passarParaUsuario(usu));
        em.getTransaction().commit();
        em.close();
    }

    public void alterarUsuario(UsuarioFachada usu) {
    }

    //o usuário comum só exclui a sí mesmo
    public void excluirUsuario(int idUsuario) {
    }

    public List<UsuarioFachada> todosUsuarios() {
        return null;
    }

    //Pergunta
    public List<Pergunta> verPerguntas() {
        
        List<Pergunta> perguntas = em.createQuery("SELECT p FROM Pergunta p").getResultList();
        
        return perguntas;
    }

    public List<Pergunta> verPerguntasProprias() {

        return null;
    }

    public Pergunta verPergunta(int idPergunta) {
        
        Pergunta p = em.find(Pergunta.class, idPergunta);
        
        return p;
    }

    public void criarPergunta(Pergunta p) {
    }

    public void editarPergunta(Pergunta p) {
    }

    public void excluirPergunta(int idPergunta) {
    }

    //Resposta
    public List<Resposta> verRespostas(int idPergunta) {
        
        Query q = em.createQuery("SELECT r FROM Resposta r WHERE r.pergunta = :idpergunta");
        q.setParameter("idpergunta", q);
        
        List<Resposta> respostas = q.getResultList();
        
        return respostas;
    }

    public void criarResposta(Resposta r) {
    }

    public void editarResposta(Resposta r) {
    }

    public void excluirResposta(int idResposta) {
    }
}
