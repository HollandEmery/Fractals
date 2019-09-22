import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class SierpinskiTriangle extends JComponent{
	
	int level = 0;

	public void setLevel(){
		String levelStr = JOptionPane.showInputDialog("Enter the number of times to redraw");

		level = Integer.parseInt(levelStr);
	}

	public void paint(Graphics g){

		drawTriangle(g,level,250,0,50,400,450,400);

	}

	private void drawTriangle (Graphics g, int lev, int x1, int y1, int x2, int y2, int x3, int y3){
		int[] xPoints = {x1,x2,x3};
		int[] yPoints = {y1,y2,y3};
		
		int x4 =(x1+x3)/2;
		int x5 =(x1+x2)/2;
		int x6 =(x2+x3)/2;
		
		int y4 =(y1+y3)/2;
		int y5 =(y1+y2)/2;
		int y6 =(y2+y3)/2;
		
		if (lev == 0){
			g.drawPolygon(xPoints, yPoints, 3);
		}
		else{
			drawTriangle(g,lev-1,x1,y1,x4,y4,x5,y5);
			drawTriangle(g,lev-1,x4,y4,x3,y3,x6,y6);
			drawTriangle(g,lev-1,x5,y5,x6,y6,x2,y2);
		}
	}
	
}
