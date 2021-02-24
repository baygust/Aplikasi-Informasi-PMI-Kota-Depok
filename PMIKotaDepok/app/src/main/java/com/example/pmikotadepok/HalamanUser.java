package com.example.pmikotadepok;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.pmidepok.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HalamanUser extends AppCompatActivity {

    List<Donors> donorsList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_user);
        Objects.requireNonNull(getSupportActionBar()).hide();

        final TextView txtwelcome = (TextView) findViewById(R.id.tampilanselamat);
        final TextView txtalamat = (TextView) findViewById(R.id.tampilanalamat);
        final TextView txttgl_lahir = (TextView) findViewById(R.id.tampilantgl_lahir);
        final TextView txtgol_darah = (TextView) findViewById(R.id.tampilangol_darah);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String alamat = intent.getStringExtra("alamat");
        String tgl_lahir = intent.getStringExtra("tgl_lahir");
        String gol_darah = intent.getStringExtra("gol_darah");

        String namanya = "Selamat Datang " + nama;
        txtwelcome.setText(namanya);

        String alamatnya = "Alamat : " + alamat;
        txtalamat.setText(alamatnya);

        String tgllahirnya = "Tanggal Lahir : " + tgl_lahir;
        txttgl_lahir.setText(tgllahirnya);

        String goldarahnya = "Golongan Darah : " + gol_darah;
        txtgol_darah.setText(goldarahnya);

        recyclerView = findViewById(R.id.recycleviewww);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        donorsList = new ArrayList<>();

        loadProducts();

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Apakah anda yakin ingin keluar dari halaman ini ?");
        builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent berhasil = new Intent(HalamanUser.this, Login.class);
                startActivity(berhasil);
                finish();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    private void loadProducts() {

        final String username;
        username = getIntent().getStringExtra("username");

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject donor = array.getJSONObject(i);

                        donorsList.add(new Donors(
                                donor.getString("tgl_donor"),
                                donor.getString("tempat_donor")
                        ));
                    }
                    DonorAdapter adapter = new DonorAdapter(HalamanUser.this, donorsList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        DonorRequest donorRequest = new DonorRequest(username, responseListener);
        RequestQueue queue = Volley.newRequestQueue(HalamanUser.this);
        queue.add(donorRequest);
    }
}

