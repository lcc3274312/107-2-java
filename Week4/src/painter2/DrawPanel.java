package painter2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int type;
	private boolean filled;
	private Color color;
	private int countshape;
	private int shapeType;
	final int RECT = 1;
	final int OVAL = 2;
	final int VTRI = 3;
	final int DIA = 4;
	private int numType = 4;

	private Shape shapes[];
	final int MAX = 100;
	Random rand;

	public DrawPanel() {
		super();
		shapes = new Shape[MAX];
		rand = new Random();
		randgen(20);
	}

	public void randgen(int n) {
		
		for (int i = 0; i < n; i++) {
			x1 = rand.nextInt(600);
			y1 = rand.nextInt(500);
			x2 = rand.nextInt(600);
			y2 = rand.nextInt(400);
			filled = rand.nextBoolean();
			type = rand.nextInt(4)+1;
			color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
			shapeType = rand.nextInt(numType)+1;
			switch(shapeType)
			{
			case RECT:
				shapes[countshape++] = new Rect(x1, y1, x2, y2, filled, color);
				break;
			case OVAL:
				shapes[countshape++] = new Oval(x1, y1, x2, y2, filled, color);
				break;
			case VTRI:
				shapes[countshape++] = new Vtri(x1, y1, x2, y2,type, filled, color);
				System.out.println(shapes[countshape-1]);
				break;
			case DIA:
				shapes[countshape++] = new Diamond(x1, y1, x2, y2, filled, color);
				break;
			}
			
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < countshape; i++) {
			shapes[i].draw(g);
			System.out.println(shapes[i]);
		}

	}

}
