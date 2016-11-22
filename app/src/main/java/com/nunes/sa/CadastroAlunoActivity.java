package com.nunes.sa;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import model.GerenciadorAluno;
import model.GerenciadorUsuario;

import static android.Manifest.permission.INTERNET;


public class CadastroAlunoActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText iEmail,iSenha, iRa, iNome, iTelefone;
    private ProgressBar progressBar;
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
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        ChecaPermissao();
    }

    public void btnSalvarAluno(View v){
        String email = iEmail.getText().toString().trim();
        String senha = iSenha.getText().toString().trim();
        String nome = iNome.getText().toString().trim();
        int ra = Integer.parseInt(iRa.getText().toString());
        String telefone = iTelefone.getText().toString().trim();
        progressBar.setVisibility(View.VISIBLE);


        //adiciona o usuário que o Aluno irá usar

        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(CadastroAlunoActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(CadastroAlunoActivity.this, "Aluno cadastrado com sucesso!" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(CadastroAlunoActivity.this, "Falha no cadastro" + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(CadastroAlunoActivity.this, MainActivity.class));
                            finish();
                        }


                    }
                });
        //salva o aluno no firebase
        GerenciadorAluno gAluno = new GerenciadorAluno();
        gAluno.SalvarAluno(nome,email,ra,telefone);
        //salva informações adicionais do usuário
        GerenciadorUsuario gUser = new GerenciadorUsuario();
        gUser.SalvarUsuario(email,3);
    }
    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

        void ChecaPermissao(){
            // Se não possui permissão
            if (ContextCompat.checkSelfPermission(this,INTERNET) != PackageManager.PERMISSION_GRANTED) {
                // Verifica se já mostramos o alerta e o usuário negou na 1ª vez.
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,INTERNET)) {
                    // Caso o usuário tenha negado a permissão anteriormente, e não tenha marcado o check "nunca mais mostre este alerta"
                    // Podemos mostrar um alerta explicando para o usuário porque a permissão é importante.
                } else {
                    // Solicita a permissão
                    ActivityCompat.requestPermissions(this,new String[]{INTERNET},0);
                }
            } else {
                // Tudo OK, podemos prosseguir.
            }
        }
}
