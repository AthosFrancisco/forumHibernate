/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class UsuarioFachada extends Usuario {

    public UsuarioFachada(int id) {
        this.setId(id);
        usuDAO = new UsuarioDAO();
        perguntaFachada = new PerguntaFachada();
        respostaFachada = new RespostaFachada();
    }

    public UsuarioFachada() {
        setTipousuario("Deslogado");
        usuDAO = new UsuarioDAO();
        perguntaFachada = new PerguntaFachada();
        respostaFachada = new RespostaFachada();
    }

    protected static UsuarioDAO usuDAO;
    protected static PerguntaFachada perguntaFachada;
    protected static RespostaFachada respostaFachada;
    
    public void criarUsuario(UsuarioFachada usu) {

        Usuario u = new Usuario();
        u.setId(usu.getId());
        u.setNome(usu.getNome());
        u.setEmail(usu.getEmail());
        u.setSenha(usu.getSenha());
        u.setTipousuario(usu.getTipousuario());

        usuDAO.criar(u);
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
    public List<PerguntaFachada> verPerguntas() {

        List<PerguntaFachada> listaPergunta = perguntaFachada.verPerguntas();
        List<PerguntaFachada> listaPerguntaFachada = new ArrayList<>();

        for (int i = 0; i < listaPergunta.size(); i++) {

            PerguntaFachada perg = listaPergunta.get(i);
            perg.setNomeAutor(usuDAO.buscarNome(perg.getUsuario().getId()));

            listaPerguntaFachada.add(perg);
        }

        return listaPerguntaFachada;
    }

    public List<PerguntaFachada> verPerguntasProprias() {

        return null;
    }

    public PerguntaFachada verPergunta(int idPergunta) {

        PerguntaFachada pergFacha = perguntaFachada.verPergunta(idPergunta);
        pergFacha.setNomeAutor(usuDAO.buscarNome(pergFacha.getUsuario().getId()));

        return pergFacha;
    }

    public void criarPergunta(PerguntaFachada p) {
    }

    public void editarPergunta(PerguntaFachada p) {
    }

    public void excluirPergunta(int idPergunta) {
    }

    //Resposta
    public List<RespostaFachada> verRespostas(int idPergunta) {

        List<RespostaFachada> listaResposta = respostaFachada.verRespostas(idPergunta);
        List<RespostaFachada> listaRespostaFachada = new ArrayList<>();

        for (int i = 0; i < listaResposta.size(); i++) {

            RespostaFachada resp = listaResposta.get(i);
            resp.setNomeAutor(usuDAO.buscarNome(resp.getUsuario().getId()));

            listaRespostaFachada.add(resp);
        }

        listaResposta = null;

        return listaRespostaFachada;
    }

    public void criarResposta(RespostaFachada r) {
    }

    public void editarResposta(RespostaFachada r) {
    }

    public void excluirResposta(int idResposta) {
    }
}
