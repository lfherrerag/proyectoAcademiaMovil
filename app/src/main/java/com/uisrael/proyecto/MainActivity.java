package com.uisrael.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView enombres,eapellidos,ecedula,enivel,eparalelo,emateria,eprimerp,esegundop,enfinal;
    EditText lusuario, lpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enombres=findViewById(R.id.txtnombres);
        eapellidos=findViewById(R.id.txtapellido);
        ecedula=findViewById(R.id.txtcedula);
        enivel=findViewById(R.id.txtNivel);
        eparalelo=findViewById(R.id.txtparalelo);
        lusuario = findViewById(R.id.txtuser);
        lpassword = findViewById(R.id.txtcontraseña);


    }

    public void login1(View v) {

        Intent intent=getIntent();
        String nombre=intent.getStringExtra("nombre");
        String apellido=intent.getStringExtra("apellido");
        String cedula=intent.getStringExtra("cedula");
        String paralelo=intent.getStringExtra("paralelo");
        String nivel=intent.getStringExtra("nivel");

        Intent intent1 = new Intent(MainActivity.this, Informacion.class);//aqui cambie Informacion por MainActivity
        intent1.putExtra("nombre", nombre);
        intent1.putExtra("apellido", apellido);
        intent1.putExtra("cedula", cedula);
        intent1.putExtra("paralelo", paralelo);
        intent1.putExtra("nivel", nivel);

        MainActivity.this.startActivity(intent1);
    }

    public void calif1(View v){
        Intent intAbrir = new Intent(MainActivity.this, Autorizacion.class);
        startActivity(intAbrir);
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();

    }




    public void Lista(View V){
        Intent intAbrir = new Intent(MainActivity.this, Listado.class);
        startActivity(intAbrir);
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
    }

    public void Tareas(View v){
        Intent intAbrir = new Intent(MainActivity.this, Tareas.class);
        startActivity(intAbrir);
        Toast.makeText(this, "Tareas Asignadas", Toast.LENGTH_SHORT).show();

    }

    public void Materias(View v){
        Intent intAbrir = new Intent(MainActivity.this, Materias.class);
        startActivity(intAbrir);
        Toast.makeText(this, "Materias Asignadas", Toast.LENGTH_SHORT).show();

    }

    public void Calificaciones(View v){
        Intent intAbrir = new Intent(MainActivity.this, Calificaciones.class);
        startActivity(intAbrir);
        Toast.makeText(this, "Calificaciones Obtenidas", Toast.LENGTH_SHORT).show();

    }

    public void Foto(View v){
        Intent intAbrir = new Intent(MainActivity.this, Foto.class);
        startActivity(intAbrir);
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
    }


}