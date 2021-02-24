package com.uisrael.proyecto;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL="http://192.168.1.20:8080/proyecto/Register.php";
    private Map<String,String> params;

    public RegisterRequest(String nombre, String apellido, String cedula, String paralelo, String nivel, String usuario, String password,
                           Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL,listener, null);
        params=new HashMap<>();
        params.put("nombre",nombre);
        params.put("apellido",apellido);
        params.put("cedula",cedula);
        params.put("paralelo",paralelo);
        params.put("nivel",nivel);
        params.put("usuario",usuario);
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
