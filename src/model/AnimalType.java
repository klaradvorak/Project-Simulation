package model;

public class AnimalType {
    private int initial_population;
    private String animal_type;


    public AnimalType() {

    }


    public AnimalType(int initial_population, String animal_type) {
        super();
        this.initial_population = initial_population;
        this.animal_type = animal_type;
    }


    public int getInitial_population() {
        return initial_population;
    }


    public void setInitial_population(int initial_population) {
        this.initial_population = initial_population;
    }


    public String getAnimal_type() {
        return animal_type;
    }


    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }


    @Override
    public String toString() {
        return "\t" + this.getInitial_population()
                + "\t" + this.getAnimal_type() + "";
    }




}
