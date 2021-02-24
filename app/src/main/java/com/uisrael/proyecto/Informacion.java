package com.uisrael.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Informacion extends AppCompatActivity {

    TextView enombres,eapellidos,ecedula,enivel,eparalelo;
    EditText lusuario, lpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        enombres=findViewById(R.id.txtnombres);
        eapellidos=findViewById(R.id.txtapellido);
        ecedula=findViewById(R.id.txtcedula);
        enivel=findViewById(R.id.txtNivel);
        eparalelo=findViewById(R.id.txtparalelo);
        lusuario = findViewById(R.id.txtuser);
        lpassword = findViewById(R.id.txtcontraseña);

        Intent intent=getIntent();
        String nombre=intent.getStringExtra("nombre");
        String apellido=intent.getStringExtra("apellido");
        String cedula=intent.getStringExtra("cedula");
        String paralelo=intent.getStringExtra("paralelo");
        String nivel=intent.getStringExtra("nivel");

        enombres.setText(nombre);
        eapellidos.setText(apellido);
        ecedula.setText(cedula);
        enivel.setText(nivel);
        eparalelo.setText(paralelo);

    }

    public void volver(View v){
        Intent intAbrir=new Intent(Informacion.this,MainActivity.class);
        //intAbrir.putExtra("abrir",et1.getText().toString());
        startActivity(intAbrir);
        Toast.makeText(this,"Seleccione una opción",Toast.LENGTH_SHORT).show();
    }






}