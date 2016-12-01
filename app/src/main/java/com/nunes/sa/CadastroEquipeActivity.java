package com.nunes.sa;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import model.Aluno;
import model.GerenciadorEquipe;

public class CadastroEquipeActivity extends AppCompatActivity {
    EditText iNome,iEmail,iSenha,iTelefone;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_equipe);
        mAuth = FirebaseAuth.getInstance();
        iNome = (EditText) findViewById(R.id.txtNomeEquipe);
        iEmail = (EditText) findViewById(R.id.txtEmailEquipe);
        iSenha = (EditText) findViewById(R.id.txtSenhaEquipe);
        iTelefone = (EditText) findViewById(R.id.txtTelefoneEquipe);
        progressBar = (ProgressBar) findViewById(R.id.progressBarAluno);
    }

    public void btnSalvarEquipe(View v){
        String nome = iNome.getText().toString().trim();
        String email = iEmail.getText().toString().trim();
        String senha = iSenha.getText().toString().trim();
        String telefone = iTelefone.getText().toString().trim();
        progressBar.setVisibility(View.VISIBLE);
//adiciona o usuário que a Equipe irá usar

        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(CadastroEquipeActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(CadastroEquipeActivity.this, "Equipe cadastrada com sucesso!" , Toast.LENGTH_SHORT).show();

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(CadastroEquipeActivity.this, "Falha no cadastro" + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        } else {
                            startActivity(new Intent(CadastroEquipeActivity.this, MainActivity.class));
                            finish();
                        }


                    }
                });
        GerenciadorEquipe gEquipe = new GerenciadorEquipe();
        gEquipe.SalvarEquipe(nome,telefone,email);

    }
    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
