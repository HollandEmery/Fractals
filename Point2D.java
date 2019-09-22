import java.awt.*;

import javax.swing.*;

public class Point2D extends JComponent{

	
	//Multi-Dimensional Arrays
	private double[][][] C = new double[1000][1000][2];
	private double zoom =1;
	private double width;
	private double pointy=.1;
	private double pointx=-.75;
	public 	int[][] stuff = new int[1000][1000];
	public  int size = 1000; 

	public void Sean(){

		for(int w = 0; w<1000;w++){
			for(int y =0;y<1000;y++){
				for(int x = 0;x<1000;x++){
					double a = C[y][x][0];
					double b = C[y][x][1];
					width = size/2;
					C[y][x][0]= Math.pow(a, 2)-Math.pow(b, 2)+(y/width)-zoom;
					C[y][x][1]= (2*a*b)+(x/width)-zoom;
					repaint();

					if(Math.pow(C[y][x][0],2)+Math.pow(C[y][x][1]/1000,2)>4){
						stuff[x][y] = w;
					}
				}	
			}
		}		
	}	


	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		for(int y =0;y<1000;y++){
			for(int x = 0;x<1000;x++){

				if(x==size/2&&y==size/2){
					g.setColor(Color.WHITE);
				}
				else if(Math.pow(C[y][x][0],2)+Math.pow(C[y][x][1]/1000,2)<=4){
					g.setColor(Color.black);
				}	
				else{

					//g.setColor(Color.WHITE);
					g.setColor(new Color(stuff[x][y]*325150));

				}
				g.drawLine(y,x,y,x);
			}
		}
	}	
}
