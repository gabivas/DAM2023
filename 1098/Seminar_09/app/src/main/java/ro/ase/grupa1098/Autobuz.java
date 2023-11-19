package ro.ase.grupa1098;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "autobuze")
public class Autobuz {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String traseu;
    private String marca;
    private int nrLocuri;

    public Autobuz(String traseu, String marca, int nrLocuri) {
        this.traseu = traseu;
        this.marca = marca;
        this.nrLocuri = nrLocuri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTraseu() {
        return traseu;
    }

    public void setTraseu(String traseu) {
        this.traseu = traseu;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    @Override
    public String toString() {
        return "Autobuz{" +
                "id=" + id +
                ", traseu='" + traseu + '\'' +
                ", marca='" + marca + '\'' +
                ", nrLocuri=" + nrLocuri +
                '}';
    }
}
