import java.awt.Graphics;

import javax.swing.*;

public class Tree extends JComponent{

	int level = 0;
	double angleChange1 = 17;
	double angleChange2 = 35;
	double lengthChange = 0.7;
	
	public void setLevel(){
		
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		JTextField field3 = new JTextField();
		Object[] message = {
		    "Enter an angle:", field1,
		    "Enter an angle:", field2,
		    "Enter the number of times to redraw:", field3,
		};
		int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION)
		{
		    String value1 = field1.getText();
		    String value2 = field2.getText();
		    String value3 = field3.getText();
		    
		    angleChange1 = Integer.parseInt(value1);
		    angleChange2 = Integer.parseInt(value2);
		    level = Integer.parseInt(value3)-1;
		}
		
	}
	public void paint(Graphics g){
		drawTree(g,level,500,650,150,180);
	}
	private void drawTree (Graphics g,int lev, int startx, int starty, double length, double angle){
		int endx = startx + (int)(Math.sin((angle*Math.PI)/180)*length);
		int endy = starty + (int)(Math.cos((angle*Math.PI)/180)*length);
		
		//angleChange1 = (int) (Math.random()*50)+10;
		//angleChange2 = (int) (Math.random()*50)+10;
		
		
		if(lev==0) {
			g.drawLine(startx, starty, endx, endy);
		}
		else {
			g.drawLine(startx, starty, endx, endy);
			
			drawTree(g, lev-1, endx, endy, length*lengthChange, angle+angleChange1);
			drawTree(g, lev-1, endx, endy, length*lengthChange, angle-angleChange2);
		}
	
	}
}
