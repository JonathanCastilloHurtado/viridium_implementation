package com.example.viridium_implementation;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

public class ActivityMainViridium extends AppCompatActivity {
    private int tipoPersona;
    private Uri uriJsonFile;
    private boolean capturaRapida;
    private String dedoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viridium);
        capturaRapida = getIntent().getBooleanExtra("BUNDLE_EXTRAS_ARG_CAPTURA_RAPIDA", false);
        dedoSeleccionado = getIntent().getStringExtra("BUNDLE_EXTRAS_ARG_DEDO");
        tipoPersona = getIntent().getIntExtra("TIPOS_PERSONA_ARG",0);
        uriJsonFile = getIntent().getParcelableExtra("URI_BIOMETRICOS_JSON_FILE_ARG");
    }
}