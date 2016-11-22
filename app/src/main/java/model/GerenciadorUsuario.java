package model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Nunes on 10/11/2016.
 */

public class GerenciadorUsuario {

    public void SalvarUsuario(String email,int codigoLogin){

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
        String userId = mDatabase.push().getKey();
        Usuario user = new Usuario(email,codigoLogin);
        mDatabase.child(userId).setValue(user);
    }


}
