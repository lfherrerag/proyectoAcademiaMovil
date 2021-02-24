package com.uisrael.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Autorizacion extends AppCompatActivity {

    EditText eusuario, econtrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorizacion);
        eusuario=findViewById(R.id.etuser2);
        econtrasena=findViewById(R.id.etpassword2);
    }

    //DATOS PARA LAS CALIFICACIONES

    public void calif(View v) {
        final String usuario = eusuario.getText().toString();
        final String password = econtrasena.getText().toString();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        String Materia = jsonResponse.getString("Materia");
                        String Primer_Parcial = jsonResponse.getString("Primer_Parcial");
                        String Segundo_Parcial = jsonResponse.getString("Segundo_Parcial");
                        String Nota_Final = jsonResponse.getString("Nota_Final");

                        Intent intent2 = new Intent(Autorizacion.this, Calificaciones.class);//aqui cambie Informacion por MainActivity
                        intent2.putExtra("Materia", Materia);
                        intent2.putExtra("Primer_Parcial", Primer_Parcial);
                        intent2.putExtra("Segundo_Parcial", Segundo_Parcial);
                        intent2.putExtra("Nota_Final", Nota_Final);


                        Autorizacion.this.startActivity(intent2);


                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Autorizacion.this);
                        builder.setMessage("Usuario o Contraseña incorrecto").setNegativeButton("Retry", null).create().show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        CalificacionRequest calificacionRequest = new CalificacionRequest(usuario, password, responseListener);
        RequestQueue rq = Volley.newRequestQueue(Autorizacion.this);
        rq.add(calificacionRequest);

    }


}