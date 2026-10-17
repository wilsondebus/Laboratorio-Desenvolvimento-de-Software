/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import beans.Aluno;
import conexao.Conexao;
import java.sql.Connection;
import java.util.List;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.HashSet;

/**
 *
 * @author wilsi
 */
public class AlunoDAO {
    
    private Conexao conexao;
    private Connection conn;    
    
    public AlunoDAO(Conexao conexao, Connection conn) {
        this.conexao = conexao;
        this.conn = conn;
    }
    
    public void inserirAluno(Aluno aluno){
        try{
            String sql = "INSERT INTO alunos (nome, idade, curso) VALUES (?,?,?);";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade()); 
            stmt.setString(3, aluno.getCurso());
            
            stmt.execute(); 
            
        } catch (SQLException ex){
            System.out.println("Erro ao inserir aluno: "+ex.getMessage());
        }
    }
    
    public Aluno getAluno(int id){
        String sql = "SELECT * FROM alunos WHERE id = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Aluno a = new Aluno();
            
            rs.first();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setIdade(rs.getInt("idade"));
            a.setCurso(rs.getString("curso"));
            return a;   
        } catch (SQLException ex){
            System.out.println("Erro ao consultar pessoa"+ex.getMessage());
            return null;
        }
    }
    
    public void editar(Aluno aluno){
        try{
            String sql = "UPDATE alunos set nome=?, idade=?, curso=? WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,aluno.getNome());
            stmt.setInt(2,aluno.getIdade());
            stmt.setString(3,aluno.getCurso());
            stmt.setInt(4,aluno.getId());
            
            stmt.execute(); 
            
        } catch (SQLException ex){
            System.out.println("Erro ao editar aluno: "+ex.getMessage());
        }
    }
}
