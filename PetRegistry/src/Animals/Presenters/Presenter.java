package Presenters;

import Models.Model;
import data.*;
import service.Exceptions.IllegalParameterException;
import view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Presenter {
    Model model;
    View view;

    public Presenter(View view, Model model) {
        this.model = model;
        this.view = view;
    }

    public void append() {
        StringBuilder sb = new StringBuilder()
                .append("\n===select animal===\n")
                .append("1 - Camel \n")
                .append("2 - Cat \n")
                .append("3 - Dog \n")
                .append("4 - Donkey \n")
                .append("5 - Horse \n")
                .append("6 - Humster \n");

        view.set(sb.toString());
        String response = view.get();
        Animals animal = null;
        switch (response) {
            case "1":
                animal = Camel.create(new Camel(), getName(), getBirthDate(), getCommand(), getCapacity());
                break;
            case "2":
                animal = Cat.create(new Cat(),getName(), getBirthDate(), getCommand(), getOwner());
                break;
            case "3":
                animal = Dog.create(new Dog(),getName(), getBirthDate(), getCommand(), getOwner());
                break;
            case "4":
                animal = Donkey.create(new Donkey(),getName(), getBirthDate(), getCommand(), getCapacity());
                break;
            case "5":
                animal = Horse.create(new Horse(),getName(), getBirthDate(), getCommand(), getCapacity());
                break;
            case "6":
                animal = Humster.create(new Humster(),getName(), getBirthDate(), getCommand(), getOwner());
                break;

                default:
                break;
        }
        if (animal != null) {
            model.append(animal);
        }
        view.set("ok");
    }

    public void addCommand(){
        show();
        view.set("Введите номер животного");
        int animalId=checkInteger(view.get());
        model.addNewCommand(animalId,getCommand());
        showAnimal(animalId);

    }

    public void showAnimal(int animalId) {
        view.set(model.showAnimal(animalId));
    }
public void showSorted(){
    view.set(model.sortByDate());
}
    public void show() {
        view.set(model.show());
    }

    public String getName() {
        view.set("Введите имя");
        return view.get();
    }

    public String getCommand() {
        view.set("Введите команду");
        return view.get();
    }

    public String getOwner() {
        view.set("Введите имя владельца");
        return view.get();
    }

    public int getCapacity()  {
        view.set("Введите грузоподъемность");
        return checkInteger(view.get());
    }

    public Date getBirthDate() {
        view.set("Введите дату рождения");
        return checkData(view.get());
    }



    public Date checkData(String userData) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("dd.MM.yyyy");
        try {
            Date result = simpleDateFormat.parse(userData);
            Date currentDate = new Date();
            if (result.after(currentDate)) {
                throw new IllegalParameterException("дата рождения " + userData + " больше текущей даты");
            }
            return result;
        } catch (ParseException e) {
            throw new IllegalParameterException("дата " + userData + " введена некорректно введите в виде dd.MM.yyyy");
        }
    }

    public Integer checkInteger(String userData){
        try {
            return Integer.parseInt(userData);
        } catch (Exception e) {
            throw new IllegalParameterException("Введенное значение" + userData+ " не число!");
        }
    }
}

