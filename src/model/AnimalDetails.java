package model;

/**
 * Created by Klara on 21.1.2015.
 */
public class AnimalDetails {
    public static String year;
    public static String month;
    public AnimalTypeEnum type;
    public static int birth;
    public static int death;
    String season;

    public AnimalDetails(String year,String month, AnimalTypeEnum type, int birth,int death, String season){
        this.year = year;
        this.month=month;
        this.type=type;
        this.birth=birth;
        this.death=death;
        this.season=season;
    }

}
