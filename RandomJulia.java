import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class RandomJulia extends JPanel{
	private double zoom =300;
	private double width;
	private double height;
	public double pointx;
	public double pointy;
	public int sizex= 1200;
	public int sizey= 1000;
	public int zoomx = 0;
	public int zoomy = -100;	
	public int iterations=2500;
	public double bright =1;
	public 	int[][] stuff = new int[sizex][sizey];
	
	

	public void start(){
		int gx = sizex;
		int gy = sizey;
		
        int count = 0;
        while (count < 10000000) {
        	double x = (Math.random()*sizex);
        	double y = (Math.random()*sizey);
        		System.out.println(count/100000+"%");
            change(iterations,x,y);
            count++;
        }
	}
	
	public boolean check(int i, double x, double y){
		//y*=-1;
		
		double px = x;
		double py = y;
		
		x= (px*px - py*py)+pointx;
		y = (2*px*py)+pointy;
		
		if(y*y+x*x<2){
			if(i>0){
				return check(i-1,x,y);
			}
			return false;
		}
		return true;

		
	}
    public void shade(int i, double x, double y) { 
    	//y*=-1;
    	double px = x;
        double py = y;
        x = (px * px - py * py) + pointx;
        y = (2 * py * px) + pointy;
        
        if(y*y+x*x<2){
        	int tx = (int)(zoom*x-zoomx+sizex/2);
        	int ty = (int)(zoom*y-zoomy+sizey/2);
        	
        	if(tx>=0 && tx<sizey && ty>=0 && ty<sizex){
        		stuff[ty][tx]++;
        	}
        	if(i>0){
        		shade(i-1,x,y);
        	}
        }
    }
	public void change(int i, double x, double y){
        double px = (x - sizex / 2 + zoomx) / zoom;
        double py = (y - sizey / 2 + zoomy) / zoom;
        pointx = 0;
        pointy = 0;
        //if(check(i, pointx, pointy)) 
        	shade(i, px, py);
	}
	
	
	@Override
    //display
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int max = 0;
        for (int x = 0; x < sizex; x++) {
            for (int y = 0; y < sizey; y++) {
                if (stuff[x][y] > max) {
                    max = stuff[x][y];
                }
            }
        }
        for (int x = 0; x < sizex; x++) {
            for (int y = 0; y < sizey; y++) {
                int shade=(int) (bright*stuff[x][y]);
                //int shade = (int) (255 * plane[x][y] / max);
                try {
                    g.setColor(new Color(shade, shade, shade));
                } catch (Exception e) {
                    g.setColor(new Color(255, 255, 255));
                }
                g.fillRect(x, y, 1, 1);
            }

        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(sizex, sizey);
    }
}
