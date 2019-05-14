package painter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Vtri extends Shape {

	private int type;

	final int UpLeft = 1;
	final int UpRight = 2;
	final int DownLeft = 3;
	final int DownRight = 4;

	public Vtri(int x1, int y1, int x2, int y2, int type, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public Vtri(int x1, int y1, int x2, int y2, int type, boolean filled, Color color, Color color2) {
		super(x1, y1, x2, y2, filled, color, color2);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public Vtri(int x1, int y1, int x2, int y2, int type, boolean filled, Color color, Color color2, boolean gradient) {
		super(x1, y1, x2, y2, filled, color, color2, gradient);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public void draw(Graphics g) {

		int tx1 = Math.min(x1, x2);
		int ty1 = Math.min(y1, y2);
		int tx4 = Math.max(x1, x2);
		int ty4 = Math.max(y1, y2);
		int tx2 = tx4;
		int ty2 = ty1;
		int tx3 = tx1;
		int ty3 = ty4;

		int x[] = null;
		int y[] = null;

		switch (type) {
		case UpLeft:
			x = new int[] { tx1, tx3, tx4 };
			y = new int[] { ty1, ty3, ty4 };
			break;
		case UpRight:
			x = new int[] { tx2, tx3, tx4 };
			y = new int[] { ty2, ty3, ty4 };
			break;
		case DownLeft:
			x = new int[] { tx1, tx2, tx3 };
			y = new int[] { ty1, ty2, ty3 };
			break;
		case DownRight:
			x = new int[] { tx1, tx2, tx4 };
			y = new int[] { ty1, ty3, ty4 };
			break;
		}

		Graphics2D g2d = (Graphics2D) g;
		if (gradient)
			g2d.setPaint(new GradientPaint(x1, y1, color, x2, y2, color2, true));
		else
			g2d.setPaint(color);
		g2d.setStroke(new BasicStroke(stroke));

		if (filled) {
			g.fillPolygon(x, y, 3);
		} else {
			g.drawPolygon(x, y, 3);
		}
	}

	@Override
	public String toString() {
		return "Vtri [type=" + type + ", x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", filled=" + filled
				+ ", color=" + color + "]";
	}

}
