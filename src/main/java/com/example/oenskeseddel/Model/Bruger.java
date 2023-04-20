package com.example.oenskeseddel.Model;

public class Bruger {
    private int bruger_id;
    private String fornavn;
    private String efternavn;
    private String brugernavn;
    private String bruger_email;

    public Bruger(String fornavn, String efternavn, String brugernavn, String bruger_email) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.brugernavn = brugernavn;
        this.bruger_email = bruger_email;
    }

    public Bruger() {

    }

    public int getBruger_id() {
        return bruger_id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public String getBruger_email() {
        return bruger_email;
    }

    public void setBruger_id(int bruger_id) {
        this.bruger_id = bruger_id;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public void setBruger_email(String bruger_email) {
        this.bruger_email = bruger_email;
    }
}
