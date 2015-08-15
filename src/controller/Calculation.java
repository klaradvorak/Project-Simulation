package controller;
import model.FileReading;
import model.fileReadingInit;

public class Calculation {
	public String tab_split_birth[];
	public String tab_split_death[];
	public String tab_split_init[];
	public String tab_split_year[];
	public String tab_split_month[];
	//public String tab_data[];
	//public String tab_init_pop[];

	public int tab_tot_pop[];
	public FileReading datasFile;
	public fileReadingInit datasFileIni;

	public Calculation(String filePath){

		//*********** Object to read the animals files******
		datasFile=new FileReading(filePath);
		int nbLine=datasFile.getNbLine();
		//*********** Object to read the initial population file******
		datasFileIni=new fileReadingInit("init_pop");
		int nbLineIni=datasFileIni.getNbLine();

		//tab_data=new String[nbLine];
		tab_split_birth=new String[nbLine];
		tab_split_death=new String[nbLine];
		tab_split_year=new String[nbLine];
		tab_split_month=new String[nbLine];
		tab_tot_pop=new int[nbLine];
		tab_split_init=new String[nbLineIni];

		//*********reading the initial population file and getting the animal and the population ********
		String initPop[]=datasFileIni.getDatas();
		if(initPop!=null){
			for(int i=0;i<initPop.length;i++){
				String tab[]=initPop[i].split(" ");
				if(tab[0].equalsIgnoreCase(filePath)){
					tab_split_init[0]=tab[0];
					tab_split_init[1]=tab[1];
				}
			}
		}

		//**********getting the element of every animals******
		String datat[]=datasFile.getDatas();
		int j=0;
		if(datat.length>0){
			for(int i=0;i<datat.length;i++){
				String spl[]=datat[i].split(" ");
				tab_split_year[j]=spl[0];
				tab_split_month[j]=spl[1];
				tab_split_birth[j]=spl[3];
				tab_split_death[j]=spl[4];
				j++;
			}
		}else{
			System.out.println("there is nothing in the file");
		}

		//****Calculate the population each month******
		int calc=0;
		//try{
		calc=Integer.parseInt(tab_split_init[1]);

		for(int i=0;i<tab_split_birth.length;i++){
			tab_tot_pop[i]=calc+Integer.parseInt(tab_split_birth[i])-Integer.parseInt(tab_split_death[i]);
			calc=tab_tot_pop[i];
			//System.out.println("tab tot: "+tab_tot_pop[i]);
			//System.out.println("calc: "+calc);
		}
	/*}catch (Exception ioe) {

			System.out.println("probleme in finding the initial pop" + ioe.toString());
		}*/

	}

	public String[] getTab_split_year() {
		return tab_split_year;
	}



	public String[] getTab_split_month() {
		return tab_split_month;
	}



	public String[] getTab_split_birth() {
		return tab_split_birth;
	}

	public String[] getTab_split_death() {
		return tab_split_death;
	}

	public String[] getTab_split_init() {
		return tab_split_init;
	}

	public int[] getTab_tot_pop() {
		return tab_tot_pop;
	}

	/*public String[] getTab_init_type() {
		return tab_init_type;
	}

	public String[] getTab_init_pop() {
		return tab_init_pop;
	}*/




}
