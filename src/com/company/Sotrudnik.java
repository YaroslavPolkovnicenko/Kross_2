package com.company;

import java.io.Serializable;

public abstract class Sotrudnik implements Serializable {

    protected String Name;
    protected String Family;
    protected String Dolznost;
    protected int Vozrast;
    protected int Staz;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getFamily() {
        return this.Family;
    }

    public void setFamily(String family) {
        this.Family = family;
    }

    public String getDolznost() {
        return Dolznost;
    }

    public void setDolznost(String dolznost) {
        this.Dolznost = dolznost;
    }

    public int getVozrast() {
        return Vozrast;
    }

    public void setVozrast(int vozrast) {
        this.Vozrast = vozrast;
    }

    public int getStaz() {
        return Staz;
    }

    public void setStaz(int staz) {
        this.Staz = staz;
    }

    public String getAll(){ return Name + " " + Family + " " + Dolznost + " " + Vozrast + " " + Staz; }

}
