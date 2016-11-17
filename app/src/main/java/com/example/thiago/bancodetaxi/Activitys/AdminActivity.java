package com.example.thiago.bancodetaxi.Activitys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.thiago.bancodetaxi.R;

public class AdminActivity extends AppCompatActivity {

    private Button button1,button2,button3,button4;
    private Context context;
    private int duration;
    private String conditon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        context = getApplicationContext();
        duration = Toast.LENGTH_SHORT;
        conditon = "Tabela deletada";

        button1 = (Button) findViewById(R.id.buttonDeletM);
        button2 = (Button) findViewById(R.id.buttonDeletC);
        button3 = (Button) findViewById(R.id.buttonDeletCo);
        button4 = (Button) findViewById(R.id.buttonDeletCa);
    }


    public void onClickDeletDriver(View view){
        MainActivity.crud.deleteTable("motorista");
        Toast toast = Toast.makeText(context, conditon, duration);
        toast.show();
        Log.e("DELETE", "MOTORISTA");
    }
    public void onClickDeleClient(View view){
        MainActivity.crud.deleteTable("usuario");
        Toast toast = Toast.makeText(context, conditon, duration);
        toast.show();
        Log.e("DELETE", "CLIENTE");
    }
    public void onClickDeletCall(View view){
        MainActivity.crud.deleteTable("chamada");
        Toast toast = Toast.makeText(context, conditon, duration);
        toast.show();
        Log.e("DELETE", "CHAMADA");
    }
    public void onClickDeletCar(View view){
        MainActivity.crud.deleteTable("carros");
        Toast toast = Toast.makeText(context, conditon, duration);
        toast.show();
        Log.e("DELETE", "CARRO");
    }
}
