package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

	private Shape shapes[];
	private Shape currentShape;
	final int MAX = 100;
	private int shapeCount;
	private int x1, y1, x2, y2;
	private boolean filled;
	private boolean gradient;
	float stroke = 2;
	private Color color = Color.BLUE;
	private Color color2 = Color.RED;

	private int numTypes = 4;
	final int RECT = 1;
	final int OVAL = 2;
	final int VTRI = 3;
	final int LINE = 4;
	final int SQUARE = 5;
	final int CIRCLE = 6;

	private int shapeType = RECT;

	private int type;

	final int UpLeft = 1;
	final int UpRight = 2;
	final int DownLeft = 3;
	final int DownRight = 4;

	Random rand;

	public DrawPanel() {
		super();
		shapes = new Shape[MAX];
		rand = new Random();
		addMouseListener(this);
		addMouseMotionListener(this);
		// randgen(15);

	}

	void resetAllData() {
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		filled = false;
		gradient = false;
		color = Color.BLUE;
		color2 = Color.RED;
		shapeType = RECT;
	}

	public void clear() {
		shapeCount = 0;
		resetAllData();
		repaint();
	}

	public void undo() {
		if (shapeCount <= 0) {
			JOptionPane.showMessageDialog(null, "Nothing to undo", "Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			shapeCount--;
			repaint();
		}
	}

	public void redo() {
		try {
		if (shapes[shapeCount] == null || shapeCount==0 ) {
			JOptionPane.showMessageDialog(null, "Nothing to redo", "Warning", JOptionPane.WARNING_MESSAGE);
		} else {
			shapeCount++;
			repaint();
		}
		}catch(ArrayIndexOutOfBoundsException e)
		{
			JOptionPane.showMessageDialog(null, "Nothing to redo", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void setShapeType(int shapeType) {
		this.shapeType = shapeType;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setColor2(Color color2) {
		System.out.println("setColor2()" + color2);
		this.color2 = color2;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public void setGradient(boolean gradient) {
		this.gradient = gradient;
	}

	public void setStroke(float stroke) {
		this.stroke = stroke;
	}

	public void randgen(int n) {
		int x1, y1, x2, y2;
		int type, shapeType = 1;
		Color color = Color.BLUE, color2 = Color.RED;
		boolean filled, gradient;
		float stroke = 1;
		try {
			for (int i = 0; i < n; i++) {
				x1 = rand.nextInt(600);
				y1 = rand.nextInt(600);
				x2 = rand.nextInt(600);
				y2 = rand.nextInt(600);
				type = rand.nextInt(4) + 1;
				filled = rand.nextBoolean();
				gradient = rand.nextBoolean();
				stroke = rand.nextFloat() * 20 + 1;
				color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
				color2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
				shapeType = rand.nextInt(numTypes) + 1;
				switch (shapeType) {
				case RECT:
					shapes[shapeCount++] = new Rect(x1, y1, x2, y2, filled, color, color2, gradient, stroke);
					break;
				case OVAL:
					shapes[shapeCount++] = new Oval(x1, y1, x2, y2, filled, color, color2, gradient, stroke);
					break;
				case VTRI:
					shapes[shapeCount++] = new Vtri(x1, y1, x2, y2, type, filled, color, color2, gradient);
					break;
				case LINE:
					shapes[shapeCount++] = new Line(x1, y1, x2, y2, stroke, color, color2, gradient);
					break;

				}

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Shape count has reached MAX count", "Warning",
					JOptionPane.WARNING_MESSAGE);
		}
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// g.setColor(Color.blue);
		// g.fillRect(100,100,200,100);
		for (int i = 0; i < shapeCount; i++) {
			shapes[i].draw(g);
			System.out.println(shapes[i]);
		}
		if (currentShape != null) {
			currentShape.draw(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		x2 = x1;
		y2 = y1;
		// filled = rand.nextBoolean();
		switch (shapeType) {
		case RECT:
			// System.out.println("mousePressed(): " + color2);
			currentShape = new Rect(x1, y1, x2, y2, filled, color, color2, gradient, stroke);
			// System.out.println("currentShape: " + currentShape);
			break;
		case OVAL:
			currentShape = new Oval(x1, y1, x2, y2, filled, color, color2, gradient, stroke);
			break;
		case VTRI:

			break;
		case LINE:
			currentShape = new Line(x1, y1, x2, y2, stroke, color, color2, gradient);
			break;
		case SQUARE:
			currentShape = new Square(x1, y1, x2, y2, filled, color, color2, gradient, stroke);
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		switch (shapeType) {
		case RECT:
			shapes[shapeCount++] = new Rect(x1, y1, x2, y2, filled, color, color2, gradient, stroke);
			break;
		case OVAL:
			shapes[shapeCount++] = new Oval(x1, y1, x2, y2, filled, color, color2, gradient, stroke);
			break;
		case VTRI:

			break;
		case LINE:
			shapes[shapeCount++] = new Line(x1, y1, x2, y2, stroke, color, color2, gradient);
			break;
		case SQUARE:
			shapes[shapeCount++] = new Square(x1, y1, x2, y2, filled, color, color2, gradient, stroke);
			break;
		}
		currentShape = null;
		repaint();

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentShape.x2 = e.getX();
		currentShape.y2 = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
