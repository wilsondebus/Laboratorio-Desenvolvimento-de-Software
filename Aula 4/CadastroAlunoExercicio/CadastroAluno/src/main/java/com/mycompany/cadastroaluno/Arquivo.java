/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastroaluno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author wilsi
 */
public class Arquivo {
    
    private FileWriter arqW;
    private BufferedWriter escritor; 
    
    private FileReader arqR;
    private BufferedReader leitor;
    
    private List<Aluno> listaAlunos; 
    
    public String nomeArquivo;
    
    public Arquivo(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
        listaAlunos = new ArrayList<>(); 
    }
    
    public List<Aluno> leArquivo(){
        listaAlunos.clear(); 
        
        try{
            arqR = new FileReader(nomeArquivo + ".txt");
            leitor = new BufferedReader(arqR); 
            
            String linha; 
            
            while((linha = leitor.readLine()) != null){
                String[] campos = linha.split(";");
                
                String nome = campos[0];
                String dataNascimento = campos[1];
                String sexo = campos[2];
                String matricula = campos[3];
                String curso = campos[4];
                String cpf = campos[5];
                String estado = campos[6];
                String cidade = campos[7];
                String bairro = campos[8];
                String rua = campos[9];
                float numero = Float.parseFloat(campos[10]);
                String complemento = campos[11];
                float telefone = Float.parseFloat(campos[12]); 
                
                Aluno aluno = new Aluno(nome, dataNascimento, sexo, matricula, curso, cpf, estado, cidade, bairro, rua, numero, complemento, telefone); 
                
                listaAlunos.add(aluno);
            }
            
            leitor.close();
            arqR.close(); 
            
        } catch(FileNotFoundException e){
            System.out.println("Arquivo ainda não existe.");
        } catch(IOException e){
            e.printStackTrace(); 
        }
        
        return listaAlunos; 
    }
    
    public List<Aluno> getListaAlunos(){
        return listaAlunos; 
    }
    
    public void gravaArquivo(){
        try{
            arqW = new FileWriter(nomeArquivo + ".txt", false); 
            escritor = new BufferedWriter(arqW); 
            
            for(Aluno aluno : listaAlunos){
                escritor.write(
                        aluno.nome + ";" +
                        aluno.dataNascimento + ";" +
                        aluno.sexo + ";" +
                        aluno.matricula + ";" +
                        aluno.curso + ";" +
                        aluno.cpf + ";" +
                        aluno.estado + ";" +
                        aluno.cidade + ";" +
                        aluno.bairro + ";" +
                        aluno.rua + ";" +
                        aluno.numero + ";" +
                        aluno.complemento + ";" +
                        aluno.telefone
                );
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
