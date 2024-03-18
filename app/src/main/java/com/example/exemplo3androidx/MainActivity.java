package com.example.exemplo3androidx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> startActivityIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //para atender quando retorne da 2ª tela, então pegaremos os dados recebidos:
        startActivityIntent = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        String cpf="---", nome="---";
                        TextView txtnome = (TextView) findViewById(R.id.textView);
                        TextView txtrgm = (TextView) findViewById(R.id.textView2);
                        if (result.getResultCode() == 10) {  //clicou no botão OK na 2ª tela
                            Bundle bundle = result.getData().getExtras();
                            cpf = (String) bundle.get("cpf");
                            nome = (String) bundle.get("nome");
                        }
                        else if (result.getResultCode() == 13) {  //clicou no botão Cancelar na 2ª tela
                            cpf = "Foi cancelado o cadastro."; nome = "Pode tentar novamente.";
                        }
                        txtrgm.setText(cpf); txtnome.setText(nome);
                        }
                    });
                }

        public void abrirCadastro (View v){
            //utilizaremos o atendente startActivityIntent que foi registrado no onCreate:
            Intent intent = new Intent(this, Cadastro.class);
            startActivityIntent.launch(intent);
        }

    }
