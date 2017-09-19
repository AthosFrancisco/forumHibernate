/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class Comum extends UsuarioFachada {

    public Comum(){}
    
    public Comum(Usuario u){
        setId(u.getId());
        setNome(u.getNome());
        setEmail(u.getEmail());
        setTipoUsuario(u.getTipoUsuario());
    }
    
    public void criarUsuario(UsuarioFachada u) {
    }

    @Override
    public void alterarUsuario(UsuarioFachada usu) {
        if (getId() == usu.getId()) {
            
            Usuario u = new Usuario();
            u.setId(usu.getId());
            u.setNome(usu.getNome());
            u.setEmail(usu.getEmail());
            u.setSenha(usu.getSenha());
            u.setTipousuario(usu.getTipousuario());
            
            usuDAO.alterar(u);
        }
    }

    //o usuário comum só exclui a sí mesmo
    @Override
    public void excluirUsuario(int idUsuario) {
        if (getId() == idUsuario) {
            respostaFachada.excluirPorUsuario(idUsuario);
            perguntaFachada.excluirPorUsuario(idUsuario);
            usuDAO.excluir(idUsuario);
        }
    }

    //Pergunta
    @Override
    public List<PerguntaFachada> verPerguntas() {

        List<PerguntaFachada> listaPergunta = perguntaFachada.verPerguntas();
        List<PerguntaFachada> listaPerguntaFachada = new ArrayList<>();

        for (int i = 0; i < listaPergunta.size(); i++) {

            PerguntaFachada perg = listaPergunta.get(i);
            perg.setNomeAutor(usuDAO.buscarNome(perg.getUsuario().getId()));

            if (getId() == perg.getUsuario().getId()) {
                perg.setEditar("editar");
                perg.setExcluir("excluir");
            }

            listaPerguntaFachada.add(perg);
        }

        listaPergunta = null;

        return listaPerguntaFachada;
    }

    @Override
    public List<PerguntaFachada> verPerguntasProprias() {

        List<PerguntaFachada> listaPergunta = perguntaFachada.verPerguntasProprias(getId());
        List<PerguntaFachada> listaPerguntaFachada = new ArrayList<>();

        for (int i = 0; i < listaPergunta.size(); i++) {

            PerguntaFachada perg = listaPergunta.get(i);
            perg.setNomeAutor(usuDAO.buscarNome(perg.getUsuario().getId()));

            perg.setEditar("editar");
            perg.setExcluir("excluir");

            listaPerguntaFachada.add(perg);
        }

        listaPergunta = null;

        return listaPerguntaFachada;
    }

    @Override
    public void criarPergunta(PerguntaFachada p) {
        if (getId() == p.getUsuario().getId()) {
            perguntaFachada.criar(p);
        }
    }

    @Override
    public void editarPergunta(PerguntaFachada p) {
        if (getId() == p.getUsuario().getId()) {
            perguntaFachada.editar(p);
        }
    }

    @Override
    public void excluirPergunta(int idPergunta) {
            perguntaFachada.excluir(idPergunta);
    }

    //Resposta
    @Override
    public List<RespostaFachada> verRespostas(int idPergunta) {

        List<RespostaFachada> listaResposta = respostaFachada.verRespostas(idPergunta);
        List<RespostaFachada> listaRespostaFachada = new ArrayList<>();

        for (int i = 0; i < listaResposta.size(); i++) {

            RespostaFachada resp = listaResposta.get(i);
            resp.setNomeAutor(usuDAO.buscarNome(resp.getUsuario().getId()));

            if (getId() == resp.getUsuario().getId()) {
                resp.setEditar("editar");
                resp.setExcluir("excluir");
            }

            listaRespostaFachada.add(resp);
        }

        listaResposta = null;

        return listaRespostaFachada;
    }

    @Override
    public void criarResposta(RespostaFachada r) {
        if (getId() == r.getUsuario().getId()) {
            respostaFachada.criar(r);
        }
    }

    @Override
    public void editarResposta(RespostaFachada r) {
            respostaFachada.editar(r);
    }

    @Override
    public void excluirResposta(int idResposta) {
        respostaFachada.excluir(idResposta);
    }
}
