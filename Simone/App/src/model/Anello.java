package model;

import java.util.ArrayList;

public class Anello {
    private MyTime start;
    private MyTime end;
    private ArrayList<SubAnello> subAnelli;
    private Status status;
    private Coppia persDopp;
    private int righe;
    private String anelloId;

    //vuoto
    public Anello () {}



    // Costruttore con model.MyTime
    public Anello(MyTime start, MyTime end) {
        this.start = start;
        this.end = end;
        this.status = Status.NEW;
    }

    // Costruttore con model.MyTime
    public Anello(MyTime start, MyTime end, int righe) {
        this.start = start;
        this.end = end;
        this.status = Status.NEW;
        this.righe = righe;
    }

    // Costruttore con String
    public Anello(String stringStart, String stringEnd) {
        this.start = new MyTime(stringStart);
        this.end = new MyTime(stringEnd);
        this.status = Status.NEW;
    }

    // Costruttore con String e Status
    public Anello(String stringStart, String stringEnd, Status status) {
        this.start = new MyTime(stringStart);
        this.end = new MyTime(stringEnd);
        this.status = status;
    }

    public MyTime getStart() {
        return start;
    }

    public void setStart(MyTime start) {
        this.start = start;
    }

    public MyTime getEnd() {
        return end;
    }

    public void setEnd(MyTime end) {
        this.end = end;
    }

    // Restituisce durata in model.MyTime
    public MyTime length () {
        long milli = this.end.milliSec() - this.start.milliSec();
        return MyTime.milliConvert(milli);
    }

    // Restituisce la durata in millisecondi
    public long lengthInMilli () {
        long milli = this.end.milliSec() - this.start.milliSec();
        return milli;
    }

    // Check the total length of all of the subAnelli
    public long durataTotSubAnelli () {
        long durata = 0;
        for (SubAnello sub : subAnelli) {
            durata+= sub.lengthInMilli();
        }
        return durata;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAnelloId() {
        return anelloId;
    }

    public void setAnelloId(String anelloId) {
        this.anelloId = anelloId;
    }

    // Get Status
    public String getStatus() {
        return this.status.name();
    }


    // Add model.SubAnello with Strings
    public void addSubAnello(String start, String end) {
        MyTime s = new MyTime(start);
        MyTime e = new MyTime(end);

        if (this.lengthInMilli()>=(this.durataTotSubAnelli()+ (e.milliSec() - s.milliSec()))) {
            this.subAnelli.add(new SubAnello (start, end));
            long difference = this.lengthInMilli() - this.durataTotSubAnelli();
            MyTime n = MyTime.milliConvert(difference);
            System.out.println("L'anello è stato aggiunto correttamente. La durata rimanente è di: "+n.toString());
        }
        else {
            long difference = ((this.durataTotSubAnelli()+ (e.milliSec() - s.milliSec()) - this.lengthInMilli()));
            MyTime n = MyTime.milliConvert(difference);
            System.out.println("Errore. L'anello eccede la durata totale del film di "+n.toString());
        }
    }


    public Coppia getCouple () {
        return persDopp;
    }

    public void addCouple (Coppia persDopp) {
        this.persDopp = persDopp;
    }

    public Coppia getPersDopp() {
        return persDopp;
    }



    public int getRighe() {
        return righe;
    }

    public void setRighe(int righe) {
        this.righe = righe;
    }

    @Override
    public String toString() {
        return
                "Inizio: " + start + " " +
                        " - " +
                "Fine: " + end;

    }
}

