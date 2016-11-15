package com.example.thiago.bancodetaxi.Activitys;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thiago.bancodetaxi.Class.DataClass;
import com.example.thiago.bancodetaxi.ClientActivity;
import com.example.thiago.bancodetaxi.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static DataClass crud;
    private Button buttonRegister;
    private Button buttonLogin;
    private EditText editLogin, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        editLogin = (EditText) findViewById(R.id.editLogin);
        editPassword = (EditText) findViewById(R.id.editPassword);

        crud = new DataClass(this);

    }

    public void onClickLogin(View v){

        Log.e("selectLogin", "antes");
        Boolean signal = false;
        ArrayList<String> list;
        Cursor motorista = crud.selectLogin("motorista");
        Cursor cliente = crud.selectLogin("");
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Log.e("selectLogin", "passei");

        if((motorista.getCount() == 0) && cliente.getCount() == 0){
            //show message
            //showMessage("Erro", "nothing found");
            Toast toast = Toast.makeText(context, "Erro, nothing found", duration);
            toast.show();
            return;
        }
        String login = editLogin.getText().toString();
        String password = editPassword.getText().toString();
        Log.e("EditText: ", login);
        Log.e("EditText: ", password);

        while (motorista.moveToNext()){
            String s1 = motorista.getString(1);
            String s2 = motorista.getString(2);
            //Log.e("Login: ", s1);
            //Log.e("Senha: ", s2);
            if((login.equals(s1)) && (password.equals(s2))){
                //showMessage("Login ", "realizado");
                list = new ArrayList<>();
                /*int i;
                for (i = 0; i<=motorista.getCount()+1; i++){
                    list.add(motorista.getString(i+1));
                    Log.e("Motorista"+i, list.get(i));
                }*/
                list.add(motorista.getString(1));
                Log.e("Login: ", list.get(0));
                list.add(motorista.getString(2));
                Log.e("Senha: ", list.get(1));
                list.add(motorista.getString(3));
                Log.e("CPF: ", list.get(2));
                list.add(motorista.getString(4));
                Log.e("CNH: ", list.get(3));
                list.add(motorista.getString(5));
                Log.e("Nome: ", list.get(4));
                list.add(motorista.getString(6));
                Log.e("Data: ", list.get(5));

                Toast toast = Toast.makeText(context, "Login realizado", duration);
                toast.show();

                Intent intent = new Intent(this, DriverActivity.class);
                startActivity(intent);
                return;
            }
            if((motorista.isLast())){
                signal = true;
                continue;
            }
        }
        Log.e("Signal", signal.toString());
        if(signal && (cliente.getCount() != 0)){
            Log.e("Crud", "cliente");
            while (cliente.moveToNext()){
                String s1 = cliente.getString(1);
                String s2 = cliente.getString(2);
                //Log.e("Login: ", s1);
                //Log.e("Senha: ", s2);
                if((login.equals(s1)) && (password.equals(s2))){
                    //showMessage("Login ", "realizado");

                    list = new ArrayList<>();
                    int i;
                    list.add(cliente.getString(1));
                    Log.e("Login: ", list.get(0));
                    list.add(cliente.getString(2));
                    Log.e("Login: ", list.get(1));
                    list.add(cliente.getString(3));
                    Log.e("Login: ", list.get(2));
                    list.add(cliente.getString(4));
                    Log.e("Login: ", list.get(3));

                    Toast toast = Toast.makeText(context, "Login realizado", duration);
                    toast.show();
                    Intent intent = new Intent(this, ClientActivity.class);
                    startActivity(intent);
                    return;
                }
                if((cliente.isLast())){
                    //showMessage("Login/Senha incorretos ", "");
                    Toast toast = Toast.makeText(context, "Login/Senha incorretos", duration);
                    toast.show();
                    editLogin.getText().clear();
                    editPassword.getText().clear();
                    return;
                }
            }
        }
        else{
            //showMessage("Login/Senha incorretos ", "");
            Toast toast = Toast.makeText(context, "Login/Senha incorretos", duration);
            toast.show();
            editLogin.getText().clear();
            editPassword.getText().clear();
        }
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void onClickRegister (View view){
        editLogin.getText().clear();
        editPassword.getText().clear();
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
