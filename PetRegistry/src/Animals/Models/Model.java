package Models;
import data.Animals;
import data.Registry;

public class Model {
    Animals registry;

    public Model(String registryName){
        registry=new Registry(registryName);
    }

    public <T extends Animals> void append(T animal){
       int id = registry.getId();
       id++;
       registry.setId(id);
       animal.setId(id);
       registry.animalsList.add(animal);
    }

    public void addNewCommand(int animalId,String command){
        for (Animals animal : registry.animalsList ){
            if (animal.getId()==animalId){
                animal.setCommands(command);
                break;
            }
        }
    }

    public String sortByDate(){
        registry.animalsList.sort((o1, o2) ->{
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            });
        return show();
    }

    public  String show() {
        StringBuilder sb = new StringBuilder();
        for (Animals animal : registry.animalsList )
        {sb.append(animal.getId()).append(". ").append(animal.getClass().getName()).append(animal.toString());}
        return sb.toString();
    }

    public  String showAnimal(int id) {
        StringBuilder sb = new StringBuilder();
        for (Animals animal : registry.animalsList )
            if (animal.getId()==id){
                {sb.append(animal.getId()).append(". ").append(animal.getClass().getName()).append(animal.toString());}
                break;
            }
        return sb.toString();
    }
}
