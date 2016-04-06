package com.cybercaterpillar.kriptografiTest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import database.DatabaseHandler;
import database.S1HasilEnkripsi;
import database.Skenario1;

public class UjiAES extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uji);
        final Button btnEnkripsi = (Button) findViewById(R.id.btnEnkripsi);
        final Button btnDekripsi = (Button) findViewById(R.id.btnDekripsi);
        final Button btnClearDB = (Button) findViewById(R.id.btnClearDB);
        DatabaseHandler db = new DatabaseHandler(this);
        //db.deleteAllSkenario1();
       //db.deleteAllS1hasilenkripsi();

        // Reading all skenario 1
        Log.d("Reading: ", "Reading all skenario 1 data..");

        List<Skenario1> skenario1 = db.getAllSkenario1();
        ArrayList<String> listDataS1 = new ArrayList<String>();

        List<S1HasilEnkripsi> s1hasilenkripsi = db.getAllS1hasilenkripsi();
        ArrayList<String> listDataS1hasilenkripsi = new ArrayList<String>();

        final List<Skenario1> _skenario1 = skenario1;
        final ArrayList<String> _listDataS1 = listDataS1;
        final DatabaseHandler _db = db;
        btnEnkripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new Thread(new Runnable() {
                    public void run() {
                        for (Skenario1 sn1 : _skenario1) {
                            final long startTime = System.nanoTime();
                            //enkripsi
                            String hasilEnkripsi = AES.enkripsi(sn1.getID(), sn1.getTeks(), sn1.getKunci());
                            //masukkkan hasil enkripsi ke tabel s1hasilenkripsi
                            //DataPengujian dapeng = new DataPengujian();
                            //dapeng.dataPengujianS1HasilEnkripsi(_db, sn1.getID(), hasilEnkripsi, sn1.getKunci());
                            String log = "Id: " + sn1.getID() + " ,Bytes: " + sn1.getBytes() + " ,Teks: " + sn1.getTeks() + " ,Kunci: " + sn1.getKunci() + " ,Teks terenkripsi: " + hasilEnkripsi;
                            // Writing data to log
                            Log.d("Data: ", log);
                            _listDataS1.add(sn1.getTeks()); //this adds an element to the list.
                        }
                    }
                }).start();

            }
        });

        final List<S1HasilEnkripsi> _s1hasilenkripsi = s1hasilenkripsi;
        final ArrayList<String> _listDataS1hasilenkripsi = listDataS1hasilenkripsi;
        btnDekripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new Thread(new Runnable() {
                    public void run() {
                        for (S1HasilEnkripsi sn1 : _s1hasilenkripsi) {
                            final long startTime = System.nanoTime();
                            //--dekripsi
                            String hasilDekripsi = AES.dekripsi(sn1.getTeksEnkripsi(), sn1.getKunciEnkripsi());
                            //--enkripsi--
                            String log = "_xy Id: " + sn1.getID() + " ,Id Skenario 1: " + sn1.getIDSkenario1() + " ,Teks Enkripsi: " + sn1.getTeksEnkripsi() + " ,Kunci Enkripsi: " + sn1.getKunciEnkripsi() + " ,Teks Dekripsi: " + hasilDekripsi;
                            // Writing Contacts to log
                            Log.d("Data: ", log);
                            _listDataS1hasilenkripsi.add(sn1.getTeksEnkripsi()); //this adds an element to the list.
                        }
                    }
                }).start();

            }
        });

        btnClearDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

            }
        });

    }

}
