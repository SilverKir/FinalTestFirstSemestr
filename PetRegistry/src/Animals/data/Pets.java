package data;

import java.util.Date;

public class Pets extends Animals{
    public String owner;

    public static <T extends Pets> T create( T instance, String name, Date birthDate, String commands, String owner) {
        instance.name=name;
        instance.birthDate=birthDate;
        instance.setCommands(commands);
        instance.owner=owner;
        return  instance;
    }

    protected Pets() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String toString() {
        return super.toString() + " Владелец:"
                + owner +"\n";
    }
}
