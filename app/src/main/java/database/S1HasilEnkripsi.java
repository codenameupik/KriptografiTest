package database;

public class S1HasilEnkripsi {
    //private variables
    int _id;
    int _idskenario1;
    String _teksenkripsi;
    String _kunci;

    // Empty constructor
    public S1HasilEnkripsi(){

    }
    // constructor
    public S1HasilEnkripsi(int id, int idskenario1, String teksenkripsi, String kunci){
        this._id = id;
        this._idskenario1 =  idskenario1;
        this._teksenkripsi = teksenkripsi;
        this._kunci = kunci;
    }

    // constructor
    public S1HasilEnkripsi(int idskenario1, String teksenkripsi, String kunci){
        this._idskenario1 = idskenario1;
        this._teksenkripsi = teksenkripsi;
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

    // getting ID
    public int getIDSkenario1(){
        return this._idskenario1;
    }

    // setting id
    public void setIDSkenario1(int idskenario1){
        this._idskenario1 = idskenario1;
    }

    // getting teks
    public String getTeksEnkripsi(){
        return this._teksenkripsi;
    }

    // setting teks
    public void setTeksEnkripsi(String teksenkripsi){
        this._teksenkripsi = teksenkripsi;
    }

    // getting kunci
    public String getKunciEnkripsi(){
        return this._kunci;
    }

    // setting kunci
    public void setKunciEnkripsi(String kunci){
        this._kunci = kunci;
    }

}
