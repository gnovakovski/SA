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

import model.GerenciadorAluno;


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

    public void btnSalvarAluno(View v){
        String email = iEmail.getText().toString();
        String senha = iSenha.getText().toString();
        String nome = iNome.getText().toString();
        int ra = Integer.parseInt(iRa.getText().toString());
        String telefone = iTelefone.getText().toString();
        //salva o aluno no firebase
        GerenciadorAluno gAluno = new GerenciadorAluno();
        gAluno.SalvarAluno("1",nome,email,senha,ra,telefone);
        //adiciona o usuário que o Aluno irá usar
       mAuth.addAuthStateListener(mAuthListener);
        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(CadastroAlunoActivity.this, "Cadastro Falhou",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else if(task.isSuccessful()){
                            Toast.makeText(CadastroAlunoActivity.this, "Cadastro efetuado com sucesso",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(CadastroAlunoActivity.this, AlunoActivity.class);
                            startActivity(intent);
                            finish();
                        }


                    }
                });
    }


}
