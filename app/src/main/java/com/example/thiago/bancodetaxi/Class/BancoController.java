package com.example.thiago.bancodetaxi.Class;

/**
 * Created by Thiago on 12/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private BancoClass banco;

    public BancoController(Context context){
        banco = new BancoClass(context);
    }

    public String insertMotorista(String cpf, String cnh, String nome, String endereco, String data_adm,
                                  String data_nasc, String salario, String jornada){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoClass.CPF, cpf);
        valores.put(BancoClass.CNH, cnh);
        valores.put(BancoClass.NOME, nome);
        valores.put(BancoClass.ENDERECO, endereco);
        valores.put(BancoClass.DATA_ADMIN, data_adm);
        valores.put(BancoClass.DATA_NASC, data_nasc);
        valores.put(BancoClass.SALARIO, salario);
        valores.put(BancoClass.JORNADA, jornada);

        resultado = db.insert(BancoClass.TABELA_MOTORISTA, null, valores);
        db.close();

        if (resultado == -1){
            return "Erro ao inserir registro";
        }
        else{
            return "Registro Inserido com sucesso";
        }

    }
}
