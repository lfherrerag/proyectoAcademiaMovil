package com.uisrael.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registrar extends AppCompatActivity implements View.OnClickListener {

    EditText etnombre, etapellido, etcedula,etparalelo,etnivel,etusuario,etpassword;
    Button bguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        etnombre=findViewById(R.id.rnombre);
        etapellido=findViewById(R.id.rapellido);
        etcedula=findViewById(R.id.rcedula);
        etparalelo=findViewById(R.id.rparalelo);
        etnivel=findViewById(R.id.rnivel);
        etusuario=findViewById(R.id.rusuario);
        etpassword=findViewById(R.id.rpassword);

        bguardar=(Button)findViewById(R.id.btnguardar);
        bguardar.setOnClickListener(this);
    }

    public void volver(View v){
        Intent intAbrir=new Intent(Registrar.this,Login.class);
        //intAbrir.putExtra("abrir",et1.getText().toString());
        startActivity(intAbrir);
        Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        final String nombre=etnombre.getText().toString();
        final String apellido=etapellido.getText().toString();
        final String cedula=etcedula.getText().toString();
        final String paralelo=etparalelo.getText().toString();
        final String nivel=etnivel.getText().toString();
        final String usuario=etusuario.getText().toString();
        final String password=etpassword.getText().toString();

        Response.Listener<String> respoListener=new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse=new JSONObject(response);
                    boolean success=jsonResponse.getBoolean("success");

                    if(success){
                        Intent intent=new Intent(Registrar.this,Login.class);
                        Registrar.this.startActivity(intent);
                    }else{
                        AlertDialog.Builder builder=new AlertDialog.Builder(Registrar.this);
                        builder.setMessage("Error de Registro").setNegativeButton("Retry",null).create().show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        RegisterRequest resgisterRequest=new RegisterRequest(nombre,apellido,cedula,paralelo,nivel,usuario,password, respoListener);
        RequestQueue rq= Volley.newRequestQueue(Registrar.this);
        rq.add(resgisterRequest);

    }
}