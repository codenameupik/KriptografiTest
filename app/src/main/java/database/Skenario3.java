package database;

public class Skenario3 {
    //private variables
    int _id;
    int _bytes;
    String _teks;
    String _kunci;

    // Empty constructor
    public Skenario3(){

    }
    // constructor
    public Skenario3(int id, int bytes, String teks, String kunci){
        this._id = id;
        this._bytes = bytes;
        this._teks = teks;
        this._kunci = kunci;
    }

    // constructor
    public Skenario3(int bytes, String teks, String kunci){
        this._bytes = bytes;
        this._teks = teks;
        this._kunci = kunci;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting bytes
    public int getBytes(){
        return this._bytes;
    }

    // setting bytes
    public void setBytes(int bytes){
        this._bytes = bytes;
    }

    // getting teks
    public String getTeks(){
        return this._teks;
    }

    // setting teks
    public void setTeks(String teks){
        this._teks = teks;
    }

    // getting kunci
    public String getKunci(){
        return this._kunci;
    }

    // setting kunci
    public void setKunci(String kunci){
        this._kunci = kunci;
    }

}
