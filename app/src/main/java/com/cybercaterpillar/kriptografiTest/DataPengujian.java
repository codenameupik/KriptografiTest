package com.cybercaterpillar.kriptografiTest;

import android.util.Log;

import database.DatabaseHandler;
import database.S1HasilEnkripsi;
import database.S1HasilEnkripsiBlowfish;
import database.Skenario1;

public class DataPengujian {

    String dataTeks[] =
            {
                    "Lorem",
                    "Lorem ipsu",
                    "Lorem ipsum dol",
                    "Lorem ipsum dolor si",
                    "Lorem ipsum dolor sit ame",
                    "Lorem ipsum dolor sit amet, co",
                    "Lorem ipsum dolor sit amet, consect",
                    "Lorem ipsum dolor sit amet, consecteturs",
                    "Lorem ipsum dolor sit amet, consecteturs adip",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscin",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing eli",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volu",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dign",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luct",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. P",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellen",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos magn",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos magna, al",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos magna, aliquam",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos magna, aliquam a ni",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos magna, aliquam a nisi ve",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos magna, aliquam a nisi vel, so",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos magna, aliquam a nisi vel, sodales",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos magna, aliquam a nisi vel, sodales vari",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos magna, aliquam a nisi vel, sodales varius li",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos magna, aliquam a nisi vel, sodales varius liberos",
                    "Lorem ipsum dolor sit amet, consecteturs adipiscing elit. In volutpats dignissim luctus. Pellentesqu leos magna, aliquam a nisi vel, sodales varius liberos nulz"
            };
    String dataKunci[] =
            {
                    "0xoxVgHp9R", "Ylj1fZx2Cb", "1mMeS0ZRH6", "KQL8W524ZA", "44js8ft6rs", "EnB1js1aC1", "U7z4wpyJwL", "V3FJT0PPK7", "zk73KClTXc",
                    "XfS1uJ98P1", "7gn8C10mDT", "2ryPJ691T8", "8tXvHM40i7", "j8Fi378MSd", "sRlL6b95v0", "lAbV98ORau", "G6q2SnrJ1m", "2k7r2HI685",
                    "q4Kpt5zNbR", "n2HTRtarFp", "1zoEB7N144", "bignHkDL9H", "568ThbHKK1", "1CvV2qAn8u", "u27ylf8F0s", "F72FOQI42f", "JOa08LlvQd",
                    "p6693jM8RL", "H50gIW2V46", "T2u8Oy1Ot8", "f90QNse5Sm", "7VrtQT1UaK"
            };

    public void dataPengujianSkenario1(DatabaseHandler db) {
        /**
         * CRUD Operations
         * */
        //wipe all data clean
        db.deleteAllSkenario1();
        db.deleteAllS1hasilenkripsi();
        db.deleteAllS1hasilenkripsiblowfish();
        // Inserting skenario 1 data
        Log.d("Insert: ", "Inserting ..");
        for(int i=5, j=0;i<=160;i+=5, j++){
            db.addSkenario1(new Skenario1(i, dataTeks[j], dataKunci[j]));
        }
        for(int j=0;j<=31;j++){
            db.addS1HasilEnkripsi(new S1HasilEnkripsi(j + 1, AES.enkripsi(j + 1, dataTeks[j], dataKunci[j]), dataKunci[j]));
        }
        for(int j=0;j<=31;j++){
            db.addS1HasilEnkripsiBlowfish(new S1HasilEnkripsiBlowfish(j + 1, Blowfish.enkripsi(j + 1, dataTeks[j], dataKunci[j]), dataKunci[j]));
        }

    }

    public void dataPengujianS1HasilEnkripsi(DatabaseHandler db, int idskenario1, String hasilEnkripsi, String kunciEnkripsi) {
        db.addS1HasilEnkripsi(new S1HasilEnkripsi(idskenario1, hasilEnkripsi, kunciEnkripsi));
    }

}
