package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import controller.AnimalThread;
import model.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import controller.Calculation;


public class AppFrame extends JFrame implements ActionListener {
	public static fileReadingInit initialPop;
	public static ArrayList<Animal> animals=new ArrayList<>();
	public fileWriting s_info;
	public FileReading g_info;
	public lineNuber g_line;
	public Calculation get_tabs;
	public Calculation get_tab_tab;
	public fileDelete g_delete;

	public static final int DEFAULT_WIDTH = 850;
	public static final int DEFAULT_HEIGHT = 700;
	JOptionPane errorMsg;
	JFrame AnimalBox;
	JPanel Panel_Pri,Panel_top,Panel_mid,Panel_but,Panel_mid1,Panel_mid2,Panel_but1,Panel_but2,Panel_but2sub1,Panel_but2sub2;
	JMenuBar menu;
	JMenu file, edit;
	JMenuItem file1,file2,edit1,edit2;
	JComboBox animaSpecific;
	JTextField immi,birth,death;
	JComboBox winter;

	JComboBox month,year;
	JLabel lbirth,ldeath,limmi,lemmi,lshot,lwinter,imagepik;
	JButton show,save,delete,subbutton1,subbutton2,subbutton3;
	ImageIcon project_pik;

	LineChart chart1;
	public static String[] oldYear;
	public static String[] oldMonth;
	public static String[] initType;

	Object[][] Datas={
			{"0","0","0"}
	};
	private int idOfAnimal,oneTurnPopulation;
	public static int totalPopulationCOW,totalPopulationDEER,totalPopulationHORSE,amountOfTurn,birth1,death1;


