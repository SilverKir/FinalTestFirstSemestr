package data;

import java.util.Date;

public class PackAnimals extends Animals{
    public  int capacity;

    public static <T extends PackAnimals> T create( T instance, String name, Date birthDate, String commands, int capacity) {
       instance.name=name;
       instance.birthDate=birthDate;
       instance.setCommands(commands);
       instance.capacity=capacity;
       return  instance;
    }

protected  PackAnimals(){

}

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + " Перевозимый вес:" +
                  capacity +"\n";
    }
}
