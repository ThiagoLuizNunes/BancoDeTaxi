package com.example.thiago.bancodetaxi.Class;

/**
 * Created by Thiago on 12/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Thiago on 11/11/2016.
 */

public class DataClass extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    //Nome do Banco de Dados
    protected static final String NOME_BANCO = "bd_taxi.bd";
    //Nome das tabelas do banco
    protected static final String TABELA_CARROS = "carros";
    protected static final String TABELA_CHAMADA = "chamada";
    protected static final String TABELA_FILA = "fila";
    protected static final String TABELA_CORRIDA = "corrida";
    protected static final String TABELA_CORRIDA_DESEMBARQUE = "corrida_desembarque";
    protected static final String TABELA_CORRIDA_EMBARQUE = "corrida_embarque";
    protected static final String TABELA_MOTORISTA = "motorista";
    protected static final String TABELA_MOTORISTA_FONE = "motorista_fone";
    protected static final String TABELA_USUARIO = "usuario";
    protected static final int VERSAO = 1;

    //Colunas comuns
    protected static final String ID = "_id";
    protected static final String LOGIN = "login";
    protected static final String PASSWORD = "password";
    protected static final String DATA = "data";
    protected static final String NOME = "nome";
    protected static final String ENDERECO = "endereco";
    protected static final String M_CPF = "motorista_cpf"; //ForeingKey
    protected static final String CORRIDA_ID = "corrida_id"; //ForeingKey

    //Colunas Carro
    /*_id*/
    /*motorista_cpf*/
    protected static final String PLACA = "placa";
    protected static final String MARCA = "marca";
    protected static final String ANO = "ano";
    protected static final String CONSUMO = "consumo";
    protected static final String HORARIO = "horario";

    //Colunas Chamada
    /*_id*/
    /*data*/
    protected static final String ORIGEM = "origem";
    protected static final String H_CHAMADA = "hora_chamda";
    protected static final String H_CHEGADA = "hora_chegada";
    protected static final String U_ID = "usuario_id"; //ForeingKey

    //Colunas Corrida
    /*_id*/
    /*motorista_cpf*/
    protected static final String CHAMADA_ID = "chamada_id"; //ForeingKey

    //Colunas Corrida Desembarque
    /*_id*/
    /*data*/
    /*corrida_id*/
    protected static final String ITINERARIO = "itinerario";
    protected static final String HORA_D = "hora_D";
    protected static final String LOCAL_D = "local_D";
    protected static final String KM = "km";
    protected static final String VALOR = "valor";

    //Coluna Corrida Embarque
    /*_id*/
    /*corrida_id*/
    protected static final String HORA_E = "hora_E";
    protected static final String LOCAL_E = "local_E";

    //Coluna Motorista
    /*_id*/
    /*nome*/
    /*endereco*/
    protected static final String CPF = "cpf";
    protected static final String CNH = "cnh";
    protected static final String DATA_ADMIN = "data_admin";
    protected static final String DATA_NASC = "data_nasc";
    protected static final String SALARIO = "salario";
    protected static final String JORNADA = "jornada";

    //Coluna Motorista Fone
    /*_id*/
    /*motorista_cpf*/
    protected static final String FONE_1 = "fone_1";
    protected static final String FONE_2 = "fone_2";

    //Coluna Usuário
    /*_id*/
    /*nome*/
    /*endereco*/
    protected static final String FONE = "fone";


    public DataClass(Context context){

        super(context, NOME_BANCO,null,VERSAO);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("onCreate", "Inicio");
        //Criando Tabela Usuario
        db.execSQL("CREATE TABLE " +
                TABELA_USUARIO + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                LOGIN + " TEXT NOT NULL," +
                PASSWORD + " TEXT NOT NULL," +
                NOME + " TEXT NOT NULL," +
                ENDERECO + " TEXT NOT NULL)"
        );
        Log.e("sqlUsuario", "Tabela Usuario criada");

        //Criando Tabela Motorista
        db.execSQL("CREATE TABLE " +
                TABELA_MOTORISTA + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                LOGIN + " TEXT NOT NULL," +
                PASSWORD + " TEXT NOT NULL," +
                CPF + " TEXT NOT NULL," +
                CNH + " TEXT NOT NULL," +
                NOME + " TEXT NOT NULL," +
                DATA_ADMIN + " TEXT NOT NULL)"
        );
        Log.e("sqlMotorista", "Tabela Motorista criada");

        Log.e("sqlCarro", "Tabela Carro criada");

        //Criando Tabela Chamada
        db.execSQL("CREATE TABLE " +
                TABELA_CHAMADA + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ORIGEM + " TEXT NOT NULL," +
                H_CHAMADA + " TEXT NOT NULL," +
                H_CHEGADA + " TEXT NOT NULL," +
                U_ID + " TEXT NOT NULL," +
                "FOREIGN KEY ("+U_ID+") REFERENCES "+TABELA_USUARIO+" ("+ID+"))"
        );
        Log.e("sqlChamada", "Tabela Chamada criada");

        //Criando Tabela Carro
        db.execSQL("CREATE TABLE " +
                TABELA_CARROS + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PLACA + " TEXT NOT NULL," +
                MARCA + " TEXT NOT NULL," +
                ANO + " TEXT NOT NULL," +
                M_CPF + " TEXT NOT NULL," +
                "FOREIGN KEY ("+M_CPF+") REFERENCES "+TABELA_MOTORISTA+" ("+CPF+"))"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_MOTORISTA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CARROS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CHAMADA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_FILA);
    }

    /*<<<<<<<<<<<<      QUERYS INSERT       >>>>>>>>>>>>*/
    /*<<<<<<<<<<<<      QUERYS INSERT       >>>>>>>>>>>>*/
    /*<<<<<<<<<<<<      QUERYS INSERT       >>>>>>>>>>>>*/
    public String insertMotorista(String login, String password, String cpf, String cnh, String nome,String data_adm){

        db = this.getWritableDatabase();

        Log.e("insertMotorista", "Inicio");
        ContentValues valores;
        long resultado;

        valores = new ContentValues();
        valores.put(LOGIN, login);
        valores.put(PASSWORD, password);
        valores.put(CPF, cpf);
        valores.put(CNH, cnh);
        valores.put(NOME, nome);
        valores.put(DATA_ADMIN, data_adm);
        Log.e("insertMotorista", "Insert");
        resultado = db.insert(TABELA_MOTORISTA, null, valores);

        db.close();

        if (resultado == -1){
            return "Erro ao inserir registro";
        }
        else{
            return "Motorista Inserido com sucesso";
        }
    }
    public String insertUsuario(String login, String password, String nome, String endereco){

        db = this.getWritableDatabase();

        Log.e("insertUsuario", "Inicio");
        ContentValues valores;
        long resultado;

        valores = new ContentValues();
        valores.put(LOGIN, login);
        valores.put(PASSWORD, password);
        valores.put(NOME, nome);
        valores.put(ENDERECO, endereco);
        Log.e("insertUsuario", "Insert");
        resultado = db.insert(TABELA_USUARIO, null, valores);
        db.close();

        if (resultado == -1){
            return "Erro ao inserir registro";
        }
        else{
            return "Usuário Inserido com sucesso";
        }
    }

    public String insertCarro(String placa, String marca, String ano, String m_cpf){

        db = this.getWritableDatabase();

        Log.e("insertCarro", "Inicio");
        ContentValues valores;
        long resultado;

        valores = new ContentValues();
        valores.put(PLACA, placa);
        valores.put(MARCA, marca);
        valores.put(ANO, ano);
        valores.put(M_CPF, m_cpf);
        Log.e("insertCarro", "Insert");
        resultado = db.insert(TABELA_CARROS, null, valores);
        db.close();

        if (resultado == -1){
            return "Erro ao inserir registro";
        }
        else{
            return "Carro Inserido com sucesso";
        }
    }

    public String insertChamada(String origem, String h_chamada, String h_chegada, String u_id){

        db = this.getWritableDatabase();

        Log.e("insertChamada", "Inicio");
        ContentValues valores;
        long resultado;

        valores = new ContentValues();
        valores.put(ORIGEM, origem);
        valores.put(H_CHAMADA, h_chamada);
        valores.put(H_CHEGADA, h_chegada);
        valores.put(U_ID, u_id);
        Log.e("insertChamada", "Insert");
        resultado = db.insert(TABELA_CHAMADA, null, valores);
        //db.insert(TABELA_FILA, null, valores);
        db.close();

        if (resultado == -1){
            return "Erro ao inserir registro";
        }
        else{
            return "Chamada realizada com sucesso";
        }
    }
    /*<<<<<<<<<<<<      QUERYS SELECT       >>>>>>>>>>>>*/
    /*<<<<<<<<<<<<      QUERYS SELECT       >>>>>>>>>>>>*/
    /*<<<<<<<<<<<<      QUERYS SELECT       >>>>>>>>>>>>*/
    public Cursor selectLogin(String type){
        Cursor cursor;
        if(type == "motorista"){
            db = getReadableDatabase();
            //cursor = db.query(TABELA_MOTORISTA, campos, null, null, null, null,null,null);
            cursor = db.rawQuery("SELECT * FROM "+TABELA_MOTORISTA+" ", null);

            if(cursor!=null){
                cursor.moveToFirst();
            }
            db.close();
        }
        else{
            db = getReadableDatabase();
            //cursor = db.query(TABELA_USUARIO, campos, null, null, null, null,null,null);
            cursor = db.rawQuery("SELECT * FROM "+TABELA_USUARIO+" ", null);

            if(cursor!=null){
                cursor.moveToFirst();
            }
            db.close();
        }
        return cursor;
    }
    public Cursor selectChamada(){

        Cursor cursor;
        db = getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM "+TABELA_CHAMADA+" ORDER BY ROWID ASC LIMIT 1", null);
        //db.delete(TABELA_FILA, ID + "= " + 1 ,null);//
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public Cursor selectMotorista(String s){

        Cursor cursor;
        db = getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM "+TABELA_MOTORISTA+" WHERE "+ID+"="+s, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public Cursor selectUsuario(String s){

        Cursor cursor;
        db = getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM "+TABELA_USUARIO+" WHERE "+ID+"="+s, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    /*<<<<<<<<<<<<      QUERYS UPDATE       >>>>>>>>>>>>*/
    /*<<<<<<<<<<<<      QUERYS UPDATE       >>>>>>>>>>>>*/
    /*<<<<<<<<<<<<      QUERYS UPDATE       >>>>>>>>>>>>*/
    public String updateMotorista(ArrayList<String> arrayEdit, String id){

        db = this.getWritableDatabase();
        Cursor cursor;
        Log.e("updateMotorista", "Inicio");
        ContentValues valores;
        long resultado;
        valores = new ContentValues();
        valores.put(NOME, arrayEdit.get(0));
        valores.put(CPF, arrayEdit.get(1));
        valores.put(CNH, arrayEdit.get(2));
        valores.put(DATA_ADMIN, arrayEdit.get(3));
        Log.e("updateMotorista", "Update");
        resultado = db.update(TABELA_MOTORISTA, valores, ID+"="+id, null);

        /*String query = "UPDATE "+TABELA_MOTORISTA+" " +
                "SET "+NOME+"="+arrayEdit.get(0)+" " +
                "SET "+CPF+"="+arrayEdit.get(1)+" " +
                "SET "+CNH+"="+arrayEdit.get(2)+" " +
                "SET "+DATA_ADMIN+"="+arrayEdit.get(3)+" " +
                "WHERE "+ID+"="+id;*/
        //cursor = db.rawQuery("UPDATE motorista SET cpf='editado' WHERE id=1", null);
        //cursor.moveToFirst();
        //db.rawQuery(query, null);
        db.close();

        if (resultado == -1){
            return "Erro ao editar dados";
        }
        else{
            return "Dados editados com sucesso";
        }
        //return "Dados editados com sucesso";
    }

    /*<<<<<<<<<<<<      QUERY DELETE       >>>>>>>>>>>>*/
    /*<<<<<<<<<<<<      QUERY DELETE       >>>>>>>>>>>>*/
    /*<<<<<<<<<<<<      QUERY DELETE       >>>>>>>>>>>>*/
    public void deleteTable(String table){

        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ table);
        db.close();
    }
}

