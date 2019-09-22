import java.awt.*;


import javax.swing.*;


public class Driver {

	public static String Fractal;
	public static int choice;
	public static int bla=4;
	public void setLevel(){
		
		String[] options = {"Dust","Dragon Curve","Koch Curve","Mandelbrot",
				"Julia Set","Sierpinksi's Triangle","Buddhabrot","Tree"};
		choice = JOptionPane.showOptionDialog(null, "Which Fractal", "Fractal", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
				null, options, options[0]);
	}
	
	public static void main(String[] args) {


		JFrame frame = new JFrame (Fractal);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Driver d = new Driver();
		d.setLevel();
		
		boolean Dust = choice==0;
		boolean Dragon = choice==1;
		boolean Koch = choice==2;
		boolean Brot = choice==3;
		boolean Julia = choice==4;
		boolean Triangle = choice==5;
		boolean Buddha = choice==6;
		boolean Tree = choice==7;
		
		
		
		
		//runs the chosen fractal
		if(Dragon){
			
			DragonCurve2 f = new DragonCurve2();
			f.setLevel();
			
			frame.setBackground(Color.black);
			
			frame.setPreferredSize(new Dimension(1000,1000));
			
			frame.getContentPane().add(f);
			
			frame.pack();
			frame.setVisible(true);
		}
		if(Koch){
			KochCurve f = new KochCurve();
			f.setLevel();
			
			frame.setPreferredSize(new Dimension(500,500));
			
			frame.getContentPane().add(f);
			
			frame.pack();
			frame.setVisible(true);
		}
		if(Dust){
			Line f = new Line();
			f.setLevel();
			
			frame.setPreferredSize(new Dimension(500,500));
			
			frame.getContentPane().add(f);
			
			frame.pack();
			frame.setVisible(true);
		}
		if(Brot){
			Point2D f = new Point2D();
			
			frame.setPreferredSize(new Dimension(f.size,f.size));
			
			frame.getContentPane().add(f);
			
			frame.pack();
			frame.setVisible(true);
			
			f.Sean();
		}
		if(Julia){
			JFrame f =new JFrame();
	        f.setSize(1920,1080);
	        f.setResizable(false);
	        jpanel jp = new jpanel();
	        Container c = f.getContentPane();
	        c.add(jp);
	        f.setVisible(true);
	        f.setFocusable(true);
	        while(true){
	        	jp.repaint();
	        	try {
					Thread.sleep(4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }
		}
		if(Triangle){
			SierpinskiTriangle f = new SierpinskiTriangle();
			f.setLevel();
			
			frame.setPreferredSize(new Dimension(500,500));
			
			frame.getContentPane().add(f);
			
			frame.pack();
			frame.setVisible(true);
		}
		if(Buddha) {
			JFrame frame1 = new JFrame ("Buddhabrot");
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			RandomBuddhabrot f = new RandomBuddhabrot();
			
			frame1.setBackground(Color.black);
			
			frame1.setPreferredSize(new Dimension(f.sizex,f.sizey));
			
			frame1.getContentPane().add(f);
			
			frame1.pack();
			frame1.setVisible(true);
			
			f.start();
			f.repaint();
		}
		if(Tree) {
			Tree f = new Tree();
			f.setLevel();
			
			frame.setPreferredSize(new Dimension(1000,700));
			
			frame.getContentPane().add(f);
			
			frame.pack();
			frame.setVisible(true);
		}

	}

}
