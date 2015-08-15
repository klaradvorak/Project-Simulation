package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.AppFrame;
import controller.Calculation;

import java.awt.Color;
import java.awt.Component;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
//import org.jfree.ui.Spacer;



public class LineChart extends JFrame {

	private static final long serialVersionUID = 1L;

	public ChartPanel chartPanel;

	public LineChart ( String chartTitle) {
		super();
		//this will create the dataset
		XYDataset dataset = createDataset();

		//based on the dataset we create the chart
		JFreeChart chart = createChart(dataset , chartTitle);

		// we put chart into a panel

		chartPanel = new ChartPanel(chart);
	}

	private XYDataset createDataset() {

		//initialize the axis for each animal graph
		String tabXCow[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
		String tabXDeer[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
		String tabXHorse[]={"1","2","3","4","5","6","7","8","9","10","11","12"};

		//initialize thetota population of each animal
		int tabYCow[]={0,0,0,0,0,0,0,0,0,0,0,0};
		int tabYDeer[]={0,0,0,0,0,0,0,0,0,0,0,0};
		int tabYHorse[]={0,0,0,0,0,0,0,0,0,0,0,0};

		//initialize the initial populations
		String tabIniCow[]={"Cow","0"};
		String tabIniDeer[]={"Deer","0"};
		String tabIniHorse[]={"Horse","0"};


		try{
			Calculation cordYCow=new Calculation("cow");
			tabXCow=cordYCow.getTab_split_month(); // we get all the month saved in the file for cow
			tabYCow=cordYCow.getTab_tot_pop();// we get all the total population saved in the file for cow
			tabIniCow=cordYCow.getTab_split_init();// we get the initial population saved in the file for cow

			Calculation cordYDeer=new Calculation("deer");
			tabXDeer=cordYDeer.getTab_split_month();
			tabYDeer=cordYDeer.getTab_tot_pop();
			tabIniDeer=cordYDeer.getTab_split_init();

			Calculation cordYHorse=new Calculation("horse");
			tabXHorse=cordYHorse.getTab_split_month();
			tabYHorse=cordYHorse.getTab_tot_pop();
			tabIniHorse=cordYHorse.getTab_split_init();
		}catch(Exception e)
		{


		}

		XYSeries series1 = new XYSeries("Cow");
		int initCow=Integer.parseInt(tabIniCow[1]);// we get the total population of cow
		int XCow=0;// we start the graph on axis=0 with the initial population
		//int i1=0;
		for(int i1=0;i1<=tabYCow.length;i1++){
			series1.add(XCow, initCow);
			if(i1<tabYCow.length){
				XCow=Integer.parseInt(tabXCow[i1]); //The axis will become the number of the month gotten up
				initCow=tabYCow[i1];//the total population=initial population+the calculation
			}

		}



		XYSeries series2 = new XYSeries("Deer");
		int initDeer=Integer.parseInt(tabIniDeer[1]);
		int XDeer=0;
		//int i2=0;
		for(int i2=0;i2<=tabYDeer.length;i2++){
			series2.add(XDeer,initDeer);
			if(i2<tabYDeer.length){
				XDeer=Integer.parseInt(tabXDeer[i2]);
				initDeer=tabYDeer[i2];
			}

		}


		XYSeries series3 = new XYSeries("Horse");
		int initHorse=Integer.parseInt(tabIniHorse[1]);
		int XHorse=0;
		//int i3=0;
		for(int i3=0;i3<=tabYHorse.length;i3++){
			series3.add(XHorse, initHorse);
			if(i3<tabYHorse.length){
				XHorse=Integer.parseInt(tabXHorse[i3]);
				initHorse=tabYHorse[i3];
			}

		}
	        /*series3.add(3.0, 4.0);
	        series3.add(4.0, 3.0);
	        series3.add(5.0, 2.0);
	        series3.add(6.0, 3.0);
	        series3.add(7.0, 6.0);
	        series3.add(8.0, 3.0);
	        series3.add(9.0, 4.0);
	        series3.add(10.0, 3.0);	*/

		XYSeriesCollection dataset = new XYSeriesCollection();

		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);

		return dataset;


	}

	private JFreeChart createChart(XYDataset dataset, String chartTitle) {

		JFreeChart chart = ChartFactory.createXYLineChart(
				"LineChart Demo 6",
				"X",
				"Y",
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false
		);

		//customize chart
		chart.setBackgroundPaint(Color.WHITE);

		//get a reference to the plot for further customisation..

		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.LIGHT_GRAY);

		plot.setDomainGridlinePaint(Color.WHITE);
		plot.setRangeGridlinePaint(Color.WHITE);

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesLinesVisible(0, true);
		renderer.setSeriesShapesVisible(1, true);
		renderer.setSeriesShapesVisible(2, true);
		plot.setRenderer(renderer);

		// change the auto tick unit selection to integer units only...
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		// OPTIONAL CUSTOMISATION COMPLETED.





		return chart;
	}



	/**
	 *
	 */




}
