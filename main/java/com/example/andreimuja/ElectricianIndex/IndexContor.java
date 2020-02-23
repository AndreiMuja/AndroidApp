package com.example.andreimuja.electricianIndex;

import java.util.Calendar;

enum TipInregistrare{
    citit,estimat
}
public class IndexContor {
    String nume;
    Calendar data;
    TipInregistrare tipInregistrare;
    int nrKilowati;

    public IndexContor(){ }

    public IndexContor(String nume, int nrKilowati, Calendar data, TipInregistrare tipInregistrare) {
        this.nume = nume;
        this.nrKilowati = nrKilowati;
        this.data = data;
        this.tipInregistrare = tipInregistrare;
    }

    public Calendar getData() {
        return data;
    }

    public String getNume() {
        return nume;
    }

    public TipInregistrare getTipInregistrare() {
        return tipInregistrare;
    }

    public int getNrKilowati() {
        return nrKilowati;
    }

    public void setNrKilowati(int nrKilowati) {
        this.nrKilowati = nrKilowati;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public void setTipInregistrare(TipInregistrare tipInregistrare) {
        this.tipInregistrare = tipInregistrare;
    }
}
