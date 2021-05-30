package model;

public class Personaggio {
    private String name;
    private String id;

    //vuoto
    public Personaggio () {}

    public Personaggio (String name) {
        this.name=name;
    }

    public Personaggio (String name, String id)
    {
        this.name=name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
