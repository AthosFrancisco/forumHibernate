/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import fachada.CriarUsuario;
import fachada.UsuarioFachada;
import java.util.Date;
import model.Pergunta;
import model.Resposta;
import model.Usuario;

/**
 *
 * @author athos.carmo
 */
public class TesteUsuarioComum {
    
    public static void main(String[] args) {
        
        UsuarioFachada u = CriarUsuario.criar("francisco@gmail.com", "123");
        
//        UsuarioFachada usu = new UsuarioFachada();
//        usu.setId(1);
//        usu.setEmail("francisco@gmail.com");
//        usu.setNome("Francisco");
//        usu.setSenha("123");
//        usu.setTipoUsuario("COMUM");
        
        //u.alterarUsuario(usu);
        
        //u.excluirUsuario(1);
        
//        for(Pergunta p: u.verPerguntas()){
//            
//            System.out.println(p.getId());
//            System.out.println(p.getDataPostagem());
//            System.out.println(p.getPeriodo());
//            System.out.println(p.getMateria());
//            System.out.println(p.getTextoPergunta());
//            System.out.println(p.getEditar());
//            System.out.println(p.getExcluir());
//        }

//        Pergunta p = new Pergunta(new Date(), "1", "LPOO", "parabéns");
//        p.setUsuario(u);
//        p.setId(3);
        //u.criarPergunta(p);
        
        //u.editarPergunta(p);
        //u.excluirPergunta(4);
        
//        for(Resposta r: u.verRespostas(5)){
//            
//            System.out.println(r.getId());
//            System.out.println(r.getDataPostagem());
//            System.out.println(r.getTextoResposta());
//            System.out.println(r.getEditar());
//            System.out.println(r.getExcluir());
//        }
        
        Resposta r = new Resposta(new Date(), "oiiii");
        r.setPergunta(new Pergunta(7));
        r.setUsuario(u);
        r.setId(11);
        //u.criarResposta(r);
        
        //u.editarResposta(r);
        u.excluirResposta(12);
    }
}
