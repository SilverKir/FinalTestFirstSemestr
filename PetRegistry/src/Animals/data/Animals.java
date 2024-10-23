package data;

import java.util.Date;

public class Animals {
    private int id;
     public  String name;
     public  Date birthDate;
     public String commands;

    public Animals(int id, String name, Date birthDate, String commands) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {

        this.commands =  this.commands.isEmpty()? commands: this.commands+", "+ commands;
    }
}
