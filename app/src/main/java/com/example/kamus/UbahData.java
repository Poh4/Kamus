package com.example.kamus;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UbahData extends AppCompatActivity {
    private SQLiteDatabase db = null;
    private Cursor kamusCursor = null;
    private EditText txtIndonesia;
    private EditText txtInggris;
    private DataKamus dataKamus =  null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ubah_data);
        Bundle extras = getIntent().getExtras();
        String inggrisValue = extras.getString("inggris");
        dataKamus = new DataKamus(this);
        db = dataKamus.getWritableDatabase();
        dataKamus.createTable(db);
        dataKamus.generateData(db);
        Log.d("inggris Value",inggrisValue);

        txtInggris  = (EditText) findViewById(R.id.textengUbah);
        txtIndonesia  = (EditText) findViewById(R.id.textinaUbah);


        txtInggris.setText(inggrisValue);

    }

    public void UbahData(View v){
        db.execSQL("UPDATE kamus SET indonesia='"+txtIndonesia.getText().toString()+"' WHERE kamus.inggris='"+txtInggris.getText().toString()+"'");
        Toast.makeText(getBaseContext(),"data berhasil di update",Toast.LENGTH_SHORT).show();
    }
    public void Kembali(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}