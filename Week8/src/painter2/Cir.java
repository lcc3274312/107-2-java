package painter2;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Cir extends Shape {
	public Cir(int x1, int y1, int x2, int y2, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(Graphics g) {
		// TODO 自動產生的方法 Stub
		Graphics2D g2d = (Graphics2D)g;
		//g.setColor(color);
		g2d.setPaint(new  GradientPaint(x1,y1,color,x2,y2,color2,true));
		if (filled) {
			g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(y1 - y2), Math.abs(y1 - y2));

		} else {
			g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(y1 - y2), Math.abs(y1 - y2));
		}
	}
	public String toString() {
		return "Cir [x1=" + x1 + ", x2=" + x2 + ", y1=" + y1 + ", y2=" + y2 + ", filled=" + filled + ", color=" + color
				+ "]";
	}

}
