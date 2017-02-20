package com.cybercaterpillar.kriptografiTest;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import database.DatabaseHandler;
import database.S1HasilEnkripsi;

public class CrypText extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptext);
        final Button btnUjiAES = (Button) findViewById(R.id.btnUjiAES);
        final Button btnUjiBlowfish = (Button) findViewById(R.id.btnUjiBlowfish);
        final Button btnSQLite = (Button) findViewById(R.id.btnSQLite);

        new Thread(new Runnable() {
            public void run() {

                DataPengujian dapeng = new DataPengujian();
                dapeng.dataPengujianSkenario1(db);
                dapeng.dataPengujianSkenario2(db);
                dapeng.dataPengujianSkenario3(db);
            }
        }).start();


        btnUjiAES.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getBaseContext(), UjiAES.class);
                startActivity(intent);

            }
        });

        btnUjiBlowfish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getBaseContext(), UjiBlowfish.class);
                startActivity(intent);

            }
        });

        btnSQLite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent dbmanager = new Intent(getBaseContext(),AndroidDatabaseManager.class);
                startActivity(dbmanager);
            }
        });
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_smskripto, menu);
        return true;
    }
}
