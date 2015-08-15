package controller;

import model.*;
//import model.AnimalBehaviour;
import view.AppFrame;
import view.Main;

/**
 * Created by Klara on 5.12.2014.
 */


public class AnimalThread implements Runnable {

    public  Animal a;
    public  static int time;
    private int onPosition;


    public AnimalThread(Animal a ){
        this.a=a;
        // System.out.println("Creating threads");
    }

    public void run() {
        // System.out.println("running thread: "+a);

        for (time=0;time<(  Main.timePeriod);time++) {

            aging(a);
            gettingThirsty(a);
            gettingHungry(a);
            gettingTired(a);
            onPosition=Map.whatIsOnMyPosition(a.xPosition,a.yPosition);

            if (a.thirst>20 ){
             int amountOfWater = 0;
                if  (!(onPosition==2)){
                    //shallow water
                    AnimalBehaviour.move(onPosition, 2, a);
                    amountOfWater=5;
                }else if (!(onPosition==1)){
                    // deep water, animal can drink more than from shallow water
                    AnimalBehaviour.move(onPosition, 1, a);
                    if(a.thirst<25){
                        amountOfWater=a.thirst;
                    }else {
                        amountOfWater = 25;
                    }
                }
                AnimalBehaviour.drinking(a, amountOfWater);
                // method sleeping: here like gain energy
                AnimalBehaviour.sleeping(a,5);
            }
            if(a.hunger>15){
                AnimalBehaviour.move(onPosition, 2, a);
                AnimalBehaviour.eating(a,5);
                // method sleeping: here like gain energy
                AnimalBehaviour.sleeping(a,5);
            }
            if ((a.energy < 10)) {
                AnimalBehaviour.sleeping(a,30);
            }
           // System.out.println("a= "+a);
        }
     /*   if(a.id==(AppFrame.animals.size()-1)){
            AnimalBehaviour.beBorn();

        }*/

       // System.out.println("a= "+a);
    }

    public  void aging(Animal a) {
        //   System.out.println("aging working");
        if((time%Main.timePeriod)==0)
        {
            a.age++;
        }

        if (a.age>=(20*Main.timePeriod)){
            System.out.println("Animal died from old age");
            AnimalBehaviour.died(a);
        }
        // System.out.printf("age is%d%n", age);

    }

    //to add: when hunger is equal to something animal starts looking for a food source  "eating working "
    public  void gettingHungry(Animal a) {
        //  System.out.println();

        if (a.hunger <= 100) {
            a.hunger++;
            if (a.hunger >= 100) {
                // if hunger is equal to 10 than method dead() is caled and message is printed
                System.out.println("Animal died from hunger");
                AnimalBehaviour.died(a);
            }

        } else {
            a.hunger = 1;
        }
    }

    //to add: when thirst is equal to something animal starts looking for a water source
    public void gettingThirsty(Animal a) {
        // System.out.println("drinking working");
        if (a.thirst < 100) {
            a.thirst++;
            if (a.thirst >= 100) {
                // if thirst is equal to 10 than method dead() is caled and message is printed
                System.out.println("Animal died from thirst");
                AnimalBehaviour.died(a);
            }
        } else {
            a.thirst = 1;
        }
    }

    //when energy is equal to someting start sleeping == cannot move for some time
    public void gettingTired(Animal a) {
        // System.out.println("sleeping working");
        if (1 < a.energy) {
            a.energy--;
            if (a.energy <= 1) {
                // if energy is equal to 0 than method dead() is caled and message is printed
                System.out.println("Animal died from tirednes");
                AnimalBehaviour.died(a);
            }
        } else {
            a.energy = 100;
        }
    }
}
