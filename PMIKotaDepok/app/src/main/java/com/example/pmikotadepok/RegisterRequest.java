package com.example.pmikotadepok;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL =
            "https://pmidepok.000webhostapp.com/Register.php";
    protected Map<String, String> params;

    public RegisterRequest(String username, String password, String nama, String alamat,
                           String tgl_lahir, String gol_darah, Response.Listener<String> listener)
    {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("nama", nama);
        params.put("alamat", alamat);
        params.put("tgl_lahir", tgl_lahir);
        params.put("gol_darah", gol_darah);
    }
    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
