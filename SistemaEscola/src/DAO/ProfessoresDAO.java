/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author wilsi
 */

import beans.Professores;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessoresDAO {
    
    private Connection conn;

    public ProfessoresDAO(Connection conn) {
        this.conn = conn;
    }
    
    public List<Professores> listarProfessoresDAO()throws SQLException{
        
        List<Professores> professores = new ArrayList<>();
        
        String sql = "SELECT * FROM professores ORDER BY nome";
        
        try(PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            while (rs.next()){
                Professores p = new Professores();
                
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setDisciplina(rs.getString("disciplina"));
                
                professores.add(p); 
                
            }
        }
        
        return professores; 
    }
    
}
