/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Beans.Produto;
import Conexao.Conexao;
import java.sql.Connection;
import java.util.List;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.SpringLayout;

/**
 *
 * @author wilsi
 */
public class ProdutoDAO {
    private Conexao conexao;
    private Connection conn; 

    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Produto produto){
        
        try{
            String sql = "INSERT INTO produto(nome, preco, quantidade) VALUES (?,?,?);";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());

            stmt.execute();
    }  catch (SQLException ex){
            System.out.println("Erro ao inserir produto: "+ex.getMessage());
    }  
}
    
    public void editar(Produto produto){
        try{
            String sql = "UPDATE produto set nome=?, preco=?, quantidade=? WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql); 
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getId());
            
            stmt.execute();
        } catch (SQLException ex){
            System.out.println("Erro ao atualizar o produto "+ex.getMessage());
        }
    }
    
    public void remover(int id){
        try{
            String sql = "delete from pessoa WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id); 
            stmt.execute(); 
        } catch(SQLException ex){
            System.out.println("Erro ao excluir produto: "+ex.getMessage());
        }
    }
    
    public Produto getProduto(int id){
        String sql = "SELECT * FROM produto WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Produto p = new Produto();
            rs.first();
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getDouble("preco"));
            p.setQuantidade(rs.getInt("quantidade"));
            return p;
        } catch(SQLException ex){
            System.out.println("Erro ao consultar produto: "+ex.getMessage());
            return null;
        }
    }
    
    public List<Produto> getProdutos(){
        String sql = "SELECT * FROM produto";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<Produto> listaProdutos = new ArrayList();
            while (rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                listaProdutos.add(p);
            }
            return listaProdutos;
        } catch (SQLException ex){
            System.out.println("Erro ao consultar todos os produtos: "+ex.getMessage());
            return null;
        }
    }
        
  
}
