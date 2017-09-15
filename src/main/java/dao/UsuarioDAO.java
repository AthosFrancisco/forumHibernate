/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO {

    private static Session s;
    //criar ou atualizar usuario
    public void criar(Usuario usu) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        s.save(usu);
        s.getTransaction().commit();
        s.close();
    }

    public void alterar(Usuario usu) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        s.update(usu);
        s.getTransaction().commit();
        s.close();
    }

    public void excluir(int idUsuario) {
        s = Conexao.getInstancia().getSessao();
        s.beginTransaction();
        Usuario u = new Usuario();
        u.setId(idUsuario);u.setNome("");u.setEmail("");u.setSenha("");u.setTipousuario("");
        s.delete(u);
        s.getTransaction().commit();
        s.close();
    }

    //usuario faz login e busca a si mesmo
    public Usuario busca(Usuario usu) {
        s = Conexao.getInstancia().getSessao();
        Query q = s.createQuery("select u from Usuario u WHERE u.email = :email and u.senha = :senha");

        q.setParameter("email", usu.getEmail());
        q.setParameter("senha", usu.getSenha());

        Usuario u = (Usuario) q.uniqueResult();
        s.close();
        return u;
    }

    //administrador busca todos os usuários
    public List<Usuario> buscarTodos() {
        s = Conexao.getInstancia().getSessao();
        List<Usuario> lista = s.createQuery("from Usuario u").list();
        s.close();
        return lista;
    }

    public String buscarNome(int idUsuario) {
        s = Conexao.getInstancia().getSessao();
        Query q = s.createQuery("from Usuario u where id = :id");
        q.setParameter("id", idUsuario);

        Usuario u = (Usuario) q.uniqueResult();

        String nome = u.getNome();

        s.close();
        return nome;
    }
}
