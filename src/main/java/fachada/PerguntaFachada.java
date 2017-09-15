/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dao.PerguntaDAO;
import java.util.ArrayList;
import java.util.List;
import model.Pergunta;

/**
 *
 * @author Aluno
 */
public class PerguntaFachada extends Pergunta {

    public PerguntaFachada(int i) {
        setId(i);
        perguntaDAO = new PerguntaDAO();
    }
    
    public PerguntaFachada(Pergunta p){
        setId(p.getId());
        setPeriodo(p.getPeriodo());
        setMateria(p.getMateria());
        setDatapostagem(p.getDatapostagem());
        setUsuario(p.getUsuario());
        setTextopergunta(p.getTextopergunta());
        perguntaDAO = new PerguntaDAO();
    }
    
    public PerguntaFachada() {
        perguntaDAO = new PerguntaDAO();
    }

    private static PerguntaDAO perguntaDAO;
    private String editar = "";
    private String excluir = "";
    private String nomeAutor = "";
    
    static{
        perguntaDAO = new PerguntaDAO();
    }

    public List<PerguntaFachada> verPerguntas() {

        List<Pergunta> listaPergunta = perguntaDAO.buscarTodas();
        List<PerguntaFachada> listaPerguntaFachada = new ArrayList<>();

        for (int i = 0; i < listaPergunta.size(); i++) {
            PerguntaFachada perg = new PerguntaFachada(listaPergunta.get(i));

            listaPerguntaFachada.add(perg);
        }

        return listaPerguntaFachada;
    }

    public List<PerguntaFachada> verPerguntasProprias(int idUsuario) {

        List<Pergunta> listaPergunta = perguntaDAO.buscarPorUsuario(idUsuario);
        List<PerguntaFachada> listaPerguntaFachada = new ArrayList<>();

        for (int i = 0; i < listaPergunta.size(); i++) {
            PerguntaFachada perg = new PerguntaFachada(listaPergunta.get(i));

            listaPerguntaFachada.add(perg);
        }

        return listaPerguntaFachada;
    }

    public PerguntaFachada verPergunta(int idPergunta) {

        PerguntaFachada pergFacha = new PerguntaFachada(perguntaDAO.buscar(idPergunta));

        return pergFacha;
    }

    public void criar(PerguntaFachada p) {
        
        Pergunta perg = new Pergunta();
        perg.setUsuario(p.getUsuario());
        perg.setMateria(p.getMateria());
        perg.setPeriodo(p.getPeriodo());
        perg.setDatapostagem(p.getDatapostagem());
        perg.setTextopergunta(p.getTextopergunta());
        
        perguntaDAO.criar(perg);
    }
    
    public void editar(PerguntaFachada p) {
        
        Pergunta perg = new Pergunta();
        perg.setId(p.getId());
        perg.setUsuario(p.getUsuario());
        perg.setDatapostagem(p.getDatapostagem());
        perg.setPeriodo(p.getPeriodo());
        perg.setMateria(p.getMateria());
        perg.setTextopergunta(p.getTextopergunta());
        
        perguntaDAO.alterar(perg);
    }

    public void excluir(int idPergunta) {

        RespostaFachada respFacha = new RespostaFachada();
        
        respFacha.excluirPorPergunta(idPergunta);
        perguntaDAO.excluir(idPergunta);
    }

    public void excluirPorUsuario(int idUsuario) {

        List<Pergunta> lista = perguntaDAO.buscarPorUsuario(idUsuario);
        
        RespostaFachada respFacha = new RespostaFachada();
        
        for(Pergunta p: lista){
            respFacha.excluirPorPergunta(p.getId());
        }
        
        perguntaDAO.excluirPorUsuario(idUsuario);
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    public String getEditar() {
        return editar;
    }

    public void setEditar(String editar) {
        this.editar = editar;
    }

    public String getExcluir() {
        return excluir;
    }

    public void setExcluir(String excluir) {
        this.excluir = excluir;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

}
