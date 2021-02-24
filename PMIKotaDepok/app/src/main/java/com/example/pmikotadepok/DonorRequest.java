package com.example.pmikotadepok;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DonorRequest extends StringRequest {
    private static final String RECYCLER_REQUEST_URL =
            "https://pmidepok.000webhostapp.com/Recycler.php";
    protected Map<String, String> params;

    public DonorRequest(String username, Response.Listener<String> listener) {
        super(Method.POST, RECYCLER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
    }
    @Override
    public Map<String, String> getParams(){
        return params;
    }
}