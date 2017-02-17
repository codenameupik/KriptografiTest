package com.cybercaterpillar.kriptografiTest;

import android.util.Log;

import database.DatabaseHandler;
import database.S1HasilEnkripsi;
import database.S1HasilEnkripsiBlowfish;
import database.S2HasilEnkripsi;
import database.S2HasilEnkripsiBlowfish;
import database.S3HasilEnkripsi;
import database.S3HasilEnkripsiBlowfish;
import database.Skenario1;
import database.Skenario2;
import database.Skenario3;

public class DataPengujian {

    //data skenario 1
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
    //data skenario 2
    String dataTeksSkenario2[] =
            {
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
                    "Lorem ipsu",
            };
    String dataKunciSkenario2[] =
            {
                    "lVJ7",
                    "I04vU",
                    "GsWyG1",
                    "4C3004u",
                    "SbcIr15y",
                    "71Z1ttI9G",
                    "7D68RFmvRZ",
                    "UVFax0Ih0l3",
                    "QYw7DW13yk6h",
                    "3JN5S2OmVyh7u",
                    "796bLG9GH9y8ik",
                    "qjd60YI40Gpl8Kj",
                    "5UcW6J2d379i8UtR",
                    "Ae8Dy3GrLE78uy6gh",
                    "3RT1u59NFWt7TF56jK",
                    "mo2cUo8jCN2s7o9ZNCU",
                    "K6b7jaF50sFTViBpVzRC",
                    "Vg0AR265Z0uPTFBc4Wt0f",
                    "WiA86AEZ2jmE8cXz2db2gG",
                    "Ny8722LljT44Sw33b64OjH6",
                    "5Lbkaw4gRAg3XrrAwrvPRnAs",
                    "NPKBEdBry8CrnDQqG3ggR8vPh",
                    "kvbbaXsYcsAvvUqA7cSTHUz2A9",
                    "Jq3vv47GF4c7GDVsSAG7BdUgFAt",
                    "X8ZrtDe6NeZUW3JmpVnCnkSBeR7d",
                    "Ldpq8hJmZuvPcxcQr7Dzy7fCqgeJr",
                    "adVGdZU36JsbMDdfxY7aAn22Uz5Btj",
                    "EbjBQqpDXTbcahPXtuB28WJdM3RAxuQ",
                    "HWuyACfR3rzaH8vWDVfwUmjZ95Ead6f6",
                    "uBa4Gaj9qdqq2kBj7Ac3RsgYgLSVGBK37",
                    "rrPAfTjLGbgaCuzRWcCSYDzGf9SbzmjQet",
                    "pj7EAAhMmWueJ3CWzNzxVhgT2pHQbePEGFf",
                    "baQFsek7VTB7KqJ3tMuUgAWEukY8KtBc2v2e",
                    "x7j33SYfL8vsFjXwSyZPJBhUKbD2QVxbRNV89",
                    "VBDKQbzh9STGunhNNcgTvEhLgzxzxkXbargCxU",
                    "9FeUuREyZfgePLnSCx6fxge6RhvApLpH8E7pEDA",
                    "TbyFEw2tSTjZ6xJFjAAaqnfEFb5eYeLaScjJ4utX",
                    "A2FmgD8FcSxMWRb9G5qHTH8Mn8Qae8AehKtSaFVME",
                    "aZ6LU9tnHsQvrptcRCE6e3hwT2238VxpH6V7A8RBzD",
                    "yL6r9JncGCaNnWQvT7NCwR7w6ADE2m3szM3zvY6cGcw",
                    "c8yvdEuFuSPMXYyD2XAdFvmrpR7hUxFg8ahREAsKRWBd",
                    "7NnhtzzECvE2ArAK5zYuL9PkyWVYqSzUx95S3jd3tVpVL",
                    "5v5gRayGeVK885vDWHpzrcqUf4McJQsu9AGHF6gt5BY75W",
                    "FcsFrx2UNZrQq7ah8kfWXC4PmzKcA4BYzDf8mJVF8ZB4vuY",
                    "Q7QWdyV2xHY8XPZaKg96uN9PYu5nF5tprP5WXZy4et4RHnJt",
                    "DfnChkkSvJcgL2LdazEXfe2PHjfUNnPuUKGCm3NQ3uTMMLFbG",
                    "m3eEBNPA7dSvaumcajH2x8HFfRjkmcTnafQppsgqRwBdKHnkWq",
                    "b6y79u6xBSXWQswXewtXE5zsxKSxWcbVhp83cfZJZPqPtL7W72F",
                    "g2T6TE9dHy28nRnyu8fFK7BEEpK7zCWESrqjkm7wUB7aVkNTAESw",
                    "q5LtqXWzDS8SdK4vkWNAAQCSvC9WaLryP9yF73VznnNqkteEUGSqE",
                    "j7YyhFWzGS6SdK3vgTRDAQDTwF5BaLtyH7jG52GhbhHstyaAIHSkEB",
                    "Bh935YxXFw3yJ5NPga7v8gungyDq2BpcdAXzNCgGkAgxZufAPDg2XZA",
                    "jsnrK4gNzVhsu7kW9H9DmMrSnc9gcpLTCUG228b5k55eawPGFLgdMBzg"
            };

