package painter2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener,MouseMotionListener{

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int type;
	private boolean filled;
	private Color color= Color.BLUE;;
	private Color color2= Color.RED;
	private int countshape;
	private int shapeType;
	final int RECT = 1;
	final int OVAL = 2;
	final int VTRI = 3;
	final int DIA = 4;
	final int SQU = 5;
	final int CIR = 6;
	private int numType = 4; 
	private Shape shapes[];
	private Shape currentShape;
	final int MAX = 100;
	Random rand;

	
		

	public DrawPanel() {
		super();
		shapes = new Shape[MAX];
		rand = new Random();
	//	randgen(20);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void randgen(int n) {
		
		for (int i = 0; i < n; i++) {
			x1 = rand.nextInt(600);
			y1 = rand.nextInt(500);
			x2 = rand.nextInt(600);
			y2 = rand.nextInt(400);
			filled = rand.nextBoolean();
		//	type = rand.nextInt(4)+1;
			color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
			color2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
			shapeType = rand.nextInt(numType)+1;
			switch(shapeType)
			{
			case RECT:
				shapes[countshape++] = new Rect(x1, y1, x2, y2, filled, color,color2);
				break;
			case OVAL:
				shapes[countshape++] = new Oval(x1, y1, x2, y2, filled, color,color2);
				break;
			case VTRI:
				shapes[countshape++] = new Vtri(x1, y1, x2, y2,type,filled,color,color2);
				//System.out.println(shapes[countshape-1]);
				break;
			case DIA:
				shapes[countshape++] = new Diamond(x1, y1, x2, y2, filled, color,color2);
				break;
			}
			
		}repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < countshape; i++) {
			shapes[i].draw(g);
			System.out.println(shapes[i]);
		}
		if(currentShape !=null)
		{
			currentShape.draw(g);
		}

	}
	public void clear()
	{
		countshape = 0;
		repaint();
	}
	public void redo()
	{
		countshape ++;
		repaint();
	}
	public void undo()
	{
		countshape -- ;
		repaint();
	}
	public void setShapeType(int shapeType)
	{
		this.shapeType = shapeType;
	}
	public void setColor(Color color)
	{
		this.color = color;
	}
	public void setColor2(Color color2)
	{
		this.color2 = color2;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		x1 = e.getX();
		y1 = e.getY();
		x2 = x1;
		y2 = y1;
		type =1;
		filled = rand.nextBoolean();
		switch(shapeType) {
		case RECT:
			currentShape = new Rect(x1,y1,x2,y2,filled,color,color2);
			break;
		case VTRI:
			currentShape = new Vtri(x1, y1, x2, y2,type,filled, color,color2);
			break;	
		case OVAL:
			currentShape = new Oval(x1, y1, x2, y2, filled, color,color2);
			break;
		case SQU:
			currentShape = new Square(x1,y1,x2,y2,filled, color);
			break;
		case CIR:
			currentShape = new Cir(x1,y1,x2,y2,filled, color);
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		x2 = e.getX();
		y2 = e.getY();
	
		switch(shapeType)
		{
		case RECT:
			shapes[countshape++] = new Rect(x1, y1, x2, y2, filled, color,color2);
			break;
		case VTRI:
			shapes[countshape++] = new Vtri(x1, y1, x2, y2,type, filled, color,color2);
			break;
		case OVAL:
			shapes[countshape++] = new Oval(x1, y1, x2, y2, filled, color,color2);
			break;
		case SQU:
			shapes[countshape++] = new Square(x1,y1,x2,y2,filled, color);
			break;
		case CIR:
			shapes[countshape++] = new Cir(x1,y1,x2,y2,filled, color);
			break;
		}
		currentShape = null;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
			
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
		currentShape.x2 = e.getX();
		currentShape.y2 = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}
}
