package model;

/**
 * Created by Nunes on 14/11/2016.
 */

public class Equipe {
    int idEquipe;
    String nome, telefone, email;

    public Equipe(){

    }
    public Equipe(String nome, String telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;

    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
