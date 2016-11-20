package com.nunes.sa;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class CadastroAlunoActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    EditText iEmail,iSenha, iRa, iNome, iTelefone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);
        mAuth = FirebaseAuth.getInstance();
        iEmail = (EditText) findViewById(R.id.txtEmailAluno);
        iSenha = (EditText) findViewById(R.id.txtSenhaAluno);
        iRa = (EditText) findViewById(R.id.txtRa);
        iNome = (EditText) findViewById(R.id.txtNomeAluno);
        iTelefone = (EditText) findViewById(R.id.txtTelefoneAluno);
    }

    public void btnSalvar(View v){
        String email = iEmail.getText().toString();
        String senha = iSenha.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(CadastroAlunoActivity.this, "Cadastro Efetuado com sucesso!", Toast.LENGTH_LONG);
                        Intent intent = new Intent(CadastroAlunoActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(CadastroAlunoActivity.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }


}
