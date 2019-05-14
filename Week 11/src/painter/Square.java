package painter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends Rect {

	// protected int adjustX2, adjustY2;

	public Square(int x1, int y1, int x2, int y2, boolean filled, Color color, Color color2, boolean gradient,
			float stroke) {
		super(x1, y1, x2, y2, filled, color, color2, gradient, stroke);
		adjustX2Y2();
	}

	void adjustX2Y2() {
		int type = 1;
		int w = Math.abs(x1 - x2);
		int x = x2 - x1;
		int h = Math.abs(y1 - y2);
		int y = y2 - y1;

		// determine 4 different cases
		if (x1 <= x2 && y1 <= y2)
			type = 1; // up left to down right
		else if (x1 >= x2 && y1 >= y2)
			type = 2; // down right to up left
		else if (x1 <= x2 && y1 >= y2)
			type = 3; // down left to up right
		else if (x1 >= x2 && y1 <= y2)
			type = 4; // up right to down left

		switch (type) {
		case 1:
		case 2:
			System.out.printf("in: %d %d %d %d\n", x1, y1, x2, y2);
			if (w >= h)
				x2 = x1 + y;
			else
				y2 = y1 + x;
			System.out.printf("out: %d %d %d %d\n", x1, y1, x2, y2);
			break;
		case 3:
		case 4:
			if (w >= h)
				x2 = x1 - y;
			else
				y2 = y1 - x;
			break;
		}

	}

	@Override
	public void draw(Graphics g) {
		adjustX2Y2();
		Graphics2D g2d = (Graphics2D) g;
		if (gradient)
			g2d.setPaint(new GradientPaint(x1, y1, color, x2, y2, color2, true));
		else
			g2d.setPaint(color);
		g2d.setStroke(new BasicStroke(stroke));
		if (filled) {
			g2d.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
		} else {
			g2d.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
		}
	}

	@Override
	public String toString() {
		return "Square [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", filled=" + filled + ", gradient="
				+ gradient + ", color=" + color + ", color2=" + color2 + ", stroke=" + stroke + "]";
	}

}
