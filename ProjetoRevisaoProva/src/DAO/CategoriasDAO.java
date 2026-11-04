package DAO;

import Beans.Categorias;
import Conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDAO {

    private Conexao conexao;
    private Connection conn;

    public CategoriasDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    // CADASTRAR CATEGORIA
    public void inserir(Categorias categoria) {
        String sql = "INSERT INTO Categorias (nome) VALUES (?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, categoria.getNome());

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir categoria: " + ex.getMessage());
        }
    }

    // EDITAR CATEGORIA
    public void editar(Categorias categoria) {
        String sql = "UPDATE Categorias SET nome=? WHERE id=?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar categoria: " + ex.getMessage());
        }
    }

    // EXCLUIR CATEGORIA
    public void excluir(int id) {
        String sql = "DELETE FROM Categorias WHERE id=?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir categoria: " + ex.getMessage());
        }
    }

    // LISTAR CATEGORIAS
    public List<Categorias> getCategorias() {

        String sql = "SELECT * FROM Categorias";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            List<Categorias> listaCategorias = new ArrayList();

            while (rs.next()) {
                Categorias c = new Categorias();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));

                listaCategorias.add(c);
            }

            return listaCategorias;

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar categorias: " + ex.getMessage());
            return null;
        }
    }
    
    public Categorias getCategoria(int id) {

        String sql = "SELECT * FROM Categorias WHERE id=?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Categorias c = new Categorias();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));

                return c;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar categoria: " + ex.getMessage());
        }

        return null;
    }
}