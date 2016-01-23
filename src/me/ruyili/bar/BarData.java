package me.ruyili.bar;

import java.awt.*;

import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;



public class BarData{
	
	static final JFormattedTextField val1 = new JFormattedTextField(NumberFormat.getNumberInstance());
	static final JTextField type1 = new JTextField("Type 1");
	static final JTextField cat1 = new JTextField("Category 1");
	
	static final JFormattedTextField val2 = new JFormattedTextField(NumberFormat.getNumberInstance());
	static final JTextField type2 = new JTextField("Type 2");
	static final JTextField cat2 = new JTextField("Category 2");
	
	static final JFormattedTextField val3 = new JFormattedTextField(NumberFormat.getNumberInstance());
	static final JTextField type3 = new JTextField("Type 3");
	static final JTextField cat3 = new JTextField("Category 3");
	
	static final JFormattedTextField val4 = new JFormattedTextField(NumberFormat.getNumberInstance());
	static final JTextField type4 = new JTextField("Type 4");
	static final JTextField cat4 = new JTextField("Category 4");
	
	static final JFormattedTextField val5 = new JFormattedTextField(NumberFormat.getNumberInstance());
	static final JTextField type5 = new JTextField("Type 5");
	static final JTextField cat5 = new JTextField("Category 5");
	
	static JTextField title = new JTextField("Title of graph...");
	static JTextField xlabel = new JTextField("X-Label...");
	static JTextField ylabel = new JTextField("Y-Label...");
	
	public static void main(String[] args){
		final JFrame f = new JFrame("Bar Graph Data - EasyBar");
		//only height resizable
		f.addComponentListener(new ComponentAdapter() {

		    @Override
		    public void componentResized(ComponentEvent e) {
		        f.setSize(new Dimension(250, f.getHeight()));
		        super.componentResized(e);
		    }

		});
		val1.setText("1");
		val2.setText("2");
		val3.setText("3");
		val4.setText("4");
		val5.setText("5");
		f.setSize(250, 700);
		final JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		f.setLocationRelativeTo(null);
		JLabel graphDataLabel = new JLabel("Graph Data");
		JLabel values = new JLabel("Values(Max 5)");
		graphDataLabel.setFont(new Font("Ubuntu", Font.BOLD, 30));
		values.setFont(new Font("Ubuntu", Font.BOLD, 30));

		title.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		xlabel.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		ylabel.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		
		JButton createGraph = new JButton("Create Graph");
		createGraph.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		

		final BarGUI gu = new BarGUI();
		//create the graph!
		createGraph.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText().replace(",",""));
				val2.setText(val2.getText().replace(",",""));
				val3.setText(val3.getText().replace(",",""));
				val4.setText(val4.getText().replace(",",""));
				val5.setText(val5.getText().replace(",",""));
				gu.createData();         
				gu.setTitleName(title.getText());
				gu.setYLabel(ylabel.getText());
				gu.setXLabel(xlabel.getText());
				gu.setVisible(true);
				gu.revalidate();
			}
			
		});
		
		//close gui when closing data
		f.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent e) {
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				gu.dispatchEvent(new WindowEvent(gu, WindowEvent.WINDOW_CLOSING));
			}

			@Override
			public void windowClosing(WindowEvent e) {
				gu.dispatchEvent(new WindowEvent(gu, WindowEvent.WINDOW_CLOSING));
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
		});
		f.add(p);
		p.add(graphDataLabel);
		p.add(title);
		p.add(xlabel);
		p.add(ylabel);
		p.add(values);
		p.add(val1);
		p.add(type1);
		p.add(cat1);
		p.add(val2);
		p.add(type2);
		p.add(cat2);
		p.add(val3);
		p.add(type3);
		p.add(cat3);
		p.add(val4);
		p.add(type4);
		p.add(cat4);
		p.add(val5);
		p.add(type5);
		p.add(cat5);
        
		p.add(createGraph);
		//visiblity at the end is best
		f.setVisible(true);
		f.revalidate();
		p.revalidate();
		
	}

}
