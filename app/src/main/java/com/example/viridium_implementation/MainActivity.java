package com.example.viridium_implementation;

import static android.media.tv.TvContract.AUTHORITY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButton= findViewById(R.id.mButton);
        mButton.setOnClickListener(this);
    }

    public void initCapturaHuellaEscanerVeridium(boolean validarCalidad, String idEnrolamiento,String huellaDigital, int tipoPersona) {

        Intent intentVeridiumSDK = new Intent(this,ActivityMainViridium.class);

        File fileBiometricosJson = createJsonFileProvider(this, idEnrolamiento, ".json");
        intentVeridiumSDK.putExtra("BUNDLE_EXTRAS_ARG_CAPTURA_RAPIDA",false);
        intentVeridiumSDK.putExtra("BUNDLE_EXTRAS_ARG_DEDO","Dedo indice de la mano derecha");
        intentVeridiumSDK.putExtra("TIPOS_PERSONA_ARG",0);
        intentVeridiumSDK.putExtra("URI_BIOMETRICOS_JSON_FILE_ARG",fileBiometricosJson.toURI());

        startActivity(intentVeridiumSDK);
    }

    @Override
    public void onClick(View v) {
       initCapturaHuellaEscanerVeridium(true,"mIdEnrolamiento", "Dedo indice de la mano derecha", 0);
    }

    public static final String DATE_FORMAT_MEDIA_FILES = "ddMMyyyy-hhmmss";
    public static File createJsonFileProvider(Context context, String idEnrolamiento, String formato){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_MEDIA_FILES);
        String fileName = "biometricos-"+idEnrolamiento+"-"+ sdf.format(Calendar.getInstance().getTime()) + "." + formato;
        /*File file = FileUtils.newTempFile(context, fileName);
        return file;*/
        File fileDir =  null;
        File directorio = new File(context.getExternalFilesDir(null),"biometricos_json");
        Log.d("FileUtils","file "+directorio.getPath());
        if (directorio != null) {
            if(!directorio.exists()) {
                directorio.mkdirs();
            }
            try {
                fileDir = new File(directorio,fileName);
                fileDir.createNewFile();
                Log.d("FileUtils","file creada "+fileDir.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return fileDir;
        }
        return null;
    }


}