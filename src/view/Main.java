package view;

import model.Map;
import org.jfree.ui.RefineryUtilities;


public class Main {
	public static int timePeriod=100;//730
	public static String path;
	public static int totalPopulation;

	    public static void main (String[] args) {
			path="configFile/maps/FinalTerrainScaled2x2m.png";
			Map map =new Map(path);
	    	
	    	     new AppFrame();
	    	     
	    	       // LineChart demo = new LineChart("Line Chart Demo 6");


			// Initialize ini=  new Initialize();
	            // ini.setVisible(true);
	               
	     }
	       
	      
}



