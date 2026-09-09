/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avaliacaogerenciamentolivros;

/**
 *
 * @author laboratorio
 */

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
    
    private FileWriter arqW;
    private BufferedWriter escritor;

    private FileReader arqR;
    private BufferedReader leitor;
    
    private List<Livro> listaLivros;
    
    public String nomeArquivo; 
    
    public Arquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
        listaLivros = new ArrayList<>();
    }
    
    public List<Livro> leArquivo(){
        listaLivros.clear(); 
        
        try{
            arqR = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqR);
            
            String linha;
            
            while((linha = leitor.readLine()) != null){
                String[] campos = linha.split(";");
                
                String titulo = campos[0]; 
                String autor = campos[1]; 
                String anoPublicacao = campos[2];
                String tipo = campos[3];
                String situacaoLeitura = campos[4]; 
                
                Livro livro = new Livro(titulo, autor, anoPublicacao, tipo, situacaoLeitura); 
                
                listaLivros.add(livro); 
            }
            
            leitor.close();
            arqR.close(); 
        } catch (FileNotFoundException e){
            System.out.println("Arquivo ainda não existe");
        } catch (IOException e){
            e.printStackTrace();
        }
        
        return listaLivros; 
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }
    
    public void gravaArquivo(){
        
        try{
            arqW = new FileWriter(nomeArquivo + ".txt", false);
            escritor = new BufferedWriter(arqW);
            
            for(Livro l : listaLivros){
                escritor.write(l.titulo + ";" + l.autor + ";" + l.anoPublicacao + ";" + l.tipo + ";" + l.situacaoLeitura);
                
                escritor.newLine();
            }
            escritor.close();
            arqW.close(); 
            
            System.out.println("Lista Salva no arquivo");
        } catch(IOException e){
            e.printStackTrace();
        }
    }  
}
