/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import fachada.CriarUsuario;
import fachada.PerguntaFachada;
import fachada.RespostaFachada;
import fachada.UsuarioFachada;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class TesteUsuarioFachada {

    public static void main(String[] args) {

        UsuarioFachada usuarioFachada;

        usuarioFachada = CriarUsuario.criar("francisco@hotmail.com", "123");
        //usuarioFachada = new UsuarioFachada();
        //System.out.println(usuarioFachada.getNome());
        
        UsuarioFachada u = new UsuarioFachada();
        //u.setId(10);
        u.setNome("athos");
        u.setEmail("athos@hotmail.com");
        u.setSenha("123");
        u.setTipousuario("Administrador");

        PerguntaFachada p = new PerguntaFachada();
        //p.setId(2);
        p.setUsuario(new UsuarioFachada(1));
        p.setPeriodo("eletivo");
        p.setMateria("LPOO");
        p.setTextopergunta("olá");
        p.setDatapostagem(new Date(System.currentTimeMillis()));

        RespostaFachada r = new RespostaFachada();
        r.setId(4);
        r.setPergunta(new PerguntaFachada(1));
        r.setUsuario(new UsuarioFachada(1));
        r.setTextoresposta("olá");
        r.setDatapostagem(new Date(System.currentTimeMillis()));

        //usuarioFachada.criarUsuario(u);
        //usuarioFachada.alterarUsuario(u);
        //usuarioFachada.excluirUsuario(5);
        //usuarioFachada.todosUsuarios();
        List<PerguntaFachada> listaPergunta = usuarioFachada.verPerguntas();
         for (PerguntaFachada perg : listaPergunta) {
            
         System.out.print(perg.getId()+" ");
         System.out.print(perg.getUsuario().getId()+" ");
         System.out.print(perg.getPeriodo()+" ");
         System.out.print(perg.getMateria()+" ");
         System.out.print(perg.getTextopergunta()+" ");
         System.out.print(perg.getDatapostagem()+" ");
         System.out.print(perg.getEditar()+" ");
         System.out.print(perg.getExcluir()+" \n");
         }
        
        /*List<PerguntaFachada> listaPergunta = usuarioFachada.verPerguntasProprias();
        for (PerguntaFachada perg : listaPergunta) {
            
         System.out.print(perg.getId()+" ");
         System.out.print(perg.getUsuario().getId()+" ");
         System.out.print(perg.getPeriodo()+" ");
         System.out.print(perg.getMateria()+" ");
         System.out.print(perg.getTextopergunta()+" ");
         System.out.print(perg.getDatapostagem()+" ");
         System.out.print(perg.getEditar()+" ");
         System.out.print(perg.getExcluir()+" \n");
         }*/
        
        /*PerguntaFachada perg = usuarioFachada.verPergunta(3);
         System.out.print(perg.getId() + " ");
         System.out.print(perg.getUsuario().getId() + " ");
         System.out.print(perg.getPeriodo() + " ");
         System.out.print(perg.getMateria() + " ");
         System.out.print(perg.getTextopergunta() + " ");
         System.out.print(perg.getDatapostagem() + " ");
         System.out.print(perg.getEditar() + " ");
         System.out.print(perg.getExcluir() + " \n");*/
        
        usuarioFachada.criarPergunta(p);
        //usuarioFachada.editarPergunta(p);
        //usuarioFachada.excluirPergunta(8);
        
        /*List<RespostaFachada> listaResposta = usuarioFachada.verRespostas(4);
        for (RespostaFachada resp : listaResposta) {

            System.out.print(resp.getId() + " ");
            System.out.print(resp.getUsuario().getId() + " ");
            System.out.print(resp.getPergunta().getId() + " ");
            System.out.print(resp.getTextoresposta() + " ");
            System.out.print(resp.getDatapostagem() + " ");
            System.out.print(resp.getEditar() + " ");
            System.out.print(resp.getExcluir() + " \n");
        }*/
        
        //usuarioFachada.criarResposta(r);
        //usuarioFachada.editarResposta(r);
        //usuarioFachada.excluirResposta(1);
    }
}
