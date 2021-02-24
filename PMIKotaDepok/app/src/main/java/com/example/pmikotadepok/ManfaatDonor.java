package com.example.pmikotadepok;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import com.example.pmidepok.R;

import java.util.Objects;

public class ManfaatDonor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manfaat_donor);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Manfaat Mendonorkan Darah");
    }
}
