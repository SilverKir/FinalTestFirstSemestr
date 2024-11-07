package data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Animals {

    private int id;
    protected String name;
    protected Date birthDate;
    protected List<String> commands = new ArrayList<String>();

//    public Animals(String name, Date birthDate, String command) {
//        id++;
//        this.name = name;
//        this.birthDate = birthDate;
//        if (!command.isEmpty()){
//        commands= new ArrayList<String>();
//        commands.add(command.toLowerCase());}
//    }

    public String getName() {
        return name;
    }

    protected void setName(String value) {
        name = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    protected void setBirthDate(Date value) {
        birthDate = value;
    }

    public String getCommands() {
        StringBuilder result = new StringBuilder();
      for (String command: commands){
          result.append(" ").append(command).append(",");
      }
        return result.toString();
    }



    public void setCommands(String command) {
        if (!commands.contains(command.toLowerCase())) {
            commands.add(command.toLowerCase());
        }
    }

    public List<Animals> animalsList = new ArrayList<Animals>();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    private void Print(StringBuilder sb, String indent) {
        sb.append(String.format("%s Имя: %s, Дата: %s, Команды:%s", indent, name, simpleDateFormat.format(birthDate), getCommands()));

        for (Animals animal : animalsList)
            animal.Print(sb, indent + "  ");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Print(sb, "");
        return sb.toString();
    }

}