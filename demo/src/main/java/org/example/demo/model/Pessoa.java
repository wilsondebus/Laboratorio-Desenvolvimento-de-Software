package org.example.demo.model;

public class Pessoa {
    private Integer id;
    private String nome;
    private String sexo;    // "M" ou "F"
    private String idioma;  // até 10 chars

    public Pessoa() {}

    public Pessoa(Integer id, String nome, String sexo, String idioma) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idioma = idioma;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
}
