/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wilsi
 */
public class Conexao {
    public Connection getConexao(){
        Connection conn;
        
        try{
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/RevisaoProva",
                    "root",
                    "itaqui@100");
            System.out.println("Conexão Efetuada!");
            return conn;               
        } catch (Exception e){
            System.out.println("Erro ao conectar o banco"+e.getMessage());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
