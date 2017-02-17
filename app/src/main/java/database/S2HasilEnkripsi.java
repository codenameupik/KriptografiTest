package database;

public class S2HasilEnkripsi {
    //private variables
    int _id;
    int _idskenario2;
    String _teksenkripsi;
    String _kunci;

    // Empty constructor
    public S2HasilEnkripsi(){

    }
    // constructor
    public S2HasilEnkripsi(int id, int idskenario2, String teksenkripsi, String kunci){
        this._id = id;
        this._idskenario2 =  idskenario2;
        this._teksenkripsi = teksenkripsi;
        this._kunci = kunci;
    }

    // constructor
    public S2HasilEnkripsi(int idskenario2, String teksenkripsi, String kunci){
        this._idskenario2 = idskenario2;
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
    public int getIDSkenario2(){
        return this._idskenario2;
    }

    // setting id
    public void setIDSkenario2(int idskenario2){
        this._idskenario2 = idskenario2;
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
