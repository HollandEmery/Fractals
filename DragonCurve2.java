import java.awt.*;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class DragonCurve2 extends JComponent {
	int level = 0;
	int count = 0;
	int zoom = 500;
	ArrayList<Double> listx = new ArrayList<Double>();
	ArrayList<Double> listy = new ArrayList<Double>();

	public void setLevel() {
		String levelStr = JOptionPane.showInputDialog("Enter the number of times to redraw(Max 20)");

		level = Integer.parseInt(levelStr);

		if(level>20)
			level = 20;
		
		listx.add(0.0);
		listx.add(1.0);
		listy.add(0.0);
		listy.add(0.0);

	}

	public void paint(Graphics g) {
		setBackground(Color.BLACK);

		drawDragon(g, level, listx, listy);

	}

	private void drawDragon(Graphics g, int level, ArrayList<Double> listx, ArrayList<Double> listy) {
		ArrayList<Double> numbersx = new ArrayList<Double>();
		ArrayList<Double> numbersy = new ArrayList<Double>();

		g.setColor(Color.black);
		g.fillRect(0, 0, 1500, 1000);

		System.out.println(level);

		int r = 255, gr = 0, b = 0;

		if (level == 0) {
			for (int i = 0; i < listx.size() - 1; i++) {
				double sx = (listx.get(i) * zoom) + 300;
				double ex = (listx.get(i + 1) * zoom) + 300;
				double sy = (listy.get(i) * zoom) + 300;
				double ey = (listy.get(i + 1) * zoom) + 300;

				int y = listx.size() / (255 * 5);
				if (count % (y + 1) == 0) {
					if (r == 255 && gr < 255 && b == 0) {
						gr++;
					} else if (r > 0 && gr == 255 && b == 0) {
						r--;
					} else if (r == 0 && gr == 255 && b < 255) {
						b++;
					} else if (r == 0 && gr > 0 && b == 255) {
						gr--;
					} else if (r < 255 && gr == 0 && b == 255) {
						r++;
					} else if (r == 255 && gr == 0 && b > 0) {
						b--;
					}
				}

				count++;

				g.setColor(new Color(r, gr, b));

				g.drawLine((int) sx, (int) sy, (int) ex, (int) ey);
			}
		} else {

			for (int i = 0; i < listx.size() - 1; i++) {
				double sx = (listx.get(i) * zoom) + 300;
				double ex = (listx.get(i + 1) * zoom) + 300;
				double sy = (listy.get(i) * zoom) + 300;
				double ey = (listy.get(i + 1) * zoom) + 300;

				int y = listx.size() / (255 * 5);
				if (count % (y + 1) == 0) {
					if (r == 255 && gr < 255 && b == 0) {
						gr++;
					} else if (r > 0 && gr == 255 && b == 0) {
						r--;
					} else if (r == 0 && gr == 255 && b < 255) {
						b++;
					} else if (r == 0 && gr > 0 && b == 255) {
						gr--;
					} else if (r < 255 && gr == 0 && b == 255) {
						r++;
					} else if (r == 255 && gr == 0 && b > 0) {
						b--;
					}
				}

				count++;

				g.setColor(new Color(r, gr, b));

				g.drawLine((int) sx, (int) sy, (int) ex, (int) ey);
			}

			for (int i = 0; i < listx.size(); i++) {
				double x = listx.get(i);
				double y = listy.get(i);

				double x1 = (x - y) / 2;
				double y1 = (x + y) / 2;

				numbersx.add(x1);
				numbersy.add(y1);
			}

			for (int i = listx.size() - 1; i >= 0; i--) {
				double x = listx.get(i);
				double y = listy.get(i);

				double x2 = 1 - ((x + y) / 2);
				double y2 = (x - y) / 2;

				numbersx.add(x2);
				numbersy.add(y2);
			}
			drawDragon(g, level - 1, numbersx, numbersy);
		}
	}
}
