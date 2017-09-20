/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import model.Conexao;
import javax.persistence.EntityManager;

/**
 *
 * @author Aluno
 */
public class Teste {

    public static void main(String[] args) {

        EntityManager ex = Conexao.getConexao();
    }
}
