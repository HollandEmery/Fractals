import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RandomBuddhabrot extends JPanel {
	private double zoom = 230;
	public double pointx;
	public double pointy;
	public int sizex = 900;
	public int sizey = 800;
	public int zoomx = 50;
	public int zoomy = -50;
	public int iterations1 = 1000;
	public int iterations2 = 100;
	public int iterations3 = 10;
	public int color;

	public double randomnum = 10000000;

	public double bright1 = .005;
	// color
	// public double bright =.025;
	public double bright2 = .05;
	public double bright3 = .1;
	public int[][] stuff = new int[sizex][sizey];
	public int[][] stuff2 = new int[sizex][sizey];
	public int[][] stuff3 = new int[sizex][sizey];

	public long starttime;
	public long remaintime;

	public SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");

	public void start() {

		String[] options = { "Black & White", "Color" };

		color = JOptionPane.showOptionDialog(null, "Black & White or Color",
				"Coloring", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		starttime = System.currentTimeMillis();

		int count = 0;
		while (count < randomnum) {
			double x = (Math.random() * sizex);
			double y = (Math.random() * sizey);

			if (((double) (count * 100) / randomnum) % 1 == 0) {
				int time = (int) (System.currentTimeMillis() - starttime);
				remaintime = (long) (starttime
						+ ((time) / (double) ((count) / randomnum)));
				Date resultdate = new Date(remaintime);
				int remain = (int) (((time * randomnum) / count) - time);

				System.out.println("Elapsted Time: " + (String.format(
						"%02d min, %02d sec",
						TimeUnit.MILLISECONDS.toMinutes(time),
						TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES
								.toSeconds(TimeUnit.MILLISECONDS
										.toMinutes(time)))));

				System.out.println(
						"Percent: " + ((count * 100) / randomnum) + "%");

				System.out.println("Estimated Time Remaining "
						+ String.format("%02d min, %02d sec",
								TimeUnit.MILLISECONDS.toMinutes(remain),
								TimeUnit.MILLISECONDS.toSeconds(remain)
										- TimeUnit.MINUTES
												.toSeconds(TimeUnit.MILLISECONDS
														.toMinutes(remain))));

				System.out.println(sdf.format(resultdate));
			}
			change(iterations1, iterations2, iterations3, x, y);
			count++;
		}
	}

	public void change(int i, int i2, int i3, double x, double y) {
		pointx = (x - sizex / 2 + zoomx) / zoom;
		pointy = (y - sizey / 2 + zoomy) / zoom;

		if (check(i, pointx, pointy))
			shade(i, pointx, pointy);

		// color
		if (color == 1) {
			if (check(i2, pointx, pointy))
				shade2(i2, pointx, pointy);

			if (check(i3, pointx, pointy))
				shade3(i3, pointx, pointy);
		}
		// */
	}

	public boolean check(int i, double x, double y) {
		// y*=-1;

		double px = x;
		double py = y;

		x = (px * px - py * py) + pointx;
		y = (2 * px * py) + pointy;

		if (y * y + x * x < 2) {
			if (i > 0) {
				return check(i - 1, x, y);
			}
			return false;
		}
		return true;

	}

	public void shade(int i, double x, double y) {
		// y*=-1;
		double px = x;
		double py = y;
		x = (px * px - py * py) + pointx;
		y = (2 * py * px) + pointy;

		if (y * y + x * x < 2) {
			int tx = (int) (zoom * x - zoomx + sizex / 2);
			int ty = (int) (zoom * y - zoomy + sizey / 2);

			if (tx >= 0 && tx < sizey && ty >= 0 && ty < sizex) {
				stuff[ty][tx]++;
			}
			if (i > 0) {
				shade(i - 1, x, y);
			}
		}
	}

	public void shade2(int i, double x, double y) {
		// y*=-1;
		double px = x;
		double py = y;
		x = (px * px - py * py) + pointx;
		y = (2 * py * px) + pointy;

		if (y * y + x * x < 2) {
			int tx = (int) (zoom * x - zoomx + sizex / 2);
			int ty = (int) (zoom * y - zoomy + sizey / 2);

			if (tx >= 0 && tx < sizey && ty >= 0 && ty < sizex) {
				stuff2[ty][tx]++;
			}
			if (i > 0) {
				shade2(i - 1, x, y);
			}
		}
	}

	public void shade3(int i, double x, double y) {
		// y*=-1;
		double px = x;
		double py = y;
		x = (px * px - py * py) + pointx;
		y = (2 * py * px) + pointy;

		if (y * y + x * x < 2) {
			int tx = (int) (zoom * x - zoomx + sizex / 2);
			int ty = (int) (zoom * y - zoomy + sizey / 2);

			if (tx >= 0 && tx < sizey && ty >= 0 && ty < sizex) {
				stuff3[ty][tx]++;
			}
			if (i > 0) {
				shade3(i - 1, x, y);
			}
		}
	}

	@Override
	// display
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int max1 = 0;
		int max2 = 0;
		int max3 = 0;
		for (int x = 0; x < sizex; x++) {
			for (int y = 0; y < sizey; y++) {
				if (stuff[x][y] > max1) {
					max1 = stuff[x][y];

				}
				if (stuff2[x][y] > max2) {
					max2 = stuff2[x][y];

				}
				if (stuff3[x][y] > max3) {
					max3 = stuff3[x][y];

				}
			}
		}
		System.out.println(max1 + ", " + max2 + ", " + max3);

		bright1 = 350.0 / (double) (max1);
		bright2 = 350.0 / (double) (max2);
		bright3 = 350.0 / (double) (max3);
		for (int x = 0; x < sizex; x++) {
			for (int y = 0; y < sizey; y++) {
				int shade1 = (int) (bright1 * stuff[x][y]);
				int shade2 = (int) (bright2 * stuff2[x][y]);
				int shade3 = (int) (bright3 * stuff3[x][y]);
				try {
					// black and white
					if (color == 0) {
						g.setColor(new Color(shade1, shade1, shade1));
					}
					// color
					if (color == 1) {
						g.setColor(new Color(shade3, shade2, shade1));
					}

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
