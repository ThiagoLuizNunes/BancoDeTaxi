package com.example.thiago.bancodetaxi.Activitys;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thiago.bancodetaxi.Activitys.DriverActivity;
import com.example.thiago.bancodetaxi.Activitys.MainActivity;
import com.example.thiago.bancodetaxi.R;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    private Cursor cursor;
    String id;
    private EditText editText1, editText2,editText3,editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        id = getIntent().getStringExtra("ID");
        cursor = MainActivity.crud.selectMotorista(id);

        editText1 = (EditText) findViewById(R.id.editDnome);
        editText2 = (EditText) findViewById(R.id.editDcpf);
        editText3 = (EditText) findViewById(R.id.editDcnh);
        editText4 = (EditText) findViewById(R.id.editDdata);

        editText1.setText(cursor.getString(5));
        editText2.setText(cursor.getString(3));
        editText3.setText(cursor.getString(4));
        editText4.setText(cursor.getString(6));
    }

    public void onClickConfirmEdit(View view){

        ArrayList<String> arrayEdit = new ArrayList<>();

        arrayEdit.add(editText1.getText().toString());
        arrayEdit.add(editText2.getText().toString());
        arrayEdit.add(editText3.getText().toString());
        arrayEdit.add(editText4.getText().toString());

        String conditon = MainActivity.crud.updateMotorista(arrayEdit, id);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        if (conditon == "Dados editados com sucesso"){
            Toast toast = Toast.makeText(context, conditon, duration);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(context, conditon, duration);
            toast.show();
        }
        finish();
    }
}
