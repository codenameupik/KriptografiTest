package database;

public class Skenario2 {
    //private variables
    int _id;
    String _kunci;
    String _teks;

    // Empty constructor
    public Skenario2(){

    }
    // constructor
    public Skenario2(int id, String kunci, String teks){
        this._id = id;
        this._kunci = kunci;
        this._teks = teks;
    }

    // constructor
    public Skenario2(String kunci, String teks){
        this._kunci = kunci;
        this._teks = teks;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
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
