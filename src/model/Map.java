package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Klara on 9.12.2014.
 */


public class Map{
    public static int mapHeight;
    public static int mapWidth;

    public static Color mapTerrainColor;
    public static byte terrainCode;
    public String path;
    public BufferedImage mapImageTerrain;
    public static int[][] map;

    public static int onPosition;
    public static int numberOfUnknown=0;


    public Map(String path) {
        this.path=path;
          System.out.println("Map class is working");
        try {
            mapImageTerrain = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mapHeight=mapImageTerrain.getHeight();
        mapWidth=mapImageTerrain.getWidth();

        System.out.println("map width: "+mapWidth+"map height: "+mapHeight);

        map=new int[mapWidth][mapHeight];

        for (int height = 0; height < mapHeight; height++) {
            for (int width = 0; width < mapWidth ; width++) {
                int coordination = mapImageTerrain.getRGB(width,height);
                mapTerrainColor = new Color(coordination);
               //  System.out.println(mapTerrainColor);
                map[width][height]=fillArray(mapTerrainColor);
                //System.out.print(map[width][height]);
            }
           //  System.out.printf("%n");
        }
        //    System.out.println("map is loaded");
    }

    private static int fillArray(Color mapTerrainColor){
        int[] rgbValue=new int[3];
        rgbValue[0]=mapTerrainColor.getRed();
        rgbValue[1]=mapTerrainColor.getGreen();
        rgbValue[2]=mapTerrainColor.getBlue();

        if(     rgbValue[0]<20 &&           //rgb 0
                rgbValue[1]<20 &&           //rgb 0
                rgbValue[2]<20){            //rgb 0
            //border
            terrainCode=0;
        }
        else if(     rgbValue[0]<50 &&      //rgb 0
                rgbValue[1]<50 &&      //rgb 0
                rgbValue[2]>205){      //rgb 255
            // deep water
            terrainCode=1;
        }
        else if (rgbValue[0]<20 &&                                  //rgb 0
                rgbValue[1]>235 &&                                 //rgb 255
                (rgbValue[2]>223 || rgbValue[2]<243))               //rgb 233
        {
            //shallow water
            terrainCode=2;

        }else if(       (rgbValue[0]>243 || rgbValue[0]<263 )&&         //rgb 253
                (rgbValue[1]>2 || rgbValue[1]<22) &&            //rgb 4
                (rgbValue[2]>0)|| rgbValue[2]<20)                                 //rgb 2
        {
            //grass
            terrainCode = 3;
        }

        else{
            //ground
            terrainCode=4;
            numberOfUnknown++;
        }

        return terrainCode;
    }

    //checking terrain code on position of Animal a from AnimalThread
    public static int whatIsOnMyPosition(int x, int y)throws ArrayIndexOutOfBoundsException {
//        System.out.println(x + " " + y);
        int result = 0;
        try {
            result = onPosition = map[x][y];
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(x +" " + y);
        }
        return result;
    }
}
