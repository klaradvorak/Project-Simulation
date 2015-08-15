package model;

import controller.AnimalThread;
import view.AppFrame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Klara on 20.1.2015.
 */
public class CreateAnimal {
    public AnimalTypeEnum animalTypeEnum;
    public int population;
    private int idOfAnimal;

    public CreateAnimal(AnimalTypeEnum animalTypeEnum, int population){
        this.animalTypeEnum=animalTypeEnum;
        this.population=population;

        for (int i = 0; i < population; i++) {
            //System.out.println("one turn population= "+oneTurnPopulation);
           AppFrame.animals.add(new Animal(Animal.setId(), animalTypeEnum, 0, 0, 0, 100));
        }

        ExecutorService executor = Executors.newFixedThreadPool(50);

        for (idOfAnimal = 0; idOfAnimal < AppFrame.animals.size(); idOfAnimal++) {
            Runnable worker = new AnimalThread(AppFrame.animals.get(idOfAnimal));
            executor.execute(worker);
        }
        executor.shutdown();

        while (!executor.isTerminated()) {
        }


    }
    public static AnimalTypeEnum animalTypeToEnum(String s){
        AnimalTypeEnum whatAmI=null;
        switch (s) {
            case "Cow":
                whatAmI = AnimalTypeEnum.COW;
                break;
            case "Deer":
                whatAmI = AnimalTypeEnum.DEER;
                break;
            case "Horse":
                whatAmI = AnimalTypeEnum.HORSE;
                break;
            case "cow":
                whatAmI = AnimalTypeEnum.COW;
                break;
            case "deer":
                whatAmI = AnimalTypeEnum.DEER;
                break;
            case "horse":
                whatAmI = AnimalTypeEnum.HORSE;
                break;
            default:
                System.out.println("Switch in CreateAnimal is not working");
                break;
        }
        return whatAmI;
    }
}
