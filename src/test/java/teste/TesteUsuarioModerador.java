/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import fachada.CriarUsuario;
import fachada.UsuarioFachada;
import model.Resposta;

/**
 *
 * @author athos.carmo
 */
public class TesteUsuarioModerador {
    
    
    
    public static void main(String[] args) {
        
        UsuarioFachada u = CriarUsuario.criar("ana@gmail.com", "123");
        
        
        
        for(Resposta r: u.verRespostas(5)){
            
            System.out.println(r.getId());
            System.out.println(r.getDataPostagem());
            System.out.println(r.getTextoResposta());
            System.out.println(r.getEditar());
            System.out.println(r.getExcluir());
        }
    }
          
            
}
