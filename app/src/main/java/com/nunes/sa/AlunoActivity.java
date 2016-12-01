package com.nunes.sa;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

import model.Aluno;

public class AlunoActivity extends AppCompatActivity {
    ListView lstAlunos;
    DatabaseReference mDatabase;
    FirebaseListAdapter<Aluno> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
        lstAlunos = (ListView) findViewById(R.id.lstAlunos);

        CarregarListaAlunos();
        lstAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(AlunoActivity.this,CadastroAlunoActivity.class);
               String pos = lstAlunos.getItemAtPosition(i).toString();
                final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("alunos").child(pos);
                intent.putExtra("aluno", mDatabase.getKey());
                startActivity(intent);

            }
        });

    }

    public void btnNovoAluno(View v){
        Intent intent = new Intent(this, CadastroAlunoActivity.class);
        startActivity(intent);
    }

    void CarregarListaAlunos(){
        mDatabase = FirebaseDatabase.getInstance().getReference("alunos");

          mAdapter =
                new FirebaseListAdapter<Aluno>(this, Aluno.class, android.R.layout.two_line_list_item, mDatabase) {
            @Override
            protected void populateView(View view, Aluno aluno, int position) {
                ((TextView)view.findViewById(android.R.id.text1)).setText(Integer.toString(aluno.getRa()));
                ((TextView)view.findViewById(android.R.id.text2)).setText(aluno.getNome());
            }
        };

        lstAlunos.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
    }

}
