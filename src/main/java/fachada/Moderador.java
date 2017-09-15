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
public class Moderador extends Comum{

    public Moderador(){
        super();
    }
    
    public Moderador(Usuario usu){
        super(usu);
    }
    
    //Pergunta
    @Override
    public List<PerguntaFachada> verPerguntas(){
        
        List<PerguntaFachada> listaPergunta = perguntaFachada.verPerguntas();
        List<PerguntaFachada> listaPerguntaFachada = new ArrayList<>();

        for (int i = 0; i < listaPergunta.size(); i++) {

            PerguntaFachada perg = listaPergunta.get(i);
            perg.setNomeAutor(usuDAO.buscarNome(perg.getUsuario().getId()));

            perg.setExcluir("excluir");
            
            if (getId() == perg.getUsuario().getId()) {
                perg.setEditar("editar");
            }

            listaPerguntaFachada.add(perg);
        }

        listaPergunta = null;

        return listaPerguntaFachada;
    }
    
    @Override
    public void excluirPergunta(int idPergunta) {
        perguntaFachada.excluir(idPergunta);
    }
    
    //Resposta
    @Override
    public List<RespostaFachada> verRespostas(int idPergunta){
        
        List<RespostaFachada> listaResposta = respostaFachada.verRespostas(idPergunta);
        List<RespostaFachada> listaRespostaFachada = new ArrayList<>();

        for (int i = 0; i < listaResposta.size(); i++) {

            RespostaFachada resp = listaResposta.get(i);
            resp.setNomeAutor(usuDAO.buscarNome(resp.getUsuario().getId()));

            resp.setExcluir("excluir");
            
            if (getId() == resp.getUsuario().getId()) {
                resp.setEditar("editar");
            }
            
            listaRespostaFachada.add(resp);
        }

        listaResposta = null;

        return listaRespostaFachada;
    }
}
