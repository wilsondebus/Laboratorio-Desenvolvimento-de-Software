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
import java.util.HashSet;
import java.util.Set;
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
    
    public void inserir(Produto produto) {

        try {
            String sql = "INSERT INTO Produtos(nome, preco, quantidade, categoria_id) VALUES (?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getCategoriaId());

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }
    
    public void editar(Produto produto){
        try{
            String sql = "UPDATE produtos set nome=?, preco=?, quantidade=?, categoria_id=? WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql); 
            
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getCategoriaId());
            stmt.setInt(5, produto.getId());
            
            stmt.execute();
        } catch (SQLException ex){
            System.out.println("Erro ao atualizar o produto "+ex.getMessage());
        }
    }
    
    public void remover(int id){
        try{
            String sql = "delete from produtos WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id); 
            stmt.execute(); 
        } catch(SQLException ex){
            System.out.println("Erro ao excluir produto: "+ex.getMessage());
        }
    }
    
    public Produto getProduto(int id){
        String sql = "SELECT * FROM produtos WHERE id = ?";
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
            p.setCategoriaId(rs.getInt("categoria_id")); 
            
            return p;
        } catch(SQLException ex){
            System.out.println("Erro ao consultar produto: "+ex.getMessage());
            return null;
        }
    }
    
    public List<Produto> getProdutos() {

        String sql = "SELECT Produtos.*, Categorias.nome AS categoria "
                   + "FROM Produtos "
                   + "INNER JOIN Categorias "
                   + "ON Produtos.categoria_id = Categorias.id";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            List<Produto> listaProdutos = new ArrayList();

            while (rs.next()) {

                Produto p = new Produto();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setCategoriaId(rs.getInt("categoria_id"));
                p.setNomeCategoria(rs.getString("categoria"));

                listaProdutos.add(p);
            }

            return listaProdutos;

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar produtos: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Produto> buscarProdutos(String nome, int categoriaId) {

        String sql = "SELECT Produtos.*, Categorias.nome AS categoria "
                   + "FROM Produtos "
                   + "LEFT JOIN Categorias "
                   + "ON Produtos.categoria_id = Categorias.id "
                   + "WHERE Produtos.nome LIKE ? "
                   + "AND (? = 0 OR Produtos.categoria_id = ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, "%" + nome + "%");
            stmt.setInt(2, categoriaId);
            stmt.setInt(3, categoriaId);

            ResultSet rs = stmt.executeQuery();

            List<Produto> listaProdutos = new ArrayList();

            while (rs.next()) {

                Produto p = new Produto();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setCategoriaId(rs.getInt("categoria_id"));
                p.setNomeCategoria(rs.getString("categoria"));

                listaProdutos.add(p);
            }

            return listaProdutos;

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produtos: " + ex.getMessage());
            return null;
        }
    }
}
