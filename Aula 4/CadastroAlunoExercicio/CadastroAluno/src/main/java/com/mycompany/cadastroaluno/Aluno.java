/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastroaluno;

/**
 *
 * @author wilsi
 */
public class Aluno {
    
    public String nome;
    public String dataNascimento;
    public String sexo;
    public int matricula;
    public String curso;
    public String cpf;
    public String estado;
    public String cidade;
    public int cep;
    public String bairro;
    public String rua;
    public int numero;
    public String complemento;
    public int telefone; 

    public Aluno(String nome, String dataNascimento, String sexo, int matricula, String Curso, String cpf, String estado, String cidade, int cep, String bairro, String rua, int numero, String complemento, int telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.matricula = matricula;
        this.Curso = Curso;
        this.cpf = cpf;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", matricula=" + matricula + ", Curso=" + Curso + ", cpf=" + cpf + ", estado=" + estado + ", cidade=" + cidade + ", cep=" + cep + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", telefone=" + telefone + '}';
    }
    
    
}
