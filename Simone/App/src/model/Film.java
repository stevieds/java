package model;

import java.util.ArrayList;

public class Film implements Methods {

    private String iTitle;
    private String oTitle;
    private MyTime length;
    private ArrayList<Anello> anelli;
    private ArrayList<Coppia> persDopp;
    private Status status;
    private String filmId;


    //Costruttore
    public Film () {}

    public Film(String oTitle, String iTitle, MyTime length) {
        this.oTitle = oTitle;
        this.iTitle = iTitle;
        this.length = length;
        this.persDopp = new ArrayList<Coppia>();
        this.anelli = new ArrayList<Anello>();
        this.status = Status.NEW;
    }

    public Film(String oTitle, String iTitle, MyTime length, Status status) {
        this.oTitle = oTitle;
        this.iTitle = iTitle;
        this.length = length;
        this.persDopp = new ArrayList<Coppia>();
        this.anelli = new ArrayList<Anello>();
        this.status = status;
    }

    // Retrieve Italian title
    public String getiTitle() {
        return iTitle;
    }

    // Change Italian title
    public void setiTitle(String iTitle) {
        this.iTitle = iTitle;
    }

    // Retrieve original title
    public String getoTitle() {
        return oTitle;
    }

    // Change italian title
    public void setoTitle(String oTitle) {
        this.oTitle = oTitle;
    }

    // Get length in milliseconds
    public long lengthInMilli() {
        return this.length.milliSec();
    }

    // Get length in String
    public String lengthToString() {
        return length.toString();
    }

    // Get Status
    public String getStatus() {
        return this.status.name();
    }

    // Change length
    public void setLength(String newLength) {
        this.length.setMyTime(newLength);
    }




    // Retrieve list of abbinamenti
    public ArrayList<Coppia> getCoppie() {
        return this.persDopp;
    }


    // Retrieve list of anelli
    public ArrayList<Anello> getAnelli() {
        return this.anelli;
        /*
        String answer = "";
        int i = 0;
        for (Anello a : anelli) {
            answer += i + ":\n" + a.toString();
            i++;
        }
        System.out.println(answer);

         */
    }

    // Add new character
    public void setPersonaggio(String nomePers) {
        Personaggio pers = new Personaggio(nomePers);
        persDopp.add(new Coppia(pers));
    }

    public void setPersonaggio(Coppia coppia) {
        persDopp.add(coppia);
    }



    // Add doppiatore to personaggio
    public void setDoppiatore(Doppiatore dopp, Personaggio pers) {
        for (Coppia coppia : this.persDopp) {
            if (pers.getName().equals(coppia.getName())) {
                coppia.setDopp(dopp);
            }
        }
    }

    /*
    // Replace a doppiatore with a new one
    public void replaceInCoppia (Doppiatore dopp) {
        for (Coppia coppia : this.persDopp) {
            if (dopp.getName().equals(coppia.getName(dopp))) {
                coppia.setDopp(dopp);
            }
        }
    }

     */

    // Amend character
    public void replaceInCoppia(Personaggio pers) {
        for (Coppia coppia : this.persDopp) {
            if (pers.getName().equals(coppia.getName())) {
                coppia.setPers(pers);
            }
        }
    }

    // Add couple
    public void addCouple(Coppia couple) {
        this.persDopp.add(couple);
    }


    // Check the status
    public String checkCompleted() {
        String answer = "";
        if (this.status == Status.NEW) {
            answer = "model.Film da doppiare";
        } else if (this.status == Status.WIP) {
            answer = "Il film è in lavorazione";
        } else if (this.status == Status.DONE) {
            answer = "Il doppiaggio del film è stato terminato";
        }
        return answer;
    }

    // Change the status
    public void changeStatus(Status newStatus) {
        this.status = newStatus;
    }


    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String id) {
        this.filmId = id;
    }

    /*
    // Check if a character exists in model.Film
    public boolean checkPers (String pers) {
        boolean answer = false;
        for (model.Coppia p : this.personaggi) {
            if (p.getName().equals(pers)) {
                answer = true;
            }
        }
        return answer;
    }

    // Add a new couple to a subRing
    public String addCoupleToSub (model.Coppia pers, model.Doppiatore dopp, model.SubAnello sub) {
        if (this.checkPers(pers.getName())==true) {
            sub.addCoppia(pers, dopp);
            return "OK";
        } else {
            return "NoooooO";
        }
    }

     */

    @Override
    public String toString() {
        return
                this.oTitle;
    }
}


