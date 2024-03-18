package com.example.exemplo3androidx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void onClickBotaoOK(View v) {
        EditText txtcpf = (EditText) findViewById(R.id.editText2);
        EditText txtnome = (EditText) findViewById(R.id.editText);

        Intent it = new Intent();
        it.putExtra("cpf", txtcpf.getText().toString());
        it.putExtra("nome", txtnome.getText().toString());

        setResult(10, it); //classificamos o resultado como tipo 10
        finish();
    }

    public void onClickBotaoCancelar(View v) {
        Intent it = new Intent();
        setResult(13, it); //classificamos o resultado como tipo 13
        finish();
    }

}
