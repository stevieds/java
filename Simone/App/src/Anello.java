import java.util.ArrayList;

public class Anello {
    private MyTime start;
    private MyTime end;
    private ArrayList<SubAnello> subAnelli;
    private Status status;

    public Anello(MyTime start, MyTime end) {
        this.start = start;
        this.end = end;
        this.status = Status.New;
    }

    public Anello(String stringStart, String stringEnd) {
        this.start = new MyTime(stringStart);
        this.end = new MyTime(stringEnd);
        this.status = Status.New;
    }


    public MyTime length () {
        long milli = this.end.milliSec() - this.start.milliSec();
        return MyTime.milliConvert(milli);
    }

    public long lengthInMilli () {
        long milli = this.end.milliSec() - this.start.milliSec();
        return milli;

    }

    @Override
    public String toString() {
        String compl="";
        if (this.status==Status.Wip || this.status == Status.New) {
            compl = "No";
        } else if (this.status==Status.Done) {
            compl = "Si";
        }
        return
                "Inizio: " + start + "\n" +
                "Fine: " + end +  "\n" +
                ", subAnelli: " + subAnelli + "\n"+
                "Completato: " + compl +
                "\n";
    }
}

