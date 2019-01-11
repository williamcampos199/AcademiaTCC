package com.campos.william.academiatcc.banco.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper  extends SQLiteOpenHelper {

    //Criação do Banco

    private static final String DATABASE_NAME ="academia.db";
    private static final int DATABASE_VERSION = 1;

    //CREATE TABLES
    private final String CREATE_TABLE_DIETA = "CREATE TABLE Dieta (iddieta INTEGER PRIMARY KEY AUTOINCREMENT , nome TEXT NOT NULL , datadieta TEXT NOT NULL , calorias REAL NOT NULL );";
    private final String CREATE_TABLE_ALIMENTO = "CREATE TABLE Alimento (idalimento INTEGER PRIMARY KEY AUTOINCREMENT , nome TEXT NOT NULL , calorias REAL NOT NULL );";
    private final String CREATE_TABLE_ITEMALIMENTO= "CREATE TABLE ItemAlimento(iditemalimento INTEGER PRIMARY KEY AUTOINCREMENT , idalimento INTEGER NOT NULL , iddieta INTEGER NOT NULL , quantidade REAL NOT NULL , calorias REAL NOT NULL ," +
            "FOREIGN KEY (idalimento) REFERENCES Alimento(idalimento), " +
            "FOREIGN KEY (iddieta) REFERENCES Dieta(iddieta));";
    private final String CREATE_TABLE_EXERCICIO ="CREATE TABLE Exercicio(idexercicio INTEGER PRIMARY KEY AUTOINCREMENT , tipo TEXT NOT NULL , nome TEXT NOT NULL , repeticoes TEXT NOT NULL , obs TEXT);";
   private final String CREATE_TABLE_TREINO = "CREATE TABLE Treino (idtreino INTEGER PRIMARY KEY AUTOINCREMENT , descricao TEXT NOT NULL);";
    private final String CREATE_TABLE_ALUNO = "CREATE TABLE Aluno (idaluno INTEGER PRIMARY KEY AUTOINCREMENT ,idtreino INTEGER NOT NULL , nome TEXT NOT NULL , datanascimento TEXT NOT NULL ," +
            " objetivo TEXT NOT NULL ,datainicio TEXT NOT NULL , altura REAL NOT NULL , sexo TEXT NOT NULL ," +
            " FOREIGN KEY (idtreino) REFERENCES Treino(idtreino)  );";
    private final String CREATE_TABLE_PESO = "CREATE TABLE Peso(idpeso INTEGER PRIMARY KEY AUTOINCREMENT , valor REAL NOT NULL, datapeso TEXT NOT NULL , imc REAL NOT NULL );";
    private final String CREATE_TABLE_ITEMPESO= "CREATE TABLE ItemPeso(iditempeso INTEGER PRIMARY KEY AUTOINCREMENT , idpeso INTEGER NOT NULL , idaluno INTEGER NOT NULL ," +
            "FOREIGN KEY (idpeso) REFERENCES Peso(idpeso), " +
            "FOREIGN KEY (idaluno) REFERENCES Aluno(idaluno));";
    private final String CREATE_TABLE_ITEMDIETA= "CREATE TABLE ItemDieta(iditemdieta INTEGER PRIMARY KEY AUTOINCREMENT , idaluno INTEGER NOT NULL , iddieta INTEGER NOT NULL , " +
            "FOREIGN KEY (idaluno) REFERENCES Aluno(idaluno), " +
            "FOREIGN KEY (iddieta) REFERENCES Dieta(iddieta));";
    private final String CREATE_TABLE_ITEMEXERCICIO= "CREATE TABLE ItemExercicio(iditemexercicio INTEGER PRIMARY KEY AUTOINCREMENT , idtreino INTEGER NOT NULL , idexercicio INTEGER NOT NULL , dia TEXT NOT NULL ," +
            "FOREIGN KEY (idtreino) REFERENCES Treino(idtreino), " +
            "FOREIGN KEY (idexercicio) REFERENCES Exercicio(idexercicio));";
    private final String CREATE_TABLE_BATIMENTOS = "CREATE TABLE Batimentos (idbatimentos INTEGER PRIMARY KEY AUTOINCREMENT , valor INTEGER NOT NULL);";
    private final String CREATE_TABLE_AEROBICO ="CREATE TABLE Aerobico(idaerobico INTEGER PRIMARY KEY AUTOINCREMENT , distancia REAL NOT NULL , Tempo TEXT NOT NULL ,velocidade REAL NOT NULL , calorias REAL NOT NULL);";
    private final String CREATE_TABLE_ITEMBATIMENTOS= "CREATE TABLE ItemBatimentos(iditembatimentos INTEGER PRIMARY KEY AUTOINCREMENT , idaerobico INTEGER NOT NULL , idbatimentos INTEGER NOT NULL , " +
            "FOREIGN KEY (idaerobico) REFERENCES Aerobico(idaerobico), " +
            "FOREIGN KEY (idbatimentos) REFERENCES Batimentos(idbatimentos));";
    private final String CREATE_TABLE_ITEMAEROBICO= "CREATE TABLE ItemAerobico(iditemaerobico INTEGER PRIMARY KEY AUTOINCREMENT , idaluno INTEGER NOT NULL , idaerobico INTEGER NOT NULL , " +
            "FOREIGN KEY (idaerobico) REFERENCES Aerobico(idaerobico), " +
            "FOREIGN KEY (idaluno) REFERENCES Aluno(idaluno));";
    private final String CREATE_TABLE_LOGIN = "CREATE TABLE Login (idlogin INTEGER PRIMARY KEY AUTOINCREMENT ,idaluno INTEGER NOT NULL , usuario TEXT NOT NULL , senha TEXT NOT NULL ," +
            " FOREIGN KEY (idaluno) REFERENCES Aluno(idaluno)  );";


    //Insert de inicio para ter algo no começo


    private final String INSERT_TABLE_TREINO = "INSERT INTO Treino(descricao) VALUES ('sem treino');";
    private final String INSERT_TABLE_USUARIO = "INSERT INTO Aluno(idtreino, nome , datanascimento, objetivo, datainicio, altura, sexo ) " +
            "VALUES (1,'sem nome','06/06/2000', 'perder peso', '20/05/2018', '1.74' , 'M') ; ";
    private final String INSERT_TABLE_LOGIN = "INSERT INTO Login(idaluno, usuario, senha)" +
            "VALUES (1,'will','123456'); ";



    public DbHelper(Context context){
        super(context , DATABASE_NAME ,null , DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Primeira execução do banco
        db.execSQL(CREATE_TABLE_DIETA);
        db.execSQL(CREATE_TABLE_ALIMENTO);
        db.execSQL(CREATE_TABLE_ITEMALIMENTO);
        db.execSQL(CREATE_TABLE_EXERCICIO);
        db.execSQL(CREATE_TABLE_TREINO);
        db.execSQL(CREATE_TABLE_ALUNO);
        db.execSQL(CREATE_TABLE_PESO);
        db.execSQL(CREATE_TABLE_ITEMPESO);
        db.execSQL(CREATE_TABLE_ITEMDIETA);
        db.execSQL(CREATE_TABLE_ITEMEXERCICIO);
        db.execSQL(CREATE_TABLE_BATIMENTOS);
        db.execSQL(CREATE_TABLE_AEROBICO);
        db.execSQL(CREATE_TABLE_ITEMBATIMENTOS);
        db.execSQL(CREATE_TABLE_ITEMAEROBICO);
        db.execSQL(CREATE_TABLE_LOGIN);

        db.execSQL(INSERT_TABLE_TREINO);
        db.execSQL(INSERT_TABLE_USUARIO);
        db.execSQL(INSERT_TABLE_LOGIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
}
