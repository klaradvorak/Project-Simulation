package model;

import java.io.*;

import javax.swing.JOptionPane;

import model.lineNuber;
//****************** This class is used to get the informations from the initial population file*****************
public class fileReadingInit {


	public String datasInit[];
	public int count1Init;
	public int iInit;
	public  String filePath1Init;
	public BufferedReader buffInit;
	public lineNuber line_countInit;
	public int nbLineInit;
	public String tab_init_type[];
	public String tab_init_pop[];
	JOptionPane errorMsg;
	public fileReadingInit(String filePath) {
		line_countInit= new lineNuber(filePath);
		nbLineInit=line_countInit.getCounts();
		datasInit= new String[nbLineInit];
		tab_init_type=new String[nbLineInit];
		tab_init_pop=new String[nbLineInit];

		filePath1Init = "configFile/animalData/"+filePath+".txt";
		try{
			buffInit = new BufferedReader(new FileReader(filePath1Init));
			iInit=0;
			try {
				String line;
				while ((line = buffInit.readLine()) != null){
					datasInit[iInit]=line;
					String tab[]=line.split(" ");
					tab_init_type[iInit]=tab[0];//***receiving the type of animals in the initial pop
					tab_init_pop[iInit]=tab[1];//***receiving the animals number of animals  in the initial pop
					iInit++;
				}
			} finally {
				buffInit.close();
			}
		} catch (IOException ioe) {
			System.out.println("Error --Initialize Initial Population of this type of animal" + ioe.toString());

		}



	}


	public String[] getDatas() {
		return datasInit;
	}
	public int getNbLine(){
		return nbLineInit;
	}
	public String[] getTab_init_type() {
		return tab_init_type;
	}

	public String[] getTab_init_pop() {
		return tab_init_pop;
	}
}
