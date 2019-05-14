package painter2;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape {

	public Rect(int x1, int y1, int x2, int y2, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		g.setColor(color);
		if (filled) {
			g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));

		} else {
			g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
		}
	}

	@Override
	public String toString() {
		return "Rect [x1=" + x1 + ", x2=" + x2 + ", y1=" + y1 + ", y2=" + y2 + ", filled=" + filled + ", color=" + color
				+ "]";
	}


}
