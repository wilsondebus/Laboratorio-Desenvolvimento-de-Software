/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Beans.Funcionarios;
import conexao.Conexao;
import java.sql.Connection;
import java.util.List;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.SpringLayout;

/**
 *
 * @author laboratorio
 */
public class FuncionariosDAO {
   private Conexao conexao;
   private Connection conn; 
   
   public FuncionariosDAO(){
       this.conexao = new Conexao();
       this.conn = this.conexao.getConexao(); 
   }
   
   public void inserir(Funcionarios funcionario){
       
       try{
           String sql = "INSERT INTO funcionarios (nome, idade, genero, cargo, salario) VALUES (?,?,?,?,?)";
           
           PreparedStatement stmt = conn.prepareStatement(sql);
           
           stmt.setString(1, funcionario.getNome()); 
           stmt.setInt(2, funcionario.getIdade());
           stmt.setString(3, funcionario.getGenero());
           stmt.setString(4, funcionario.getCargo());
           stmt.setDouble(5, funcionario.getSalario());
           //stmt.setInt(5, funcionario.getId());
           
           stmt.execute(); 
           
       } catch(SQLException ex){
           System.out.println("Erro ao inserir funcionario: "+ex.getMessage());
       }      
   }
   
   public List<Funcionarios> getFuncionarios(){
       
       String sql = "SELECT * FROM funcionarios";
       
       try{
           PreparedStatement stmt = conn.prepareStatement(sql);
           
           ResultSet rs = stmt.executeQuery();
           
           List<Funcionarios> listaFuncionarios = new ArrayList();
           
           while(rs.next()){
               Funcionarios f = new Funcionarios();
               
               f.setId(rs.getInt("id"));
               f.setNome(rs.getString("nome"));
               f.setIdade(rs.getInt("idade"));
               f.setGenero(rs.getString("genero"));
               f.setCargo(rs.getString("cargo"));
               f.setSalario(rs.getDouble("salario"));

               listaFuncionarios.add(f);
           }
           
           return listaFuncionarios; 
           
       } catch(SQLException ex){
           System.out.println("Erro ao consultar funcionarios: "+ex.getMessage());
           return null;
       }
   }
   
}
