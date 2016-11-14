package com.example.thiago.bancodetaxi.Activitys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thiago.bancodetaxi.R;

public class RegisterActivity extends AppCompatActivity {

    private Button buttonConfirm;
    private EditText editText1,editText2,editText3,editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);

        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
    }

    public void onClickConfirm(View v){

        String cpf = editText1.getText().toString();
        String cnh = editText2.getText().toString();
        String nome = editText3.getText().toString();
        String data_adm = editText4.getText().toString();

        String conditon = MainActivity.crud.insertMotorista(cpf, cnh, nome, data_adm);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        if (conditon == "Registro Inserido com sucesso"){
            Toast toast = Toast.makeText(context, conditon, duration);
            toast.show();
        }
        else {
            CharSequence text = "Erro ao inserir registro";
            Toast toast = Toast.makeText(context, conditon, duration);
            toast.show();
        }
        finish();
    }
}