    //data skenario 3
    String dataTeksSkenario3[] =
            {
                    "Lorem ipsu",
                    "Lorem ipsum dolor si",
                    "Lorem ipsum dolor sit amet, co",
                    "Lorem ipsu",
                    "Lorem ipsum dolor si",
                    "Lorem ipsum dolor sit amet, co",
                    "Lorem ipsu",
                    "Lorem ipsum dolor si",
                    "Lorem ipsum dolor sit amet, co"
            };
    String dataKunciSkenario3[] =
            {
                    "SbcIr15y",
                    "5UcW6J2d379i8UtR",
                    "HWuyACfR3rzaH8vWDVfwUmjZ95Ead6f6",
                    "SbcIr15y",
                    "5UcW6J2d379i8UtR",
                    "HWuyACfR3rzaH8vWDVfwUmjZ95Ead6f6",
                    "SbcIr15y",
                    "5UcW6J2d379i8UtR",
                    "HWuyACfR3rzaH8vWDVfwUmjZ95Ead6f6"
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
        Log.d("Insert: ", "Inserting data skenario 1 ..");
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

    public void dataPengujianSkenario2(DatabaseHandler db) {
        /**
         * CRUD Operations
         * */
        //wipe all data clean
        db.deleteAllSkenario2();
        db.deleteAllS2hasilenkripsi();
        db.deleteAllS2hasilenkripsiblowfish();
        // Inserting skenario 2 data
        Log.d("Insert: ", "Inserting data skenario 2 ..");
        for(int i=4, j=0;i<=56;i++, j++){
            db.addSkenario2(new Skenario2(i, dataTeksSkenario2[j], dataKunciSkenario2[j]));
        }
        for(int j=0;j<=52;j++){
            db.addS2HasilEnkripsi(new S2HasilEnkripsi(j + 1, AES.enkripsi(j + 1, dataTeksSkenario2[j], dataKunciSkenario2[j]), dataKunciSkenario2[j]));
        }
        for(int j=0;j<=52;j++){
            db.addS2HasilEnkripsiBlowfish(new S2HasilEnkripsiBlowfish(j + 1, Blowfish.enkripsi(j + 1, dataTeksSkenario2[j], dataKunciSkenario2[j]), dataKunciSkenario2[j]));
        }

    }

    public void dataPengujianSkenario3(DatabaseHandler db) {
        /**
         * CRUD Operations
         * */
        //wipe all data clean
        db.deleteAllSkenario3();
        db.deleteAllS3hasilenkripsi();
        db.deleteAllS3hasilenkripsiblowfish();
        // Inserting skenario 3 data
        Log.d("Insert: ", "Inserting data skenario 3 ..");
        for(int j=0;j<=8;j++){
            int i = 10;
            if(j>=3&&j<=5){
                i = 20;
            }else if(j>5) i = 30;
            db.addSkenario3(new Skenario3(i, dataTeksSkenario3[j], dataKunciSkenario3[j]));
        }
        for(int j=0;j<=8;j++){
            db.addS3HasilEnkripsi(new S3HasilEnkripsi(j + 1, AES.enkripsi(j + 1, dataTeksSkenario3[j], dataKunciSkenario3[j]), dataKunciSkenario3[j]));
        }
        for(int j=0;j<=8;j++){
            db.addS3HasilEnkripsiBlowfish(new S3HasilEnkripsiBlowfish(j + 1, Blowfish.enkripsi(j + 1, dataTeksSkenario3[j], dataKunciSkenario3[j]), dataKunciSkenario3[j]));
        }

    }


    public void dataPengujianS1HasilEnkripsi(DatabaseHandler db, int idskenario1, String hasilEnkripsi, String kunciEnkripsi) {
        db.addS1HasilEnkripsi(new S1HasilEnkripsi(idskenario1, hasilEnkripsi, kunciEnkripsi));
    }

}
