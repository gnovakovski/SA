package model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Nunes on 10/11/2016.
 */

public class GerenciadorUsuario {

    public void SalvarUsuario(String email, String senha, int codigoLogin){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refEmail = database.getReference("email");
        refEmail.setValue(email);
        DatabaseReference refSenha = database.getReference("senha");
        refSenha.setValue(senha);
        DatabaseReference refCodigo = database.getReference("codigoLogin");
        refCodigo.setValue(codigoLogin);
    }

}
