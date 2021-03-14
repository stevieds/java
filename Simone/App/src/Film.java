import java.util.ArrayList;

public class Film {

    private String iTitle;
    private String oTitle;
    private MyTime length;
    private ArrayList<Anello> anelli;
    private ArrayList<Personaggio> personaggi;
    private Status status;

    //Costruttore
    public Film(String oTitle, MyTime length) {
        this.oTitle = oTitle;
        this.length = length;
        this.personaggi = new ArrayList<Personaggio>();
        this.anelli = new ArrayList<Anello>();
        this.status = Status.New;
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

    // Change length
    public void setLength(String newLength) {
        this.length.setMyTime(newLength);
    }

    // Add anello with Obj
    public void addAnello(Anello anello) {
        if (this.lengthInMilli()>=(this.durataTotAnelli()+anello.lengthInMilli())) {
            this.anelli.add(anello);
            long difference = this.lengthInMilli() - this.durataTotAnelli();
            MyTime n = MyTime.milliConvert(difference);
            System.out.println("L'anello è stato aggiunto correttamente. La durata rimanente è di: "+n.toString());
        }
        else {
            long difference = (this.durataTotAnelli() + anello.lengthInMilli()) - this.lengthInMilli();
            MyTime n = MyTime.milliConvert(difference);
            System.out.println("Errore. L'anello eccede la durata totale del film di "+n.toString());
        }
    }

    // Add Anello with MyTime
    public void addAnello(MyTime start, MyTime end) {
        if (this.lengthInMilli()>=(this.durataTotAnelli()+ (end.milliSec() - start.milliSec()))) {
            this.anelli.add(new Anello (start, end));
            long difference = this.lengthInMilli() - this.durataTotAnelli();
            MyTime n = MyTime.milliConvert(difference);
            System.out.println("L'anello è stato aggiunto correttamente. La durata rimanente è di: "+n.toString());
        }
        else {
            long difference = ((this.durataTotAnelli()+ (end.milliSec() - start.milliSec()) - this.lengthInMilli()));
            MyTime n = MyTime.milliConvert(difference);
            System.out.println("Errore. L'anello eccede la durata totale del film di "+n.toString());
        }
    }


    // Add Anello with Strings
    public void addAnello(String start, String end) {
        MyTime s = new MyTime(start);
        MyTime e = new MyTime(end);

        if (this.lengthInMilli()>=(this.durataTotAnelli()+ (e.milliSec() - s.milliSec()))) {
            this.anelli.add(new Anello (start, end));
            long difference = this.lengthInMilli() - this.durataTotAnelli();
            MyTime n = MyTime.milliConvert(difference);
            System.out.println("L'anello è stato aggiunto correttamente. La durata rimanente è di: "+n.toString());
        }
        else {
            long difference = ((this.durataTotAnelli()+ (e.milliSec() - s.milliSec()) - this.lengthInMilli()));
            MyTime n = MyTime.milliConvert(difference);
            System.out.println("Errore. L'anello eccede la durata totale del film di "+n.toString());
        }


    }



    // Check the total length of all of the anelli
    public long durataTotAnelli () {
        long durata = 0;
        for (Anello anello : anelli) {
            durata+= anello.lengthInMilli();
        }
        return durata;
    }

    // Retrieve list of chracters
    public ArrayList<Personaggio> getPersonaggi() {
        return personaggi;
    }

    // Add new character
    public void setPersonaggi(String nomePers) {
        personaggi.add(new Personaggio (nomePers));
    }

    // Replace an existing character with a new one
    public void replacePersonaggio (String vecchio, String nuovo) {
        int index = 0;
        for (Personaggio pers : this.personaggi) {
            if (pers.getName() == vecchio) {
                index = this.personaggi.indexOf(pers);
            }
        }
        this.personaggi.set(index, new Personaggio(nuovo));
    }

    // Check the status
    public String checkCompleted() {
        String answer="";
        if (this.status == Status.New) {
            answer = "Film da doppiare";
        }  else if (this.status == Status.Wip) {
            answer = "Il film è in lavorazione";
        } else if (this.status == Status.Done) {
            answer = "Il doppiaggio del film è stato terminato";
        }
        return answer;
    }

    // Change the status
    public void changeStatus(Status newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return
                "Titolo italiano: " + iTitle + '\n' +
                "Titolo originale: '" + oTitle + '\n' +
                "Durata: " + length + '\n' +
                "Anelli: " + anelli + '\n' +
                "Personaggi: " + personaggi + '\n' +
                "Stato: " + this.checkCompleted();

    }
}


