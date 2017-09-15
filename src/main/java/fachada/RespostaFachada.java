/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dao.RespostaDAO;
import java.util.ArrayList;
import java.util.List;
import model.Resposta;

/**
 *
 * @author Aluno
 */
public class RespostaFachada extends Resposta {

    public RespostaFachada(int i) {
        setId(i);
        respostaDAO = new RespostaDAO();
    }
    
    public RespostaFachada(Resposta r){
        setId(r.getId());
        setPergunta(r.getPergunta());
        setUsuario(r.getUsuario());
        setDatapostagem(r.getDatapostagem());
        setTextoresposta(r.getTextoresposta());
        respostaDAO = new RespostaDAO();
    }
    
    public RespostaFachada() {
        respostaDAO = new RespostaDAO();
    }

    private final RespostaDAO respostaDAO;
    private String editar = "";
    private String excluir = "";
    private String nomeAutor = "";

    public List<RespostaFachada> verRespostas(int idPergunta) {

        List<Resposta> listaResposta = respostaDAO.buscarPorPergunta(idPergunta);
        List<RespostaFachada> listaRespostaFachada = new ArrayList<>();

        for (Resposta listaResposta1 : listaResposta) {
            RespostaFachada resp = new RespostaFachada(listaResposta1);
            listaRespostaFachada.add(resp);
        }

        return listaRespostaFachada;
    }

    public void criar(RespostaFachada r){
        
        Resposta resp = new Resposta();
        resp.setPergunta(r.getPergunta());
        resp.setUsuario(r.getUsuario());
        resp.setDatapostagem(r.getDatapostagem());
        resp.setTextoresposta(r.getTextoresposta());
        
        respostaDAO.criar(resp);
    }
    
    public void editar(RespostaFachada r) {
        
        Resposta resp = new Resposta();
        resp.setId(r.getId());
        resp.setPergunta(r.getPergunta());
        resp.setUsuario(r.getUsuario());
        resp.setDatapostagem(r.getDatapostagem());
        resp.setTextoresposta(r.getTextoresposta());
        
        respostaDAO.alterar(resp);
    }

    public void excluir(int idResposta) {
        
        respostaDAO.excluir(idResposta);
    }

    public void excluirPorPergunta(int idPergunta) {
        
        respostaDAO.excluirPorPergunta(idPergunta);
    }

    public void excluirPorUsuario(int idUsuario) {
        
        respostaDAO.excluirPorUsuario(idUsuario);
    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
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
