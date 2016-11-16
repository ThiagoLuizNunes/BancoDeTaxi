package com.example.thiago.bancodetaxi.Activitys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thiago.bancodetaxi.R;

public class CarActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        editText1 = (EditText) findViewById(R.id.editPlaca);
        editText2 = (EditText) findViewById(R.id.editMarca);
        editText3 = (EditText) findViewById(R.id.editAno);
    }

    public void onClickCarConfirm(View v){

        String placa = editText1.getText().toString();
        String marca = editText2.getText().toString();
        String ano = editText3.getText().toString();
        String m_cpf = (String) getIntent().getSerializableExtra("CPF");

        String conditon = MainActivity.crud.insertCarro(placa, marca, ano, m_cpf);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        if (conditon == "Carro Inserido com sucesso"){
            Toast toast = Toast.makeText(context, conditon, duration);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(context, conditon, duration);
            toast.show();
        }
        finish();
    }
}
