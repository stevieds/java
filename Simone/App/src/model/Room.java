package model;

public class Room {


    private String name;

    public Room () {
    }

    public Room (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean compareTo (Room rm) {
        return this.name.equals(rm.getName());
    }
}
