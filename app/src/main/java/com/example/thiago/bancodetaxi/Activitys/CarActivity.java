package com.example.thiago.bancodetaxi.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    }
}
