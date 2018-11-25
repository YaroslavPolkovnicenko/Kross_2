package com.company;

public class Ohrannik extends Sotrudnik {

    private int Zarplata;

    public Ohrannik(int zarplata, String name, String family, String dolznost, int vozrast, int staz) {
        this.Zarplata = zarplata;
        this.Name = name;
        this.Family = family;
        this.Dolznost = dolznost;
        this.Vozrast = vozrast;
        this.Staz = staz;
    }

    @Override
    public String getAll() {
        return super.getAll() + " " + this.Zarplata;
    }

    @Override
    public String toString() {
        return "Охранник  " +
                ", имя=" + Name + '\'' +
                ", фамилия=" + Family + '\'' +
                ", возраст=" + Vozrast +
                ", должность=" + Dolznost + '\'' +
                ", стаж=" + Staz + '\'' +
                ", зарплата=" + Zarplata ;

    }
}
