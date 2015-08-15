package model;

import java.io.*;
import model.lineNuber;

//****************** This class is used to get the informations from the animals records*****************
public class FileReading {


	public String datas[];
	public int count1;
	public int i;
	public  String filePath1;
	public BufferedReader buff;
	public lineNuber line_count;
	public int nbLine;

	public FileReading(String filePath) {
		line_count= new lineNuber(filePath);
		nbLine=line_count.getCounts();
		datas= new String[nbLine];

		filePath1 = "configFile/animalData/"+filePath+".txt";

		try{
			buff = new BufferedReader(new FileReader(filePath1));
			i=0;
			try {
				String line;
				while ((line = buff.readLine()) != null){
					datas[i]=line;
					i++;
				}
			} finally {
				buff.close();
			}
		} catch (IOException ioe) {
			System.out.println("Error --" + ioe.toString());
		}



	}


	public String[] getDatas() {
		return datas;
	}
	public int getNbLine(){
		return nbLine;
	}
}
