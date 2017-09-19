/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import fachada.UsuarioFachada;
import java.util.List;
import model.Pergunta;
import model.Resposta;

/**
 *
 * @author athos.carmo
 */
public class TesteUsuarioFachada {
 
    public static void main(String[] args) {
        
        UsuarioFachada u = new UsuarioFachada();
        u.setNome("Athos");
        u.setEmail("athos@gmail.com");
        u.setSenha("123");
        u.setTipoUsuario("COMUM");
        
        //u.criarUsuario(u);
//        List<Pergunta> p = u.verPerguntas();
//        
//        for(Pergunta perg: p){
//            
//            System.out.println(perg.getId());
//            System.out.println(perg.getMateria());
//            System.out.println(perg.getPeriodo());
//            System.out.println(perg.getDataPostagem());
//            System.out.println(perg.getTextoPergunta());
//            System.out.println(perg.getNomeUsuario());
//        }

        List<Resposta> r = u.verRespostas(1);
        
        for(Resposta resp: r){
            
            System.out.println(resp.getId());
            System.out.println(resp.getDataPostagem());
            System.out.println(resp.getTextoResposta());
            System.out.println(resp.getNomeUsuario());
        }
    }
}
