package ro.ase.grupa1095;

import java.io.Serializable;

public class Produs implements Serializable {
    private long id;
    private String denumire;
    private float pret;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public Produs(long id, String denumire, float pret) {
        this.id = id;
        this.denumire = denumire;
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                '}';
    }
}
