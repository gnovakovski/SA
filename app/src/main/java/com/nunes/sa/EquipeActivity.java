package com.nunes.sa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EquipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe);
    }

    public void BtnNovaEquipe(View v){
        Intent intent = new Intent(EquipeActivity.this,CadastroEquipeActivity.class);
        startActivity(intent);
    }

}
