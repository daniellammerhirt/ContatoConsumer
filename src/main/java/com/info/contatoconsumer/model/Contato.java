package com.info.contatoconsumer.model;

public class Contato {
    private Integer id;
    private String nome;
    private String telefone;
    private String email;

    public Contato(){}

    public Contato(Integer id, String name, String phone, String email){
        this.id = id;
        this.setNome(getNome());
        this.setTelefone(getTelefone());
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
