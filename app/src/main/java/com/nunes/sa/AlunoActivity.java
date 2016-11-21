package com.nunes.sa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
    }

    public void btnNovoAluno(View v){
        Intent intent = new Intent(this, CadastroAlunoActivity.class);
        startActivity(intent);
    }
}
