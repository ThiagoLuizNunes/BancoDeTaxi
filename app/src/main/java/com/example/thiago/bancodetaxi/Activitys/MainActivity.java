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

import com.example.thiago.bancodetaxi.Class.BancoClass;
import com.example.thiago.bancodetaxi.Class.BancoController;
import com.example.thiago.bancodetaxi.R;

public class MainActivity extends AppCompatActivity {

    public static BancoClass crud;
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

        crud = new BancoClass(this);

    }

    public void onClickLogin(View v){

        Log.e("selectLogin", "antes");
        Boolean signal = false;
        Cursor motorista = crud.selectLogin("motorista");
        Cursor cliente = crud.selectLogin("");

        Log.e("selectLogin", "passei");

        if((motorista.getCount() == 0) && cliente.getCount() == 0){
            //show message
            showMessage("Erro", "nothing found");
            return;
        }
        String login = editLogin.getText().toString();
        String password = editPassword.getText().toString();
        Log.e("EditText: ", login);
        Log.e("EditText: ", password);

        while (motorista.moveToNext()){
            String s1 = motorista.getString(0);
            String s2 = motorista.getString(1);
            Log.e("Login: ", s1);
            Log.e("Senha: ", s2);
            if((login.equals(s1)) && (password.equals(s2))){
                showMessage("Login ", "realizado");
                return;
            }
            if((motorista.isLast())){
                signal = true;
                /*showMessage("Login/Senha incorretos ", "");
                editLogin.getText().clear();
                editPassword.getText().clear();*/
                continue;
            }
        }
        Log.e("Signal", signal.toString());
        if(signal){
            Log.e("Crud", "cliente");

            Log.e("Crud", "cliente");
            while (cliente.moveToNext()){
                String s1 = cliente.getString(0);
                String s2 = cliente.getString(1);
                Log.e("Login: ", s1);
                Log.e("Senha: ", s2);
                if((login.equals(s1)) && (password.equals(s2))){
                    showMessage("Login ", "realizado");
                    return;
                }
                if((cliente.isLast())){
                    showMessage("Login/Senha incorretos ", "");
                    editLogin.getText().clear();
                    editPassword.getText().clear();
                    return;
                }
            }
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

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
