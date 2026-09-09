/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avaliacaogerenciamentolivros;

/**
 *
 * @author laboratorio
 */
public class Livro {
    
    public String titulo;
    public String autor;
    public String anoPublicacao; 
    public String tipo;
    public String situacaoLeitura; 

    public Livro(String titulo, String autor, String anoPublicacao, String tipo, String situacaoLeitura) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.tipo = tipo;
        this.situacaoLeitura = situacaoLeitura;
    }

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao + ", tipo=" + tipo + ", situacaoLeitura=" + situacaoLeitura + '}';
    }
    
    public Object[] obterDados(){
        return new Object[] {titulo, autor, anoPublicacao, tipo, situacaoLeitura};   
    }
    
    
    
}
