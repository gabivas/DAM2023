package ro.ase.grupa1095;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "masini")
public class Masina {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String marca;
    private String model;
    private int nrCaiPutere;

    public Masina(String marca, String model, int nrCaiPutere) {
        this.marca = marca;
        this.model = model;
        this.nrCaiPutere = nrCaiPutere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNrCaiPutere() {
        return nrCaiPutere;
    }

    public void setNrCaiPutere(int nrCaiPutere) {
        this.nrCaiPutere = nrCaiPutere;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", nrCaiPutere=" + nrCaiPutere +
                '}';
    }
}
