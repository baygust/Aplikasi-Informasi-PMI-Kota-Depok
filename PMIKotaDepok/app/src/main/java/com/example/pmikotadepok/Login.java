package com.example.pmikotadepok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.pmidepok.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Login extends AppCompatActivity {

    Button btnLogin;
    EditText txtUsername, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Login");

        txtUsername = (EditText) findViewById(R.id.unamelog);
        txtPassword = (EditText) findViewById(R.id.passwordlog);
        btnLogin = (Button) findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username, password;

                username = txtUsername.getText().toString().trim();
                password = txtPassword.getText().toString().trim();

                if (username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Data anda tidak lengkap",
                            Toast.LENGTH_LONG).show();
                } else {
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if (success) {
                                    String nama = jsonResponse.getString("nama");
                                    String alamat = jsonResponse.getString("alamat");
                                    String tgl_lahir = jsonResponse.getString("tgl_lahir");
                                    String gol_darah = jsonResponse.getString("gol_darah");

                                    Intent intent = new Intent(Login.this, HalamanUser.class);
                                    intent.putExtra("nama", nama);
                                    intent.putExtra("alamat", alamat);
                                    intent.putExtra("tgl_lahir", tgl_lahir);
                                    intent.putExtra("gol_darah", gol_darah);
                                    intent.putExtra("username", username);
                                    Login.this.startActivity(intent);
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                    builder.setMessage("Username atau Password salah")
                                            .setNegativeButton("Coba lagi", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    com.example.pmikotadepok.LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(Login.this);
                    queue.add(loginRequest);
                }
            }});
    }
    public void kedaftar(View view) {
        Intent kedaftaryuk = new Intent(this, Daftar.class);
        startActivity(kedaftaryuk);
    }
}

