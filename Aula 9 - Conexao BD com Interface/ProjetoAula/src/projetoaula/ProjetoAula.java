/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetoaula;

import DAO.PessoaDAO;
import beans.Pessoa;
import conexao.Conexao;

/**
 *
 * @author laboratorio
 */
public class ProjetoAula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexao c = new Conexao(); 
        c.getConexao(); 
        
        Pessoa p = new Pessoa(); 
        p.setNome("Wilson Dias Debus");
        p.setIdioma("Português");
        p.setSexo("M");
        
        PessoaDAO pdao = new PessoaDAO();
        pdao.inserir(p);
    }
}
