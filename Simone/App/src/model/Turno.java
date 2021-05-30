package model;

import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;

public class Turno {
    Personale dir;
    Personale sound;
    ArrayList<Anello> anelli;
    MyDate giorno;
    Room sala;
    String turnoId;
    Film film;
    int righe;
    TypeTurno type;
    Coppia coppia;

    public Turno () {
        this.dir = new Personale();
        this.sound = new Personale();
        this.anelli = new ArrayList<Anello>();
        this.sala = new Room();
        this.film = new Film();
        this.coppia = new Coppia();

    }

    public Turno(Personale dir, Personale sound, MyDate giorno, Room sala, Film film,
                 TypeTurno type, Coppia coppia) {
        this.dir = dir;
        this.sound = sound;
        this.anelli = new ArrayList<Anello>();
        this.giorno = giorno;
        this.sala = sala;
        this.film = film;
        this.type = type;
        this.coppia = coppia;
    }



    public Personale getDir() {
        return dir;
    }

    public void setDir(Personale dir) {
        this.dir = dir;
    }

    public Personale getSound() {
        return sound;
    }

    public void setSound(Personale sound) {
        this.sound = sound;
    }

    public ArrayList<Anello> getAnelli() {
        return anelli;
    }

    public void setAnelli(ArrayList<Anello> anelli) {
        this.anelli = anelli;
    }

    public MyDate getGiorno() {
        return giorno;
    }

    public void setGiorno(MyDate giorno) {
        this.giorno = giorno;
    }


    public Room getSala() {
        return sala;
    }

    public void setSala(Room sala) {
        this.sala = sala;
    }

    public String getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(String turnoId) {
        this.turnoId = turnoId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getRighe() {
        return righe;
    }

    public void setRighe(int righe) {
        this.righe = righe;
    }

    public Enum getType() {
        return type;
    }

    public void setType(TypeTurno type) {
        this.type = type;
    }

    public Coppia getCoppia() {
        return coppia;
    }

    public void setCoppia(Coppia coppia) {
        this.coppia = coppia;
    }


}
