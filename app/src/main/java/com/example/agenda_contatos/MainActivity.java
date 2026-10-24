package com.example.agenda_contatos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {
    private EditText nome;
    private EditText telefone;
    private Button salvar;
    private AppDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.editTextNome);
        telefone = findViewById(R.id.editTextTelefone);
        salvar = findViewById(R.id.buttonSalvar);
        db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "agenda-contatos.db").build();
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeContato = nome.getText().toString();
                String telefoneContato = telefone.getText().toString();
                Contato contatoAtual = new Contato(0, nomeContato, telefoneContato);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        db.contatoDAO().inserirContato(contatoAtual);
                    }
                }).start();
            }
        });
    }
}