	AppFrame(){
		//creating the menubar
		menu = new JMenuBar();

		file = new JMenu("File");
		edit = new JMenu("Edit");

		//representing the menu items
		file1 = new JMenuItem("New");
		file1.addActionListener(this);
		file2 = new JMenuItem("Exit");
		file2.addActionListener(this);
		edit1= new JMenuItem("Copy");
		edit2 = new JMenuItem("Paste");

		file.add(file1);
		file.addSeparator();
		file.add(file2);
		edit.add(edit1);
		edit.addSeparator();
		edit.add(edit2);

		menu.add(file);
		menu.add(edit);

		this.setJMenuBar(menu);

		//here is the princioal panel
		Panel_Pri = new JPanel();
		Panel_Pri.setLayout(new BorderLayout());

		//Creation of the principal panels
		Panel_top = new JPanel();
		Panel_top.setLayout(new GridBagLayout());
		Panel_top.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 10, 5), new EtchedBorder()));
		//Panel_top.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		GridBagConstraints c = new GridBagConstraints();
		Panel_top.setBackground(Color.LIGHT_GRAY);
		Panel_Pri.add(Panel_top, BorderLayout.NORTH);

		// creation of the fields
		animaSpecific = new JComboBox();
		month = new JComboBox();
		year = new JComboBox();
		birth = new JTextField(10);
		death = new JTextField(10);
		winter = new JComboBox();

		lbirth = new JLabel("Type of Animal");
		ldeath = new JLabel("Month");
		limmi = new JLabel("YEar");
		lemmi = new JLabel("Birth");
		lshot = new JLabel("Death");
		lwinter = new JLabel("Weather");

		    	/*---add items to jcomboBox---*/

		String [] monthItems = {"01" , "02", "03" , "04","05","06","07","08","09","10","11","12"
				+ "" };
		for(int i = 0; i < monthItems.length; i++) {
			month.addItem(monthItems[i]);

		}

		String [] yearItem = {"2009" , "2010", "2011" ,"2012","2013","2014","2015","2016","2017","2018"};
		for(int i = 0; i < yearItem.length; i++) {
			year.addItem(yearItem[i]);

		}

		String [] typeOfAnimal = {"Cow", "Deer","Horse" };
		for(int i = 0; i < typeOfAnimal.length; i++) {
			animaSpecific.addItem(typeOfAnimal[i]);

		}

		String [] weatherCondition = {"Winter", "Spring","Summer", "Autumn "};
		for(int i = 0; i < weatherCondition.length; i++) {
			winter.addItem(weatherCondition[i]);

		}




		    	/*---end of adding items------*/
		//creation of la

		//----------------Positions ----------------------
		c.gridx=0;
		c.gridy=0;
		c.gridheight=1;
		c.gridwidth=1;

		Panel_top.add( animaSpecific ,c);

		c.gridx=1;
		Panel_top.add( month ,c);

		c.gridwidth= GridBagConstraints.REMAINDER;
		c.gridx=2;
		Panel_top.add( year ,c);

		// second row

		c.gridx=0;
		c.gridy=1;
		c.gridheight=1;
		c.gridwidth=1;

		Panel_top.add( lbirth ,c);
		c.gridx=1;
		Panel_top.add( ldeath ,c);

		c.gridwidth= GridBagConstraints.REMAINDER;
		c.gridx=2;
		Panel_top.add( limmi ,c);

		//---------------------------------

		c.gridx=0;
		c.gridy=2;
		c.gridheight=1;
		c.gridwidth=1;

		Panel_top.add( new JLabel(".") ,c);

		c.gridx=1;
		Panel_top.add( new JLabel(".") ,c);

		c.gridwidth= GridBagConstraints.REMAINDER;
		c.gridx=2;
		Panel_top.add( new JLabel(".") ,c);
		//---------------------------

		//3rd row
		c.gridx=0;
		c.gridy=3;
		c.gridheight=1;
		c.gridwidth=1;
		Panel_top.add( birth ,c);

		c.gridx=1;
		Panel_top.add( death ,c);

		c.gridwidth= GridBagConstraints.REMAINDER;
		c.gridx=2;
		Panel_top.add( winter ,c);

		// 4th row
		c.gridx=0;
		c.gridy=4;
		c.gridheight=1;
		c.gridwidth=1;

		Panel_top.add( lemmi ,c);

		c.gridx=1;
		Panel_top.add( lshot ,c);

		c.gridwidth= GridBagConstraints.REMAINDER;
		c.gridx=2;
		Panel_top.add( lwinter ,c);

		//***************************************2nd Panel starts here *******

		Panel_mid = new JPanel();
		Panel_mid.setLayout(new BorderLayout());
		Panel_mid.setPreferredSize(new Dimension(Panel_Pri.getWidth(),300));
		Panel_mid1 = new JPanel();
		Panel_mid1.setPreferredSize(new Dimension(150,300));
		Panel_mid1.setLayout(new GridLayout(0,1));
		Panel_mid1.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));

		Panel_mid2 = new JPanel();
		Panel_mid2.setBackground(Color.WHITE);
		Panel_mid2.setPreferredSize(new Dimension(Panel_mid.getWidth()-150,300));
		Panel_mid2.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
		Panel_mid.add(Panel_mid1,BorderLayout.WEST);
		Panel_mid.add(Panel_mid2, BorderLayout.CENTER);

		//*****************************add line chart ****************
		chart1 = new LineChart("Line");
		chart1.chartPanel.setPreferredSize(new java.awt.Dimension(650, 250));
		Panel_mid2.add(chart1.chartPanel);
		Panel_mid2.setVisible(true);

		//***************************************END 2nd Panel  here ******

		//***************************************3rd Panel starts here *******
		Panel_but = new JPanel();
		Panel_but.setLayout(new BorderLayout());
		Panel_but.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
		Panel_but1 = new JPanel();
		Panel_but1.setBackground(Color.RED);
		Panel_but1.setPreferredSize(new Dimension(500,250));

		project_pik = new ImageIcon("configFile/maps/map250.jpg");
		imagepik = new JLabel(project_pik);
		//imagepik.setBorder(new EmptyBorder(0 ,0, 0, 0));
		Panel_but1.add(imagepik);

		//*********end here************
		Panel_but2 = new JPanel();
		Panel_but2.setBackground(Color.GREEN);
		Panel_but2.setPreferredSize(new Dimension(250,250));
		Panel_but2.setLayout(new BorderLayout());
		Panel_but.add(Panel_but1,BorderLayout.WEST);
		Panel_but.add(Panel_but2, BorderLayout.EAST);


		//*******************creating animal buttons and sub buttons
		save = new JButton("Save");
		show = new JButton("Show");
		delete = new JButton("Delete");

		save.addActionListener(this);
		show.addActionListener(this);
		delete.addActionListener(this);

		subbutton1 = new JButton("Simulate");
		subbutton2 = new JButton("Information Panel");
		subbutton3 = new JButton("Next");

		subbutton2.addActionListener(this);

		Panel_mid1.add(save);
		Panel_mid1.add(show);
		Panel_mid1.add(delete);

		//***********end here***********

		//*********create sub panels for mid panel2
		Panel_but2sub1 = new JPanel();
		Panel_but2sub2 = new JPanel();

		Panel_but2.add(Panel_but2sub1, BorderLayout.NORTH);
		//Panel_but2sub1.setBackground(Color.BLUE);
		Panel_but2sub1.setPreferredSize(new Dimension(Panel_but2.getWidth(),200));
		Panel_but2sub1.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(15, 15, 15, 15), new EtchedBorder()));

		Panel_but2.add(Panel_but2sub2, BorderLayout.SOUTH);
		Panel_but2sub2.setLayout(new BorderLayout());
		//Panel_but2sub2.setBackground(Color.BLACK);
		Panel_but2sub2.setPreferredSize(new Dimension(Panel_but2.getWidth(),50));
		Panel_but2sub2.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), new EtchedBorder()));
		//Panel_but2sub2.add(subbutton1, BorderLayout.WEST);
		Panel_but2sub2.add(subbutton2, BorderLayout.CENTER);
		//Panel_but2sub2.add(subbutton3, BorderLayout.EAST);

		subbutton1.setPreferredSize(new Dimension(125,Panel_but2sub2.getHeight()));

		//*****************Showing the population of each animal type**************




		String[] header = {"Month", "Birth", "Dirth"};

		JTable table = new JTable(Datas, header);

		Panel_but2sub1.add(table.getTableHeader());
		Panel_but2sub1.add(table);

		//*****************END Showing the population of each animal type**************


		//***************************************END 3rd Panel  here *******


		// Using of the frame
		Panel_Pri.add(Panel_mid,BorderLayout.CENTER);
		Panel_Pri.add(Panel_but,BorderLayout.SOUTH);
		this.setContentPane(Panel_Pri);
		this.setTitle("Simulation Graph Application");
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);


	}
	public Object[][] table(String animType){
		get_tab_tab=new Calculation(animType);
		String month[]=get_tab_tab.getTab_split_month();
		String birth[]=get_tab_tab.getTab_split_birth();
		String death[]=get_tab_tab.getTab_split_death();

		for(int i=0;i<month.length;i++){
			int k=0;
			Datas[i][k]=month[i];
			Datas[i][k++]=birth[i];
			Datas[i][k++]=death[i];

		}
		System.out.print(month.length);
		return Datas;
	}
	boolean test,testIni;
	public boolean testing(String animType, String year, String month){
		test=true;
		get_tabs = new Calculation(animType);
		oldYear = get_tabs.getTab_split_year();
		oldMonth = get_tabs.getTab_split_month();
		if((Arrays.asList(oldMonth).indexOf(month)>=0)){
			test=false;
		}
		System.out.println(Arrays.asList(oldMonth).indexOf(month));
		System.out.println(test);
		return test;
	}
	public boolean testingIni(String typeAnim){
		testIni=true;
		initialPop = new fileReadingInit("init_pop");
		initType = initialPop.getTab_init_type();
		if((Arrays.asList(initType).indexOf(typeAnim)>=0)){
			test=false;
		}

		return testIni;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == file1){
			new Initialize().setVisible(true);
		}else if (source == file2 ){
			this.setVisible(false);

		}


		if (source == save){
			System.out.println("save in app frame started to work");
			if((birth.getText().equals("") )||( death.getText()).equals("")){

				JOptionPane.showMessageDialog(errorMsg,
						"Fill either birth or death");
			}else{
				String typeOfAnimal1 = animaSpecific.getItemAt(animaSpecific.getSelectedIndex()).toString();
				String month1 = month.getItemAt(month.getSelectedIndex()).toString();
				String year1 = year.getItemAt(year.getSelectedIndex()).toString();
				birth1 = Integer.parseInt(birth.getText());
				death1 = Integer.parseInt(death.getText());
				String weather1 =winter.getItemAt(winter.getSelectedIndex()).toString();

				new AnimalDetails(year1,month1, CreateAnimal.animalTypeToEnum(typeOfAnimal1),birth1,death1,weather1);

				amountOfTurn++;
				oneTurnPopulation = birth1 - death1;

				if(typeOfAnimal1=="Deer"){
					if(testingIni("Deer")){
						if(testing("Deer", year1, month1)){
							s_info = new fileWriting("deer",year1+" "+month1+" "+typeOfAnimal1+" "+birth1+" "+death1+" "+weather1);
						totalPopulationDEER = totalPopulationDEER + oneTurnPopulation;
						}else{
							JOptionPane.showMessageDialog(errorMsg,
									"Information on this date already given");
						}
					}else{
						JOptionPane.showMessageDialog(errorMsg,
								"Initialize Initial Population of this type of animal");
					}
				}

				if(typeOfAnimal1=="Cow"){
					if(testingIni("Cow")){
						if(testing("Cow", year1, month1)){
							s_info = new fileWriting("cow",year1+" "+month1+" "+typeOfAnimal1+" "+birth1+" "+death1+" "+weather1);
							totalPopulationCOW = totalPopulationCOW + oneTurnPopulation;
						}else{
							JOptionPane.showMessageDialog(errorMsg,
									"Information on this date already given");
						}
					}else{
						JOptionPane.showMessageDialog(errorMsg,
								"Initialize Initial Population of this type of animal");
					}
				}
				if(typeOfAnimal1=="Horse"){
					if(testingIni("Horse")){
						if(testing("Horse", year1, month1)){
							s_info = new fileWriting("horse",year1+" "+month1+" "+typeOfAnimal1+" "+birth1+" "+death1+" "+weather1);

							totalPopulationHORSE = totalPopulationHORSE + oneTurnPopulation;
						}else{
							JOptionPane.showMessageDialog(errorMsg,
									"Information on this date already given");
						}
					}else{
						JOptionPane.showMessageDialog(errorMsg,
								"Initialize Initial Population of this type of animal");
					}
				}
				// animls = new AnimalCal(typeOfAnimal1,month1,year1,birth1,death1,weather1);



				AnimalCal animls = new AnimalCal(typeOfAnimal1, month1, year1, birth1, death1, weather1);

				new CreateAnimal(CreateAnimal.animalTypeToEnum(typeOfAnimal1),oneTurnPopulation);
				Main.totalPopulation=Main.totalPopulation+oneTurnPopulation;

			}
			System.out.println("finished save in appFrame");

		}

		if (source == show){
			this.setVisible(false);
			AppFrame m = new AppFrame();


		}


		if(source == delete){

			String typeOfAnimal1 = animaSpecific.getItemAt(animaSpecific.getSelectedIndex()).toString();
			String month1 = month.getItemAt(month.getSelectedIndex()).toString();
			String year1 = year.getItemAt(year.getSelectedIndex()).toString();
			//int birth1 = Integer.parseInt(birth.getText());
			//int death1 = Integer.parseInt(death.getText());
			//String weather1 =winter.getItemAt(winter.getSelectedIndex()).toString();
			String compar=year1+" "+month1+" "+typeOfAnimal1;
			if(typeOfAnimal1=="Deer"){
				g_delete=new fileDelete("deer",compar);
			}

			if(typeOfAnimal1=="Cow"){
				g_delete=new fileDelete("cow",compar);
			}

			if(typeOfAnimal1=="Horse"){
				g_delete=new fileDelete("horse",compar);
			}



		}
				/*
				if(source == subbutton2){
					String typeOfAnimal1 = animaSpecific.getItemAt(animaSpecific.getSelectedIndex()).toString();


			    	if(typeOfAnimal1=="Deer"){
			    		Datas=table("deer");
			    	}

			    	if(typeOfAnimal1=="Cow"){
			    		Datas=table("cow");
			    	}

			    	if(typeOfAnimal1=="Horse"){
			    		Datas=table("dorse");
			    	}
			    	this.setVisible(false);
					AppFrame m = new AppFrame();



				}

				*/

	}




}


