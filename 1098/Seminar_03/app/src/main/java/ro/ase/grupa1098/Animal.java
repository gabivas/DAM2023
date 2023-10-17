package ro.ase.grupa1098;

import java.util.Date;

enum ClasaAnimal {MAMIFER, PASARE, PESTE};
enum Zona {SUD, NORD, EST, VEST}
public class Animal {
    private String specie;
    private int greutate;
    private Date dataNastere;
    ClasaAnimal clasaAnimal;
    Zona zona;

    public Animal(String specie, int greutate, Date dataNastere, ClasaAnimal clasaAnimal, Zona zona) {
        this.specie = specie;
        this.greutate = greutate;
        this.dataNastere = dataNastere;
        this.clasaAnimal = clasaAnimal;
        this.zona = zona;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public Date getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(Date dataNastere) {
        this.dataNastere = dataNastere;
    }

    public ClasaAnimal getClasaAnimal() {
        return clasaAnimal;
    }

    public void setClasaAnimal(ClasaAnimal clasaAnimal) {
        this.clasaAnimal = clasaAnimal;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "specie='" + specie + '\'' +
                ", greutate=" + greutate +
                ", dataNastere=" + dataNastere +
                ", clasaAnimal=" + clasaAnimal +
                ", zona=" + zona +
                '}';
    }
}
