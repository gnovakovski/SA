package model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Nunes on 24/11/2016.
 */

public class GerenciadorEquipe {

    public void SalvarEquipe(String nome, String telefone, String email){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("equipes");
        Equipe equipe = new Equipe(nome,telefone,email);
        String equipeId = mDatabase.push().getKey();
        mDatabase.child(equipeId).setValue(equipe);
    }


}
