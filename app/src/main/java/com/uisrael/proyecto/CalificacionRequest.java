package com.uisrael.proyecto;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CalificacionRequest extends StringRequest {
    private static final String CALIF_REQUEST_URL="http://192.168.1.20:8080/proyecto/calificaciones.php";
    private Map<String,String> params;

    public CalificacionRequest(String usuario, String password,
                        Response.Listener<String> listener) {
        super(Request.Method.POST, CALIF_REQUEST_URL,listener, null);
        params=new HashMap<>();
        params.put("usuario",usuario);
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
