package com.example.oenskeseddel.Model;

public class Ønske {
    private int id;

    private String navn;
    private String beskrivelse;
    private String link;
    private int bruger_id;

    public Ønske() {

    }

    public Ønske(int id,String navn, String beskrivelse, String link, int bruger_id) {
        this.id=id;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.link = link;
        this.bruger_id = bruger_id;
    }
    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }
  public void setId(int id) {
      this.id=id;
  }
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getBruger_id() {
        return bruger_id;
    }





    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setBruger_id(int bruger_id) {
        this.bruger_id = bruger_id;
    }
}
