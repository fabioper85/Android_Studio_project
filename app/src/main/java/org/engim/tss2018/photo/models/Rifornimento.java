package org.engim.tss2018.photo.models;

/**
 * Created by svilupposw on 27/03/18.
 */

public class Rifornimento {

    private String nomeBenzinaio;
    private double importo;

    public Rifornimento(String nomeBenzinaio, double importo) {
        this.nomeBenzinaio = nomeBenzinaio;
        this.importo = importo;
    }

    public Rifornimento(){

    }

    public String getNomeBenzinaio() {
        return nomeBenzinaio;
    }

    public void setNomeBenzinaio(String nomeBenzinaio) {
        this.nomeBenzinaio = nomeBenzinaio;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }
}
