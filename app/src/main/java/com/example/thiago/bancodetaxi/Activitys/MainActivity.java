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
        Cursor res = crud.selectLogin(/*editLogin.getText().toString()*/);

        Log.e("selectLogin", "passei");

        if(res.getCount() == 0){
            //show message
            showMessage("Erro", "nothing found");
            return;
        }
        //StringBuffer buffer = new StringBuffer();

        String login = editLogin.getText().toString();
        String password = editPassword.getText().toString();
        Log.e("EditText: ", login);
        Log.e("EditText: ", password);

        while (res.moveToNext()){
            String s1 = res.getString(1);
            String s2 = res.getString(2);
            Log.e("Login: ", s1);
            Log.e("Senha: ", s2);
            if((login.equals(s1)) && (password.equals(s2))){
                showMessage("Login ", "realizado");
                return;
            }
            if(res.isLast()){
                showMessage("Login/Senha incorretos ", "");
                editLogin.getText().clear();
                editPassword.getText().clear();
            }
//            buffer.append("ID :" + res.getString(0)+ "\n");
//            buffer.append("CPF :" + res.getString(1)+ "\n");
//            buffer.append("DATA :" + res.getString(2)+ "\n");
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
