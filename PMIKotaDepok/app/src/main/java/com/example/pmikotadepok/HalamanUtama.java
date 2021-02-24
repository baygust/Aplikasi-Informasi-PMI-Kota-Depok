package com.example.pmikotadepok;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.Objects;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pmidepok.R;

public class HalamanUtama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    public void keprofil(View view) {
        Intent keprofilyuk = new Intent(this,ProfilPMI.class );
        startActivity(keprofilyuk);
    }
    public void kemanfaat(View view) {
        Intent kemanfaatyuk = new Intent(this,ManfaatDonor.class );
        startActivity(kemanfaatyuk);
    }
    public void kesyarat(View view) {
        Intent kesyaratyuk = new Intent(this,SyaratDonor.class );
        startActivity(kesyaratyuk);
    }
    public void keriwayat(View view) {
        Intent keriwayatyuk = new Intent(this,Login.class );
        startActivity(keriwayatyuk);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Apakah anda yakin ingin keluar dari aplikasi ini ?");
        builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
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
}