package painter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Shape {

	public Line(int x1, int y1, int x2, int y2, float stroke, Color color, Color color2, boolean gradient) {
		super(x1, y1, x2, y2, stroke, color, color2, gradient);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (gradient)
			g2d.setPaint(new GradientPaint(x1, y1, color, x2, y2, color2, true));
		else
			g2d.setPaint(color);
		g2d.setStroke(new BasicStroke((float) stroke));
		g2d.drawLine(x1, y1, x2, y2);
	}

	@Override
	public String toString() {
		return "Line [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", filled=" + filled + ", gradient="
				+ gradient + ", color=" + color + ", color2=" + color2 + ", stroke=" + stroke + "]";
	}

}
