/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Beans.Pessoa;
import Conexao.Conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author wilsi
 */
public class PessoaDAO {
    
    private Conexao conexao;
    private Connection conn;

    public PessoaDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void inserirPessoa(Pessoa pessoa) throws SQLException{
        
        String sql = "INSERT INTO pessoa (nome, sexo, idioma) VALUES (?,?,?)";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql);){
                        
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            
            stmt.execute();
                    
        }
    }  
}
