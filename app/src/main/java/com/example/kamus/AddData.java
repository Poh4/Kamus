package com.example.kamus;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class AddData extends AppCompatActivity{
    private SQLiteDatabase db = null;
    private Cursor kamusCursor = null;
    private EditText txtIndonesia;
    private EditText txtInggris;
    private DataKamus dataKamus =  null;
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        dataKamus = new DataKamus(this);
        db = dataKamus.getWritableDatabase();
        dataKamus.createTable(db);
        dataKamus.generateData(db);

        setContentView(R.layout.simpan);
        txtInggris  = (EditText) findViewById(R.id.texteng);
        txtIndonesia  = (EditText) findViewById(R.id.textina);
    }
    public void SimpanData(View v){
        db.execSQL("insert into kamus(inggris,indonesia) "+"values('"+txtInggris.getText().toString()+"',"+"'"+txtIndonesia.getText().toString()+"')");
        Toast.makeText(getBaseContext(),"data sudah disimpan",Toast.LENGTH_SHORT).show();
    }
    public void Kembali(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
