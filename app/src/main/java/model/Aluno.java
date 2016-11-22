package model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nunes on 10/11/2016.
 */
@IgnoreExtraProperties
public class Aluno {

    String nome,email,telefone,senha;
    int ra;

    public Aluno(){

    }

    public Aluno(int ra, String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.ra = ra;
    }
    public Aluno(int ra, String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.ra = ra;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("ra", ra);
        result.put("nome", nome);
        result.put("email", email);
        result.put("senha", senha);
        result.put("telefone", telefone);

        return result;
    }

}
