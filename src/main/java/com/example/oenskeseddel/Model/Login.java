package com.example.oenskeseddel.Model;

public class Login {
    private String brugernavn;

    public Login(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public Login() {

    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }
}
