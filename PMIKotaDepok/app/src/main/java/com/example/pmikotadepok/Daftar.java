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

public class Daftar extends AppCompatActivity {

    Button btnDaftar;
    EditText txtUsername,txtPassword,txtNLengkap,txtAlamat,txtTglLahir,txtGolDarah ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Pendaftaran");

        txtUsername = (EditText) findViewById(R.id.unamedaftar);
        txtPassword = (EditText) findViewById(R.id.passworddaftar);
        txtNLengkap = (EditText) findViewById(R.id.namalengkap);
        txtAlamat = (EditText) findViewById(R.id.alamatdaftar);
        txtTglLahir = (EditText) findViewById(R.id.tgllhrdaftar);
        txtGolDarah = (EditText) findViewById(R.id.goldarah);
        btnDaftar = (Button) findViewById(R.id.daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username, password,nama,tgl_lahir,alamat,gol_darah;

                username = txtUsername.getText().toString().trim();
                password = txtPassword.getText().toString().trim();
                nama = txtNLengkap.getText().toString().trim();
                alamat = txtAlamat.getText().toString().trim();
                tgl_lahir = txtTglLahir.getText().toString().trim();
                gol_darah = txtGolDarah.getText().toString().trim();

                if (username.equals("") ||password.equals("") || nama.equals("") ||
                        alamat.equals("") || tgl_lahir.equals("") || gol_darah.equals("")){
                    Toast.makeText(getApplicationContext(), "Data anda tidak lengkap",
                            Toast.LENGTH_LONG).show();
                }else {
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    Intent intent = new Intent(Daftar.this, Login.class);
                                    Daftar.this.startActivity(intent);
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(Daftar.this);
                                    builder.setMessage("Username sudah terpakai")
                                            .setNegativeButton("Coba lagi", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    RegisterRequest registerRequest = new RegisterRequest(username, password, nama,
                            alamat,tgl_lahir , gol_darah, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(Daftar.this);
                    queue.add(registerRequest);
                }
            }});
    }
}
