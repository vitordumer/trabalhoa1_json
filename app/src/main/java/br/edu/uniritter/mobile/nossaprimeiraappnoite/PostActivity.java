package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.DiskWriteViolation;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Post;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Post;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;

public class PostActivity extends AppCompatActivity
        implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    List<Post> posts =  new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        TextView tv = (TextView) findViewById(R.id.textoPosts);
        Intent it = getIntent();
        String txt = it.getStringExtra("nome");
        Pessoa pes = it.getParcelableExtra("objPessoa");
        //tv.setText(pes.getNome()+" ("+pes.getId()+")");
        tv.setText(txt);
        //Toast.makeText(this,"olá "+txt,Toast.LENGTH_LONG).show();
// Volley
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String urlPost = "https://jsonplaceholder.typicode.com/posts";

        // Request de JsonArray da URL.

        JsonArrayRequest jsonArrayRequestPosts = new JsonArrayRequest(Request.Method.GET, urlPost, null,
                this, this);



        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequestPosts);
        Toast.makeText(this,"qtd:"+posts.size(),Toast.LENGTH_LONG).show();


    }
    // Volley
    @Override
    public void onResponse(JSONArray response) {
        try {

            for(int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Post obj = new Post(json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getString("body"));
                posts.add(obj);

            }
            Toast.makeText(this,"qtd:"+posts.size(),Toast.LENGTH_LONG).show();
            LinearLayout ll = findViewById(R.id.layoutVerticalItens);
            for(Post obj1 : posts) {
                Button bt = new Button(this);
                bt.setText(obj1.getTitle());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn = (Button) v;
                        Post post = (Post) btn.getTag();
                        Intent intent = new Intent(getApplicationContext(), DetalhePostActivity.class);

                        // adicional para incluir dados para a proxima activity
                        intent.putExtra("objPost", post);
                        // lança intent para o SO chamar a activity
                        startActivity(intent);
                        //Toast.makeText(v.getContext(),todo.getId()+" - "+todo.getTitle(),Toast.LENGTH_LONG).show();
                    }
                });
                ll.addView(bt);
            }


        } catch (JSONException e) {
            Log.e("erro",e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(),"deu erro: "+msg,Toast.LENGTH_LONG).show();
    }



}