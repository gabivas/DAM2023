package ro.ase.grupa1095;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
enum Gen {COMEDIE, DRAMA, ACTIUNE}
enum Studio {COLUMBIA, DISNEY, SONNY}
public class Film implements Serializable {
    private String denumire;
    private int rating;
    private Date dataLansare;
    private Gen gen;
    private Studio studio;

    public Film(String denumire, int rating, Date dataLansare, Gen gen, Studio studio) {
        this.denumire = denumire;
        this.rating = rating;
        this.dataLansare = dataLansare;
        this.gen = gen;
        this.studio = studio;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDataLansare() {
        return dataLansare;
    }

    public void setDataLansare(Date dataLansare) {
        this.dataLansare = dataLansare;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @Override
    public String toString() {
        return "Film{" +
                "denumire='" + denumire + '\'' +
                ", rating=" + rating +
                ", dataLansare=" + new SimpleDateFormat("dd/MM/yyyy")
                .format(dataLansare) +
                ", gen=" + gen +
                ", studio=" + studio +
                '}';
    }
}
