import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JOptionPane;


public class Line extends JComponent{
	int level = 0;
	
	public void setLevel(){
		String levelStr = JOptionPane.showInputDialog("Enter the number of times to redraw");

		level = Integer.parseInt(levelStr)-1;
	}
	
	public void paint(Graphics g){

		draw(g,level,100,400,100);
	}
	
	private void draw (Graphics g,int lev, int x1, int x2, int y){
		
		int mid1 = x1+((x2-x1)/3);
		int mid2 = x2-((x2-x1)/3);
		
		if (lev == 0){
			g.drawLine(x1,y, x2,y);
		}
		else{
			g.drawLine(x1,y, x2,y);
			draw(g,lev-1,x1,mid1,y+50);
			draw(g,lev-1,mid2,x2,y+50);
		}
	}
}
