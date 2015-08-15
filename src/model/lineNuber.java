package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class lineNuber {
	public int counts;
	public lineNuber(String filePath){
		String filePath1 = "configFile/animalData/"+filePath+".txt";
		String str;
		counts=0;
		try{
			FileInputStream fis = new FileInputStream(filePath1);
			LineNumberReader l = new LineNumberReader(
					new BufferedReader(new InputStreamReader(fis)));
			while ((str=l.readLine())!=null)
			{
				counts = l.getLineNumber();
			}
			//System.out.println(counts);
			fis.close();
		} catch (IOException ioe) {

			System.out.println("Error --" + ioe.toString());
		}


	}
	public int getCounts() {
		return counts;
	}

}
