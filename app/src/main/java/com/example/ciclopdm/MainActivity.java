package com.example.ciclopdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.InputType;
import android.util.Log;
import android.widget.TextView;

import com.example.ciclopdm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private final String CICLO_PDM_TAG = "CICLO_PDM_TAG";
    private ActivityMainBinding activityMainBinding;

    private final String TELEFONE ="TELEFONE";
    private TextView telefoneTv;
    private TextView telefoneEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        telefoneTv = new TextView(this);
        telefoneTv.setText("Telefone");
        telefoneEt = new TextView(this);
        telefoneEt.setInputType(InputType.TYPE_CLASS_PHONE);

        activityMainBinding.linearLayout.addView(telefoneEt);
        activityMainBinding.linearLayout.addView(telefoneTv);

        Log.v(CICLO_PDM_TAG,"onCreate:Iniciando ciclo completo");
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(TELEFONE,telefoneEt.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        telefoneEt.setText(savedInstanceState.getString(TELEFONE,""));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(CICLO_PDM_TAG,"onStart:Iniciando ciclo visivel");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(CICLO_PDM_TAG,"onResume:Iniciando ciclo em primeiro plano (interação com o usuário)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(CICLO_PDM_TAG,"OnPausee:Finalizando ciclo em primeiro plano");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(CICLO_PDM_TAG,"OnStop:Finalizando ciclo visivel");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(CICLO_PDM_TAG,"OnDestroy:Finalizando ciclo completo");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(CICLO_PDM_TAG,"onRestart:Preparando para chamar onStart");
    }


}