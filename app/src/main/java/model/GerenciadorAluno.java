package model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Nunes on 10/11/2016.
 */

public class GerenciadorAluno {

    public void SalvarAluno(String alunoId, String nome, String email, String senha, int ra, String telefone){
        Aluno aluno = new Aluno(ra,nome,email,senha,telefone);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refNome = database.getReference();
        refNome.child("alunos").setValue(aluno);
    }

}
