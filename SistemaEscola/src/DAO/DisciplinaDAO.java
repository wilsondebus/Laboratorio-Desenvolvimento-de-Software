package DAO;

import beans.Disciplina;
import java.sql.*;

public class DisciplinaDAO {

    private Connection conn;

    public DisciplinaDAO(Connection conn) {
        this.conn = conn;
    }

    // CADASTRAR DISCIPLINA
    public void inserirDisciplina(Disciplina d) {

        String sql = "INSERT INTO Disciplina (nome, carga_horaria, id_professor) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getCargaHoraria());
            stmt.setInt(3, d.getIdProfessor());

            stmt.executeUpdate();

            System.out.println("Disciplina cadastrada com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar disciplina: " + ex.getMessage());
        }
    }

    // CONSULTAR DISCIPLINA
    public Disciplina getDisciplina(int id) {

        String sql = "SELECT * FROM Disciplina WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Disciplina d = new Disciplina();

                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setCargaHoraria(rs.getString("carga_horaria"));
                d.setIdProfessor(rs.getInt("id_professor"));

                rs.close();
                stmt.close();

                return d;
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar disciplina: " + ex.getMessage());
        }

        return null;
    }

    // EDITAR DISCIPLINA
    public void editarDisciplina(Disciplina disciplina) {

       String sql = "UPDATE Disciplina "
               + "SET nome=?, carga_horaria=?, id_professor=? "
               + "WHERE id=?";

       try (PreparedStatement stmt = conn.prepareStatement(sql)) {

           stmt.setString(1, disciplina.getNome());
           stmt.setString(2, disciplina.getCargaHoraria());
           stmt.setInt(3, disciplina.getIdProfessor());
           stmt.setInt(4, disciplina.getId());

           stmt.executeUpdate();

           System.out.println("Disciplina atualizada com sucesso!");

       } catch (SQLException ex) {
           System.out.println("Erro ao editar disciplina: " + ex.getMessage());
       }
   }
}