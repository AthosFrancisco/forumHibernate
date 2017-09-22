/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

/**
 *
 * @author ATHOS
 */
public class Conexao {
    
    private static final EntityManagerFactory emf;
    
    static{
        emf = Persistence.createEntityManagerFactory("persistencia");
    }
    
    public static EntityManager getConexao() {
        return emf.createEntityManager();
    }
}
