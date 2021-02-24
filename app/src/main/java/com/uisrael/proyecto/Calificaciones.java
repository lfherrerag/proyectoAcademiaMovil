package com.uisrael.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Calificaciones extends AppCompatActivity {
    List<ConsCalifica>calificaList;
    RecyclerView recyclerView;


    private static final String URL_lista="http://192.168.1.20:8080/proyecto/calificaciones.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificaciones);
        recyclerView=findViewById(R.id.RvCalifica);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent=getIntent();
        String paralelo=intent.getStringExtra("paralelo");


       calificaList=new ArrayList<>();
        loadLista();
    }

    public void loadLista(){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_lista, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject listas = array.getJSONObject(i);
                        calificaList.add(new ConsCalifica(
                                listas.getString("Materia"),
                                listas.getString("Primer_Parcial"),
                                listas.getString("Segundo_Parcial"),
                                listas.getString("Nota_Final")
                        ));

                    }
                   // Toast.makeText(getApplication(),calificaList.toString(),Toast.LENGTH_LONG).show();

                    AdapterCalifa adapter = new AdapterCalifa(Calificaciones.this,calificaList);
                    recyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplication(),error.toString(),Toast.LENGTH_LONG).show();

                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);

    }


    public void volver(View v){
        Intent intAbrir=new Intent(Calificaciones.this,MainActivity.class);
        //intAbrir.putExtra("abrir",et1.getText().toString());
        startActivity(intAbrir);
        Toast.makeText(this,"Seleccione una opción",Toast.LENGTH_SHORT).show();
    }


}