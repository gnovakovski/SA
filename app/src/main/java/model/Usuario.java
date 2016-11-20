package model;

/**
 * Created by Nunes on 10/11/2016.
 */

public class Usuario {
    String email, senha;
    int codigoLogin;
    //codigoLogin = 1: Admin
    //codigoLogin = 2: Equipe
    //codigoLogin = 3: Aluno

    public Usuario(){

    }

    public Usuario(String senha, String email, int codigoLogin) {
        this.senha = senha;
        this.email = email;
        this.codigoLogin = codigoLogin;
    }


}
