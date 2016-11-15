package com.example.thiago.bancodetaxi.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.thiago.bancodetaxi.R;

import java.util.ArrayList;

public class DriverActivity extends AppCompatActivity {

    private ArrayList<String> listDriver;
    private TextView textView1,textView2,textView3,textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        /*Receiving ArraysList listDriver from MainActivity*/
        listDriver = (ArrayList) getIntent().getSerializableExtra("listDriver");

        textView1 = (TextView) findViewById(R.id.textNome);
        textView2 = (TextView) findViewById(R.id.textCPF);
        textView3 = (TextView) findViewById(R.id.textCNH);
        textView4 = (TextView) findViewById(R.id.textData);

        textView1.setText("Nome: "+listDriver.get(4));
        textView2.setText("CPF: "+listDriver.get(2));
        textView3.setText("CNH: "+listDriver.get(3));
        textView4.setText("DATA: "+listDriver.get(5));
    }
}
