package com.cybercaterpillar.kriptografiTest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import database.DatabaseHandler;
import database.S1HasilEnkripsiBlowfish;
import database.S2HasilEnkripsiBlowfish;
import database.S3HasilEnkripsiBlowfish;
import database.Skenario1;
import database.Skenario2;
import database.Skenario3;

public class UjiBlowfish extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uji);
        final Button btnEnkripsi = (Button) findViewById(R.id.btnEnkripsi);
        final Button btnDekripsi = (Button) findViewById(R.id.btnDekripsi);
        final Button btnEnkripsi2 = (Button) findViewById(R.id.btnEnkripsi2);
        final Button btnDekripsi2 = (Button) findViewById(R.id.btnDekripsi2);
        final Button btnEnkripsi3 = (Button) findViewById(R.id.btnEnkripsi3);
        final Button btnDekripsi3 = (Button) findViewById(R.id.btnDekripsi3);
        final Button btnClearDB = (Button) findViewById(R.id.btnClearDB);
        DatabaseHandler db = new DatabaseHandler(this);
        //db.deleteAllSkenario1();
       //db.deleteAllS1hasilenkripsi();

        // Reading all skenario 1
        Log.d("Reading: ", "Reading all skenario 1 data..");

        List<Skenario1> skenario1 = db.getAllSkenario1();
        ArrayList<String> listDataS1 = new ArrayList<String>();
        List<S1HasilEnkripsiBlowfish> s1hasilenkripsi = db.getAllS1hasilenkripsiBlowfish();
        ArrayList<String> listDataS1hasilenkripsi = new ArrayList<String>();
        final List<Skenario1> _skenario1 = skenario1;
        final ArrayList<String> _listDataS1 = listDataS1;

        // Reading all skenario 2
        Log.d("Reading: ", "Reading all skenario 2 data..");

        List<Skenario2> skenario2 = db.getAllSkenario2();
        ArrayList<String> listDataS2 = new ArrayList<String>();
        List<S2HasilEnkripsiBlowfish> s2hasilenkripsi = db.getAllS2hasilenkripsiBlowfish();
        ArrayList<String> listDataS2hasilenkripsi = new ArrayList<String>();
        final List<Skenario2> _skenario2 = skenario2;
        final ArrayList<String> _listDataS2 = listDataS2;

        // Reading all skenario 3
        Log.d("Reading: ", "Reading all skenario 3 data..");

        List<Skenario3> skenario3 = db.getAllSkenario3();
        ArrayList<String> listDataS3 = new ArrayList<String>();
        List<S3HasilEnkripsiBlowfish> s3hasilenkripsi = db.getAllS3hasilenkripsiBlowfish();
        ArrayList<String> listDataS3hasilenkripsi = new ArrayList<String>();
        final List<Skenario3> _skenario3 = skenario3;
        final ArrayList<String> _listDataS3 = listDataS3;

        final DatabaseHandler _db = db;
        //Skenario 1
        btnEnkripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new Thread(new Runnable() {
                    public void run() {
                        for (Skenario1 sn1 : _skenario1) {
                            //final long startTime = System.nanoTime();
                            //enkirpsi
                            String hasilEnkripsi = Blowfish.enkripsi(sn1.getID(), sn1.getTeks(), sn1.getKunci());
                            //masukkkan hasil enkripsi ke tabel s1hasilenkripsi
                            //DataPengujian dapeng = new DataPengujian();
                            //dapeng.dataPengujianS1HasilEnkripsi(_db, sn1.getID(), hasilEnkripsi, sn1.getKunci());
                            String log = "_blowen1 Id: " + sn1.getID() + " ,Bytes: " + sn1.getBytes() + " ,Teks: " + sn1.getTeks() + " ,Kunci: " + sn1.getKunci() + " ,Teks terenkripsi(Blowfish): " + hasilEnkripsi;
                            // Writing data to log
                            Log.d("Data: ", log);
                            _listDataS1.add(sn1.getTeks()); //this adds an element to the list.
                        }
                    }
                }).start();

            }
        });

        final List<S1HasilEnkripsiBlowfish> _s1hasilenkripsi = s1hasilenkripsi;
        final ArrayList<String> _listDataS1hasilenkripsi = listDataS1hasilenkripsi;
        btnDekripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new Thread(new Runnable() {
                    public void run() {
                        for (S1HasilEnkripsiBlowfish sn1 : _s1hasilenkripsi) {
                            //final long startTime = System.nanoTime();
                            //--dekripsi
                            String hasilDekripsi = Blowfish.dekripsi(sn1.getTeksEnkripsi(), sn1.getKunciEnkripsi());
                            //--enkripsi--
                            String log = "_blowde1 Id: " + sn1.getID() + " ,Id Skenario 1: " + sn1.getIDSkenario1() + " ,Teks Enkripsi: " + sn1.getTeksEnkripsi() + " ,Kunci Enkripsi: " + sn1.getKunciEnkripsi() + " ,Teks Dekripsi: " + hasilDekripsi;
                            // Writing Contacts to log
                            Log.d("Data: ", log);
                            _listDataS1hasilenkripsi.add(sn1.getTeksEnkripsi()); //this adds an element to the list.
                        }
                    }
                }).start();

            }
        });

        //Skenario 2
        btnEnkripsi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new Thread(new Runnable() {
                    public void run() {
                        for (Skenario2 sn2 : _skenario2) {
                            //enkripsi
                            String hasilEnkripsi = Blowfish.enkripsi(sn2.getID(), sn2.getTeks(), sn2.getKunci());
                            //masukkkan hasil enkripsi ke tabel s1hasilenkripsi
                            String log = "_blowen2 Id: " + sn2.getID() + " ,Bytes: " + sn2.getBytes() + " ,Teks: " + sn2.getTeks() + " ,Kunci: " + sn2.getKunci() + " ,Teks terenkripsi(Blowfish): " + hasilEnkripsi;
                            // Writing data to log
                            Log.d("Data: ", log);
                            _listDataS2.add(sn2.getTeks()); //this adds an element to the list.
                        }
                    }
                }).start();

            }
        });

        final List<S2HasilEnkripsiBlowfish> _s2hasilenkripsi = s2hasilenkripsi;
        final ArrayList<String> _listDataS2hasilenkripsi = listDataS2hasilenkripsi;
        btnDekripsi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new Thread(new Runnable() {
                    public void run() {
                        for (S2HasilEnkripsiBlowfish sn2 : _s2hasilenkripsi) {
                            //--dekripsi
                            String hasilDekripsi = Blowfish.dekripsi(sn2.getTeksEnkripsi(), sn2.getKunciEnkripsi());
                            //--enkripsi--
                            String log = "_blowde2 Id: " + sn2.getID() + " ,Id Skenario 1: " + sn2.getIDSkenario2() + " ,Teks Enkripsi: " + sn2.getTeksEnkripsi() + " ,Kunci Enkripsi: " + sn2.getKunciEnkripsi() + " ,Teks Dekripsi: " + hasilDekripsi;
                            // Writing Contacts to log
                            Log.d("Data: ", log);
                            _listDataS2hasilenkripsi.add(sn2.getTeksEnkripsi()); //this adds an element to the list.
                        }
                    }
                }).start();

            }
        });

        //Skenario 3
        btnEnkripsi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new Thread(new Runnable() {
                    public void run() {
                        for (Skenario3 sn3 : _skenario3) {
                            //final long startTime = System.nanoTime();
                            //enkirpsi
                            String hasilEnkripsi = Blowfish.enkripsi(sn3.getID(), sn3.getTeks(), sn3.getKunci());
                            //masukkkan hasil enkripsi ke tabel s1hasilenkripsi
                            //DataPengujian dapeng = new DataPengujian();
                            //dapeng.dataPengujianS1HasilEnkripsi(_db, sn1.getID(), hasilEnkripsi, sn1.getKunci());
                            String log = "_blowen3 Id: " + sn3.getID() + " ,Bytes: " + sn3.getBytes() + " ,Teks: " + sn3.getTeks() + " ,Kunci: " + sn3.getKunci() + " ,Teks terenkripsi(Blowfish): " + hasilEnkripsi;
                            // Writing data to log
                            Log.d("Data: ", log);
                            _listDataS3.add(sn3.getTeks()); //this adds an element to the list.
                        }
                    }
                }).start();

            }
        });

        final List<S3HasilEnkripsiBlowfish> _s3hasilenkripsi = s3hasilenkripsi;
        final ArrayList<String> _listDataS3hasilenkripsi = listDataS3hasilenkripsi;
        btnDekripsi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new Thread(new Runnable() {
                    public void run() {
                        for (S3HasilEnkripsiBlowfish sn3 : _s3hasilenkripsi) {
                            //final long startTime = System.nanoTime();
                            //--dekripsi
                            String hasilDekripsi = Blowfish.dekripsi(sn3.getTeksEnkripsi(), sn3.getKunciEnkripsi());
                            //--enkripsi--
                            String log = "_blowde3 Id: " + sn3.getID() + " ,Id Skenario 3: " + sn3.getIDSkenario3() + " ,Teks Enkripsi: " + sn3.getTeksEnkripsi() + " ,Kunci Enkripsi: " + sn3.getKunciEnkripsi() + " ,Teks Dekripsi: " + hasilDekripsi;
                            // Writing Contacts to log
                            Log.d("Data: ", log);
                            _listDataS3hasilenkripsi.add(sn3.getTeksEnkripsi()); //this adds an element to the list.
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
