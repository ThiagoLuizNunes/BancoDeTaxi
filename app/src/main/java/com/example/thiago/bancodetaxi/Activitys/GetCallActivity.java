package com.example.thiago.bancodetaxi.Activitys;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thiago.bancodetaxi.R;

import java.util.ArrayList;

public class GetCallActivity extends AppCompatActivity {

    private TextView textView1, textView2;
    private Cursor cursor1, cursor2;
    private ArrayList<String> catchArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_call);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        textView1 = (TextView) findViewById(R.id.textClient);
        textView2 = (TextView) findViewById(R.id.textLocal);

        if(MainActivity.listCall.isEmpty()){
            Toast toast = Toast.makeText(context, "Não há corridas no momento", duration);
            toast.show();
            finish();
        }
        else {
            catchArray = MainActivity.listCall.getLast();
            MainActivity.listCall.removeLast();
            textView1.setText("Cliente: "+catchArray.get(0));
            textView2.setText("Localização: "+catchArray.get(1));
        }
        /*cursor1 = MainActivity.crud.selectChamada();
        if(cursor1.getCount() == 0){
            Toast toast = Toast.makeText(context, "Não há corridas no momento", duration);
            toast.show();
            finish();
        }
        cursor2 = MainActivity.crud.selectUsuario(cursor1.getString(4));

        textView1.setText("Cliente: "+cursor2.getString(3));
        textView2.setText("Localização: "+cursor1.getString(1));*/

    }
    public void onClickCancel(View v){
        MainActivity.listCall.addFirst(catchArray);
        finish();
    }
}
