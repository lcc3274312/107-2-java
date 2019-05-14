package painter1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private boolean filled;
	private Color color;
	private int countshape;

	private Shape shapes[];
	final int MAX = 100;
	Random rand;

	public DrawPanel() {
		super();
		shapes = new Shape[MAX];
		rand = new Random();
		randgen(5);
	}

	public void randgen(int n) {
		for (int i = 0; i < n; i++) {
			x1 = rand.nextInt(600);
			y1 = rand.nextInt(500);
			x2 = rand.nextInt(600);
			y2 = rand.nextInt(400);
			filled = rand.nextBoolean();
			color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
			shapes[countshape++] = new Rect(x1, y1, x2, y2, filled, color);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// g.setColor(Color.blue);
		// g.fillRect(100, 100, 200, 100);
		for (int i = 0; i < countshape; i++) {
			shapes[i].draw(g);
		}

	}

}
