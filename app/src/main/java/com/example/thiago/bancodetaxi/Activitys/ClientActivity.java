package com.example.thiago.bancodetaxi.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.thiago.bancodetaxi.R;

import java.util.ArrayList;

public class ClientActivity extends AppCompatActivity {

    private ArrayList<String> listClient;
    private TextView textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        listClient = (ArrayList) getIntent().getSerializableExtra("listClient");

        textView1 = (TextView) findViewById(R.id.textNomeC);
        textView2 = (TextView) findViewById(R.id.textEnd);

        textView1.setText("Nome: "+listClient.get(2));
            textView2.setText("Endereço: "+listClient.get(3));
    }

    public void onClickCall(View v){

    }
}
