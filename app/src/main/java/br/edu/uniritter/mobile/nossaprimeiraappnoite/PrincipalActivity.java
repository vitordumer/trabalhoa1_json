package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Button todos = (Button) findViewById(R.id.button3);
        Button albums = (Button) findViewById(R.id.button5);
        Button comments = (Button) findViewById(R.id.button);
        Button posts = (Button) findViewById(R.id.button2);


        //btn.setOnClickListener(this::abreSegundaActivity);

        todos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Intent intent = new Intent(v.getContext(),SegundaActivity.class);
                //startActivity(intent);
                    abreSegundaActivity(v);

            }

        });

        albums.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Intent intent = new Intent(v.getContext(),SegundaActivity.class);
                //startActivity(intent);
                abreAlbumsActivity(v);

            }

        });

        comments.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Intent intent = new Intent(v.getContext(),SegundaActivity.class);
                //startActivity(intent);
                abreCommentsActivity(v);

            }

        });

        posts.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Intent intent = new Intent(v.getContext(),SegundaActivity.class);
                //startActivity(intent);
                abrePostsActivity(v);

            }

        });
    }

    private void abreAlbumsActivity(View view) {
        Intent intent = new Intent(this,AlbumsActivity.class);

        // adicional para incluir dados para a proxima activity
        intent.putExtra("valorTexto", "Nossa 4ª aula");
        Pessoa jean  = new Pessoa("Jean Paul", 666);
        intent.putExtra("objPessoa", jean);

        EditText editNome = (EditText)findViewById(R.id.editTextTextPersonName);
        intent.putExtra("nome",editNome.getText().toString());

        // lança intent para o SO chamar a activity

        startActivity(intent);
    }

    public void abreSegundaActivity(View view) {
        Intent intent = new Intent(this,SegundaActivity.class);

        // adicional para incluir dados para a proxima activity
        intent.putExtra("valorTexto", "Nossa 4ª aula");
        Pessoa jean  = new Pessoa("Jean Paul", 666);
        intent.putExtra("objPessoa", jean);

        EditText editNome = (EditText)findViewById(R.id.editTextTextPersonName);
        intent.putExtra("nome",editNome.getText().toString());

        // lança intent para o SO chamar a activity
        startActivity(intent);

    }

    private void abreCommentsActivity(View view) {
        Intent intent = new Intent(this,ActivityComments.class);

        // adicional para incluir dados para a proxima activity
        intent.putExtra("valorTexto", "Nossa 4ª aula");
        Pessoa jean  = new Pessoa("Jean Paul", 666);
        intent.putExtra("objPessoa", jean);

        EditText editNome = (EditText)findViewById(R.id.editTextTextPersonName);
        intent.putExtra("nome",editNome.getText().toString());

        // lança intent para o SO chamar a activity

        startActivity(intent);
    }

    private void abrePostsActivity(View view) {
        Intent intent = new Intent(this, PostActivity.class);

        // adicional para incluir dados para a proxima activity
        intent.putExtra("valorTexto", "Nossa 4ª aula");
        Pessoa jean = new Pessoa("Jean Paul", 666);
        intent.putExtra("objPessoa", jean);

        EditText editNome = (EditText) findViewById(R.id.editTextTextPersonName);
        intent.putExtra("nome", editNome.getText().toString());

        // lança intent para o SO chamar a activity

        startActivity(intent);
    }
}