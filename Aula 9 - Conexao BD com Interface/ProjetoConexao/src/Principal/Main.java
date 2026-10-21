/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Beans.Pessoa;
import DAO.PessoaDAO;
import conexao.Conexao;

/**
 *
 * @author laboratorio
 */
public class Main {
    public static void main(String[] args) {
        Conexao c = new Conexao();
        c.getConexao();
        Pessoa p = new Pessoa();
        p.setNome("Henrique Flores");
        p.setIdioma("Português");
        p.setSexo("M");
        PessoaDAO pdao = new PessoaDAO();
        pdao.inserir(p);
        
    }
    
}
