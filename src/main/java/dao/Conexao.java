/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.*;

/**
 *
 * @author ATHOS
 */
public class Conexao {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    static{
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }
    
    public static EntityManager getConexao() {
        return em;
    }

}
