package me.ruyili.bar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

public class BarGUI extends JFrame{
	
	//variables
	final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	JFreeChart barChart = ChartFactory.createBarChart(      
		BarData.title.getText(), BarData.xlabel.getText(), BarData.ylabel.getText(), createData(),          
		PlotOrientation.VERTICAL,           
		true, true, false); 
	
	//panel
	ChartPanel chartPanel= new ChartPanel(barChart); 
	
	
	//mainframe
	public BarGUI(){
		super("Bar Graph Display - EasyBar");
		      
		chartPanel.setPreferredSize(new java.awt.Dimension(600, 600));  
		setSize(600, 600);
		setContentPane(chartPanel); 
		
		//menu bar
		JMenuBar menubar = new JMenuBar();
		JMenu windowMenu = new JMenu("File");
        windowMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem export = new JMenuItem("Export");
        export.setToolTipText("Export as .png");
        export.setMnemonic(KeyEvent.VK_E);
        export.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileFilter(new FileNameExtensionFilter("Image File(.png)", "png"));
				jfc.setDialogTitle("Export as png...");
				jfc.setAcceptAllFileFilterUsed(false);
				
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	                
	                try {
						createGraphImage(jfc.getSelectedFile().getAbsolutePath());
						JOptionPane.showMessageDialog(chartPanel, "File saving successful! Saved to " + jfc.getSelectedFile().getAbsolutePath() + ".png");
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(chartPanel, "File saving failed!");
					}
	            }
			}
        	
        });
        
		

		menubar.add(windowMenu);
		windowMenu.add(export);
		setJMenuBar(menubar);
		
		
		
	}
	
	//ylabel set method
	public void setYLabel(String ylabel) {
		ValueAxis yAxis = barChart.getCategoryPlot().getRangeAxis();
		yAxis.setLabel(ylabel);
		revalidate();
	}

	//xlabel set method
	public void setXLabel(String xlabel) {
		CategoryAxis xAxis = barChart.getCategoryPlot().getDomainAxis();
		xAxis.setLabel(xlabel);
		revalidate();
	}
	
	//title set method
	public void setTitleName(String title){
		barChart.setTitle(title);
		revalidate();
	}

	//data
	public CategoryDataset createData(){
		dataset.clear();
		dataset.setValue(Double.parseDouble(BarData.val1.getText()), BarData.type1.getText(), BarData.cat1.getText());
		dataset.setValue(Double.parseDouble(BarData.val2.getText()), BarData.type2.getText(), BarData.cat2.getText());
		dataset.setValue(Double.parseDouble(BarData.val3.getText()), BarData.type3.getText(), BarData.cat3.getText());
		dataset.setValue(Double.parseDouble(BarData.val4.getText()), BarData.type4.getText(), BarData.cat4.getText());
		dataset.setValue(Double.parseDouble(BarData.val5.getText()), BarData.type5.getText(), BarData.cat5.getText());
		
		revalidate();
		return dataset;
	}

	
	//png creator method
	public void createGraphImage(String path) throws IOException{
		File pngPath = new File(path); 
	    ChartUtilities.saveChartAsPNG(pngPath, barChart, getWidth(), getHeight());
	}
}
