import java.time.MonthDay;
import java.util.ArrayList;

public class Segno {
    enum Segni {ACQUARIO, PESCI, SCORPIONE, SAGITTARIO, CAPRICORNO }
    private Segni nome;
    private MonthDay start;
    private MonthDay end;

    public Segno(Segni nome, MonthDay start, MonthDay end) {
        this.nome = nome;
        this.start = start;
        this.end = end;
    }

    public Segni getNome () {
        return this.nome;
    }

    public MonthDay getStart () {
        return this.start;
    }

    public MonthDay getEnd () {
        return this.end;
    }






        @Override
    public String toString() {
        return "Segno{" +
                "nome=" + nome +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
