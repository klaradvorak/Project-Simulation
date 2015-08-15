package model;

import controller.AnimalThread;
import view.AppFrame;
import view.Main;

/**
 * Created by Klara on 2.1.2015.
 */




public class AnimalBehaviour {

    public static boolean check;

    /**
     *
     * @param terrainCode number in map representing type of terrain
     * @param neededTerrainCode number of terrain that method is looking for
     * @param a animal for which is this method accurate
     */
    public static void move(int terrainCode,int neededTerrainCode, Animal a){
       // System.out.println("move started working");
        int xDifference=0;
        int yDifference=0;
        int xStartingPoint=0;
        int yStartingPoint=0;
        int xEndingPoint=0;
        int yEndingPoint=0;
        int lenghtOfWay;


        do{
            xStartingPoint = a.xPosition-xDifference;
            yStartingPoint = a.yPosition-yDifference;

            xEndingPoint = a.xPosition+xDifference;
            yEndingPoint = a.yPosition+yDifference;

            if (Map.mapHeight<yEndingPoint) {
                yEndingPoint=Map.mapHeight-1;
                      }
            if (Map.mapWidth<xEndingPoint) {
                xEndingPoint = Map.mapWidth - 1;
            }
            if (xStartingPoint<0){
                xStartingPoint=0;
            }
            if(yStartingPoint<0){
                yStartingPoint=0;
            }
            for (int i=yStartingPoint;i<yEndingPoint;i++) {
             //   System.out.println("i:"+i);
                for (int j = xStartingPoint; j < xEndingPoint; j++) {
                    //System.out.println("j:"+j+" i:"+i);
                    terrainCode=Map.whatIsOnMyPosition(j,i);

                    if (terrainCode==neededTerrainCode){
                        check=positionAvailable(j, i);
                        if (check) {
                            //calculation of lenght of way
                            if ((a.xPosition<j) && (a.yPosition<i)) {
                                lenghtOfWay = (j-a.xPosition)+(i-a.yPosition);
                            }else if ((a.xPosition<j)&&(a.yPosition>i)){
                                lenghtOfWay= (j-a.xPosition)+(a.yPosition-i);

                            }else if ((a.xPosition>j)&&(a.yPosition<i)){
                                lenghtOfWay= (a.xPosition-j)+(i-a.yPosition);

                            } else{
                                lenghtOfWay= (a.xPosition-j)+(a.yPosition-i);
                            }

                            a.xPosition = j;
                            a.yPosition = i;
                            //System.out.println("new positions: x-"+a.xPosition+" y-"+a.yPosition);
                            j = xEndingPoint;
                            i = yEndingPoint;
                            a.energy=a.energy-lenghtOfWay;
                        }
                    }
                }
            }
            xDifference++;
            yDifference++;

        }while (terrainCode!=neededTerrainCode);
       // System.out.println("while loop is done");
    }

    /**
     *
     * @param i is possible y position of animal
     * @param j is possible x position of animal
     * @return boolean parameter if position is available or not
     */
    public static boolean positionAvailable(int i, int j){
        boolean available=false;
        for (Animal animal: AppFrame.animals){
            if ((animal.xPosition==j)&& (animal.yPosition==i)){
                available=false;
                //System.out.println("someone else on position");
            }else{
                available=true;
            }

        }
      //  System.out.println("available "+available);
        return available;
    }

    // when animal die, it is delete from system and it is added to deadAnimals.txt
    public static void died(Animal a){
        AppFrame.animals.remove(a);
        new fileWriting("deadAnimals", "Animal{" + "id=" + a.id + ", animalType=" + a.animalType + ", age=" + a.age + '}');
    }

    // once in year two animals of same type has child = adding new animal is handled here
    public static void beBorn(){

        int newCows= AppFrame.totalPopulationCOW/2;
        // probability to have a child
        double totalAmounOfNewCows=newCows*0.9; //!more relevant data need to be filled
        System.out.println("total cow:"+totalAmounOfNewCows);
        newCows= (int) Math.floor(totalAmounOfNewCows);
        System.out.println(newCows);

        int newDeers= AppFrame.totalPopulationDEER/2;
        // probability to have a child
        double totalAmounOfNewDeers=newDeers*0.85;  //!more relevant data need to be filled
        System.out.println("total deers:"+totalAmounOfNewDeers);
        newDeers= (int) Math.floor(totalAmounOfNewDeers);
        System.out.println(newDeers);

        int newHorses= AppFrame.totalPopulationHORSE/2;
        // probability to have a child
        double totalAmounOfNewHorses=newHorses*0.79;    //!more relevant data need to be filled
        System.out.println("total horses:"+totalAmounOfNewHorses);
        newHorses= (int) Math.floor(totalAmounOfNewHorses);
        System.out.println(newHorses);
        int totalOfAllAnimals=newCows+newDeers+newHorses;
        Main.totalPopulation=Main.totalPopulation+totalOfAllAnimals;

        for (int i = 0; i < totalOfAllAnimals; i++) {
            if(i<newCows){
                AppFrame.animals.add(new Animal(Animal.setId(), AnimalTypeEnum.COW, 0, 0, 0, 100));
            }else if((i>=newCows)&&(i<newDeers)){
                AppFrame.animals.add(new Animal(Animal.setId(), AnimalTypeEnum.DEER, 0, 0, 0, 100));
            }else{
                AppFrame.animals.add(new Animal(Animal.setId(), AnimalTypeEnum.HORSE, 0, 0, 0, 100));
            }

            Runnable worker = new AnimalThread(AppFrame.animals.get(i));

        }


    }

    public static int drinking(Animal a,int amountOfWater){
        return  a.thirst=a.thirst-amountOfWater;
    }


    public static int eating(Animal a, int amountOfFood){
        return a.hunger=a.hunger-amountOfFood;
    }


    public static int sleeping(Animal a, int amountOfSleep){
        return  a.energy=a.energy+amountOfSleep;
    }





}
