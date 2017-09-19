/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.List;
import model.Pergunta;
import model.Usuario;
import model.Resposta;

/**
 *
 * @author Aluno
 */
public class UsuarioFachada extends Usuario {

    public UsuarioFachada() {
    }
    
    public void criarUsuario(UsuarioFachada usu) {
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
        return null;
    }

    public List<Pergunta> verPerguntasProprias() {

        return null;
    }

    public Pergunta verPergunta(int idPergunta) {
        
        return null;
    }

    public void criarPergunta(Pergunta p) {
    }

    public void editarPergunta(Pergunta p) {
    }

    public void excluirPergunta(int idPergunta) {
    }

    //Resposta
    public List<Resposta> verRespostas(int idPergunta) {

        return null;
    }

    public void criarResposta(Resposta r) {
    }

    public void editarResposta(Resposta r) {
    }

    public void excluirResposta(int idResposta) {
    }
}
