package painter2;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rect extends Shape {

	public Rect(int x1, int y1, int x2, int y2, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);
		// TODO Auto-generated constructor stub
	}
	public Rect(int x1, int y1, int x2, int y2, boolean filled, Color color,Color color2) {
		super(x1, y1, x2, y2, filled, color,color2);
		// TODO Auto-generated constructor stub
	}
	public Rect(int x1, int y1, int x2, int y2, boolean filled, boolean gradient, Color color, Color color2) {
		// TODO 自動產生的建構子 Stub
		super(x1, y1, x2, y2, filled,gradient, color,color2);
	}
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		//g.setColor(color);
		if(gradient) {
			g2d.setPaint(new  GradientPaint(x1,y1,color,x2,y2,color2,true));
		}else {
			g2d.setColor(color);
		}
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
