/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Beans.Categorias;
import Beans.Produto;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author wilsi
 */
public class CategoriasDAO {
    private Conexao conexao;
    private Connection conn;
    
    public CategoriasDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Categorias categoria){
        String sql = "INSERT INTO VEICULO (nome) VALUES (?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql); 
            
            stmt.setString(1, categoria.getNome());
            
            stmt.execute(); 
        } catch (SQLException ex){
            System.out.println("Erro ao inserir Disciplina: "+ex.getMessage());
        }
    }
    
    public void editar(Categorias categoria){
        try{
            String sql = "UPDATE veiculo set nome=? WHERE id+?;";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            stmt.execute(); 
            
        } catch(SQLException ex){
            System.out.println("Erro ao atualizar categoria: "+ex.getMessage());
        }
    }
    
    public void excluir(int id){
        try{
            String sql = "delete from veiculo WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute(); 
            
        } catch(SQLException ex){
            System.out.println("Erro ao excluir categoria: "+ex.getMessage());
        }
    }
    
    public List<Categorias> getCategorias(){
        String sql = "SELECT * FROM VEICULO";  
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery();
            List<Categorias> listaCategorias = new ArrayList();
            
            while(rs.next()){
                Categorias c = new Categorias(); 
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("mnome"));
                
                ProdutoDAO pDAO = new ProdutoDAO(); 
                
                Produto p = pDAO.getProduto(rs.getInt("id_pessoa")); 
                p.setProdutoid(p);
                listaCategorias.add(c);
            }
            return listaCategorias;
        } catch(SQLException ex){
            System.out.println("Erro ao consultar todas os produtos: "+ex.getMessage());
            return null;
        }
    }
    
}
