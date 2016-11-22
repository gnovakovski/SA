package model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Nunes on 10/11/2016.
 */

public class GerenciadorAluno {

    public void SalvarAluno(String nome, String email,int ra, String telefone){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("alunos");
        Aluno aluno = new Aluno(ra,nome,email,telefone);
        String alunoId = Integer.toString(aluno.ra);
        mDatabase.child(alunoId).setValue(aluno);
    }

}
