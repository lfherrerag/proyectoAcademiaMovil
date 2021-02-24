package com.uisrael.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    EditText lusuario,lpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lusuario=findViewById(R.id.txtuser);
        lpassword=findViewById(R.id.txtcontraseña);
    }

    public void reg(View v){
        Intent intAbrir=new Intent(Login.this,Registrar.class);
        //intAbrir.putExtra("abrir",et1.getText().toString());
        startActivity(intAbrir);
        Toast.makeText(this,"Por favor registre sus datos",Toast.LENGTH_SHORT).show();
    }

    public void login(View v) {
    final String usuario = lusuario.getText().toString();
    final String password = lpassword.getText().toString();

    Response.Listener<String> responseListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            try {
                JSONObject jsonResponse = new JSONObject(response);
                boolean success = jsonResponse.getBoolean("success");
                if (success) {

                    String nombre = jsonResponse.getString("nombre");
                    String apellido = jsonResponse.getString("apellido");
                    String cedula = jsonResponse.getString("cedula");
                    String paralelo = jsonResponse.getString("paralelo");
                    String nivel = jsonResponse.getString("nivel");

                    Intent intent = new Intent(Login.this, MainActivity.class);//aqui cambie Informacion por MainActivity
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("apellido", apellido);
                    intent.putExtra("cedula", cedula);
                    intent.putExtra("paralelo", paralelo);
                    intent.putExtra("nivel", nivel);

                    Login.this.startActivity(intent);


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setMessage("Usuario o Contraseña incorrecto").setNegativeButton("Retry", null).create().show();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };

    LoginRequest loginRequest = new LoginRequest(usuario, password, responseListener);
    RequestQueue rq = Volley.newRequestQueue(Login.this);
    rq.add(loginRequest);

        lusuario.setText("");
        lpassword.setText("");

}




}