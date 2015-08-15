package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import model.*;



import java.util.Arrays;

import javax.swing.*;

import controller.AnimalThread;
import model.*;

import javax.swing.JOptionPane;

public class Initialize extends JFrame implements ActionListener {
	JOptionPane errorMsg;
	JComboBox typef;
	JTextField tot_pop;
	JButton validate,annuler;
	JLabel typel, tot_popl;

	public AnimalType anima;
	public fileWriting write;
	public static fileReadingInit initialPop;
	public static String[] initType;
	public static String[] initPop;
	public static int initialPopCOW,initialPopDEER,initialPopHORSE,total_popInt;
	public Initialize(){
		setTitle("");
		setSize(400,300);
		setLocationRelativeTo(null);
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(3,2));
		typel=new JLabel("Animal Type:");
		typef=new JComboBox();
		typef.addItem("Cow");
		typef.addItem("Deer");
		typef.addItem("Horse");
		tot_popl=new JLabel("Initial population:");
		tot_pop=new JTextField(12);
		annuler=new JButton("Cancel");
		validate=new JButton("Create");

		annuler.addActionListener(this);
		validate.addActionListener(this);
		p.add(typel);
		p.add(typef);
		p.add(tot_popl);
		p.add(tot_pop);
		p.add(annuler);
		p.add(validate);
		setContentPane(p);
		this.pack();//bien regrouper les éléments

	}
	//*******This function is used to check if the data that we are inserting exist or not **
	boolean test;
	public boolean testingInit(String anim){
		test=true;
		initialPop = new fileReadingInit("init_pop");
		initType = initialPop.getTab_init_type();
		initPop = initialPop.getTab_init_pop();
		if(Arrays.asList(initType).contains(anim)){
			test=false;
		}

		return test;
	}
	//*******END This function is used to check if the data that we are inserting exist or not **

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		if(source==annuler){
			this.setVisible(false);
		}

		if(source==validate){

			//***************here we test if the field is filled or not************
			if(tot_pop.getText().equals("") ){

				JOptionPane.showMessageDialog(errorMsg,
						"Fill the initial population");
			}else{


				total_popInt=Integer.parseInt(tot_pop.getText());
				//Animal a=new Animal(0,typef.getText(),total);
				int index=typef.getSelectedIndex();
				String typeAnim=(typef.getItemAt(index)).toString();
				//****************here we test if what we insert exist with the function above********
				if(testingInit("cow")){
					write = new fileWriting("init_pop",typeAnim+" "+total_popInt);
					anima= new AnimalType(total_popInt,typeAnim);
					this.setVisible(false);
					//JOptionPane.showMessageDialog(null, "The animal type is created successfully");
				}else{
					JOptionPane.showMessageDialog(errorMsg,
							"Information on this date already given");
				}


				switch (typeAnim) {
					case "Cow":
						AppFrame.totalPopulationCOW = AppFrame.totalPopulationCOW +total_popInt;
						initialPopCOW=total_popInt;
						break;
					case "Deer":
						AppFrame.totalPopulationDEER = AppFrame.totalPopulationDEER + total_popInt;
						initialPopDEER=total_popInt;
						break;
					case "Horse":
						AppFrame.totalPopulationHORSE = AppFrame.totalPopulationHORSE +total_popInt;
						initialPopHORSE=total_popInt;
						break;
					default:
						System.out.println("Switch in Initialize is not working");
						break;
				}
				Main.totalPopulation=Main.totalPopulation+total_popInt;
				new AnimalDetails("2009","01",CreateAnimal.animalTypeToEnum(typeAnim),total_popInt,0,"Winter");
				new CreateAnimal(CreateAnimal.animalTypeToEnum(typeAnim),total_popInt);


			}
		}

	}

}
