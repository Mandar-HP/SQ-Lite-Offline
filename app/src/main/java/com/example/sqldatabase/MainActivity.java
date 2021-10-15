package com.example.sqldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase sqlObj;

    ArrayList<Products> arrayListObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    public void init(){

        sqlObj = openOrCreateDatabase("Mac_Database",MODE_PRIVATE,null);

        arrayListObj = new ArrayList<Products>();

        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        try {
            sqlObj.execSQL("create table arrayListObj ( id integer primary key, name text, value integer)");
        }catch (Exception e){

        }

        ContentValues contentValuesPbj = new ContentValues();
        contentValuesPbj.put("value",10213);
        contentValuesPbj.put("name","This is First Try");
        contentValuesPbj.put("id",13);
        contentValuesPbj.put("value",10213454);
        contentValuesPbj.put("name","Second Try");
        contentValuesPbj.put("id",102);



        // TABLE NAME OF INSERT METHOD SHOULD BE EXACTLY SAME AS THAT OF INSIDE EXECSQL METHOD :
        long productsRowNumber = sqlObj.insert("arrayListObj", null, contentValuesPbj);

        if (productsRowNumber > -1 ){
            Toast.makeText(this, "Insertion Successfull !", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Insertion Failed !", Toast.LENGTH_SHORT).show();
        }
    }


}