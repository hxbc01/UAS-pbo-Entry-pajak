
package uas.pbo;


public class User {
  String Npwp;
  String Nama,Alamat,jenis_pajak,terbilang;

    public User(String Npwp, String Nama, String Alamat, String jenis_pajak, String terbilang) {
        this.Npwp = Npwp;
        this.Nama = Nama;
        this.Alamat = Alamat;
        this.jenis_pajak = jenis_pajak;
        this.terbilang = terbilang;
    }

    public String getNpwp() {
        return Npwp;
    }

    public void setNpwp (String Npwp) {
        this.Npwp = Npwp;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getJenis_pajak() {
        return jenis_pajak;
    }

    public void setJenis_pajak(String jenis_pajak) {
        this.jenis_pajak = jenis_pajak;
    }

    public String getTerbilang() {
        return terbilang;
    }

    public void setTerbilang(String terbilang) {
        this.terbilang = terbilang;
    }
  

   
    
}
