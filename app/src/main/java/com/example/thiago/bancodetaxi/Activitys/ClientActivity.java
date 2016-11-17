package com.example.thiago.bancodetaxi.Activitys;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thiago.bancodetaxi.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ClientActivity extends AppCompatActivity {

    private ArrayList<String> listClient;
    private TextView textView1,textView2;
    private EditText editOrigem;
    private Cursor cursor;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        //listClient = (ArrayList) getIntent().getSerializableExtra("listClient");
        id = getIntent().getStringExtra("ID");

        cursor = MainActivity.crud.selectUsuario(id);

        textView1 = (TextView) findViewById(R.id.textNomeC);
        textView2 = (TextView) findViewById(R.id.textEnd);
        editOrigem = (EditText) findViewById(R.id.editOrigem);

        textView1.setText("Nome: "+cursor.getString(3));
        textView2.setText("Endereço: "+cursor.getString(4));
    }

    public void onClickCall(View v){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
        date.setTimeZone(TimeZone.getTimeZone("GMT+1:00"));

        String origem = editOrigem.getText().toString();
        String h_chamada = date.format(currentLocalTime);
        String h_chegada = date.format(currentLocalTime);
        String u_id = cursor.getString(0); //Chamada realizada com sucesso

        Log.e("Hora",h_chamada);

        String conditon = MainActivity.crud.insertChamada(origem, h_chamada, h_chegada, u_id);
        ArrayList<String> chamada = new ArrayList<>();

        chamada.add(cursor.getString(3));
        chamada.add(origem);

        Log.e("List", chamada.get(0));
        Log.e("List", chamada.get(1));

        MainActivity.listCall.addFirst(chamada);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        if (conditon == "Chamada realizada com sucesso"){
            Toast toast = Toast.makeText(context, conditon, duration);
            toast.show();
            editOrigem.getText().clear();
        }
        else {
            Toast toast = Toast.makeText(context, conditon, duration);
            toast.show();
        }
    }
}
