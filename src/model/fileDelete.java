package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class fileDelete {
    public String filePath1;
    public fileDelete(String filePath,String lineToRemove) {

        try {
            filePath1="vc/"+filePath+".txt";
            File inFile = new File(filePath1);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(filePath1));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
            try{
                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = br.readLine()) != null) {
                    String [] tab=line.split(" ");
                    String Comparaison=tab[0]+" "+tab[1]+" "+tab[2];
                    if (!Comparaison.trim().equals(lineToRemove)) {

                        pw.println(line);
                        pw.flush();
                        System.out.println(line);
                    }
                }
                pw.close();
                br.close();
            } finally {
                br.close();
                pw.close();
            }
            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
