package data;

import java.util.Date;

public class PackAnimals extends Animals{
    public  int capacity;

    public PackAnimals(int id, String name, Date birthDate, String commands, int capacity) {
        super(id, name, birthDate, commands);
        this.capacity=capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
