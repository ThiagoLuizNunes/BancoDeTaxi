package com.example.thiago.bancodetaxi.Activitys;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.thiago.bancodetaxi.R;

import java.util.ArrayList;

public class GetCallActivity extends AppCompatActivity {

    private TextView textView1, textView2;
    private Cursor cursor1, cursor2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_call);

        textView1 = (TextView) findViewById(R.id.textClient);
        textView2 = (TextView) findViewById(R.id.textLocal);

        cursor1 = MainActivity.crud.selectChamada();
        cursor2 = MainActivity.crud.selectUsuario(cursor1.getString(4));

        textView1.setText("Cliente: "+cursor2.getString(3));
        textView2.setText("Localização: "+cursor1.getString(1));

    }
    public void onClickCancel(View v){

        MainActivity.crud.insertChamada(cursor1.getString(1),cursor1.getString(2),cursor1.getString(3), cursor1.getString(4));
        finish();
    }
}
