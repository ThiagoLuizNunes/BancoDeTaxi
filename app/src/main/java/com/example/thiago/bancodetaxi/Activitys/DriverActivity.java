package com.example.thiago.bancodetaxi.Activitys;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.thiago.bancodetaxi.R;

import java.util.ArrayList;

public class DriverActivity extends AppCompatActivity {

    private ArrayList<String> listDriver;
    private String id;
    private TextView textView1,textView2,textView3,textView4;
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        /*Receiving ArraysList listDriver from MainActivity*/
        id = getIntent().getStringExtra("ID");
        cursor = MainActivity.crud.selectMotorista(id);

        textView1 = (TextView) findViewById(R.id.textNome);
        textView2 = (TextView) findViewById(R.id.textCPF);
        textView3 = (TextView) findViewById(R.id.textCNH);
        textView4 = (TextView) findViewById(R.id.textData);

        for(int i=0; i<=6; i++){
            Log.e("Driver: ", cursor.getString(i));
        }
        textView1.setText("Nome: "+cursor.getString(5));
        textView2.setText("CPF: "+cursor.getString(3));
        textView3.setText("CNH: "+cursor.getString(4));
        textView4.setText("DATA: "+cursor.getString(6));
    }
    @Override
    public void onResume(){
        super.onResume();
        cursor = MainActivity.crud.selectMotorista(id);
        textView1.setText("Nome: "+cursor.getString(5));
        textView2.setText("CPF: "+cursor.getString(3));
        textView3.setText("CNH: "+cursor.getString(4));
        textView4.setText("DATA: "+cursor.getString(6));
    }
    public void onClickEdit(View v){
        Intent intent = new Intent(getApplicationContext(), EditActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }
    public void onClickAddCarro(View v){
        Intent intent = new Intent(getApplicationContext(), CarActivity.class);
        intent.putExtra("CPF", listDriver.get(2));
        startActivity(intent);
    }
    public void onClickGetCall(View v){
        Intent intent = new Intent(getApplicationContext(), GetCallActivity.class);
        startActivity(intent);
    }
}
