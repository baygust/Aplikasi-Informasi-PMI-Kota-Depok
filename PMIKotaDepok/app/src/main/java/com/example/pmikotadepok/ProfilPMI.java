package com.example.pmikotadepok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pmidepok.R;

import java.util.Objects;

public class ProfilPMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Profil PMI PMI Kota Depok");
    }
    public void kelokasinya(View view) {
        Intent kelokasinyayuk = new Intent(this,MapsActivity.class );
        startActivity(kelokasinyayuk);
    }
}
