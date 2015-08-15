package model;

import view.Main;

import java.util.ArrayList;

/**
 * Created by Klara on 10.11.2014.
 */
public class Animal {
    public  int id;
    public  int age;
    public  int hunger;
    public  int thirst;
    public  int energy;
    public AnimalTypeEnum animalType;
    public  int xPosition;
    public  int yPosition;
    public  int birth;
    public int death;
    public static  int amountOfID;

    /**
     *
     * @param id is unique numerical identification of animal
     * @param animalType determinate if animal is COW, DEER or HORSE
     * @param age is age of animal
     * @param thirst is number that set level of thirst of animal
     * @param hunger is number that set level of hunger of animal
     * @param energy is number that set level of energy of animal
     */
    public Animal(int id,  AnimalTypeEnum animalType , int age, int thirst, int hunger, int energy){
        this.id=id;
        this.animalType=animalType;
        this.age=age;
        this.thirst=thirst;
        this.hunger=hunger;
        this.energy=energy;

        getInitialxPosition();
        getInitialyPosition();
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animalType=" + animalType +
                //  ", birth=" + birth +
                //  ", death=" + death +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", age=" + age +
                ", thirst=" + thirst +
                ", hunger=" + hunger +
                ", energy=" + energy+
                '}';
    }

    public int getId() {
        return id;
    }

    public static int setId() {
        return amountOfID++;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getInitialxPosition() {
        xPosition=(int)(Math.random()*Map.mapWidth);
        return xPosition;
    }

    public void setxPosition(int xPosition) { this.xPosition=xPosition; }

    public int getInitialyPosition() {
        yPosition=(int)(Math.random()*Map.mapHeight);
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public AnimalTypeEnum getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalTypeEnum animalType) {
        this.animalType = animalType;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public int getEnergy() { return energy; }

    public void setEnergy(int energy) { this.energy = energy; }

    public int getThirst() { return thirst;}

    public void setThirst(int thirst) {this.thirst = thirst; }

    public int getHunger() { return hunger; }

    public void setHunger(int hunger) { this.hunger = hunger; }

}
