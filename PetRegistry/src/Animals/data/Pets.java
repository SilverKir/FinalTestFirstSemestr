package data;

import java.util.Date;

public class Pets extends Animals{
    public String owner;

    public Pets(int id, String name, Date birthDate, String commands, String owner) {
        super(id, name, birthDate, commands);
        this.owner=owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
