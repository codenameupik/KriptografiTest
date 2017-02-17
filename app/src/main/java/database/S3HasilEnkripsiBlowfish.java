package database;

public class S3HasilEnkripsiBlowfish {
    //private variables
    int _id;
    int _idskenario3;
    String _teksenkripsi;
    String _kunci;

    // Empty constructor
    public S3HasilEnkripsiBlowfish(){

    }
    // constructor
    public S3HasilEnkripsiBlowfish(int id, int idskenario3, String teksenkripsi, String kunci){
        this._id = id;
        this._idskenario3 =  idskenario3;
        this._teksenkripsi = teksenkripsi;
        this._kunci = kunci;
    }

    // constructor
    public S3HasilEnkripsiBlowfish(int idskenario3, String teksenkripsi, String kunci){
        this._idskenario3 = idskenario3;
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
    public int getIDSkenario3(){
        return this._idskenario3;
    }

    // setting id
    public void setIDSkenario3(int idskenario3){
        this._idskenario3 = idskenario3;
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
