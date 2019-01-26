package com.example.jucivan.omrkeep.Model;

import android.widget.EditText;
import com.google.firebase.database.Exclude;

public class Usuario {
    private String nome, matricula, telefone, empresa, funcao,email, senha, caminhodafotoPerfil;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {

        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }

    public String getCaminhodafotoPerfil() {
        return caminhodafotoPerfil;
    }

    public void setCaminhodafotoPerfil(String caminhodafotoPerfil) {
        this.caminhodafotoPerfil = caminhodafotoPerfil;
    }
}
