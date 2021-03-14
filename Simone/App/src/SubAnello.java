import java.time.LocalTime;
import java.util.HashMap;

public class SubAnello extends Anello {
    private LocalTime timeFrameStart;
    private LocalTime timeFrameEnd;
    private HashMap <Personaggio, Doppiatore> coppie;
    private Status status;

    public SubAnello(MyTime start, MyTime end) {
        super(start, end);
        this.coppie = new HashMap<Personaggio, Doppiatore>();
        status=Status.New;
    }

    public SubAnello(String stringStart, String stringEnd) {
        super(stringStart, stringEnd);
        this.coppie = new HashMap<Personaggio, Doppiatore>();
        status=Status.New;
    }


}
