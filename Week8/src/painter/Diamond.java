package painter;

import java.awt.Color;
import java.awt.Graphics;

public class Diamond extends Shape {

	public Diamond(int x1, int x2, int y1, int y2, boolean filled, Color color) {
		super(x1, x2, y1, y2, filled, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int z = (x1+x2)/2;
		int u = (y1+y2)/2;
		int []x= {z,x2,z,x1};
		int []y= {y2,u,y1,u};
		
		g.setColor(color);
		if(filled)
		{
		 g.fillPolygon(x, y, 4);
		}
		else
		{
			g.drawPolygon(x,y,4);
		}
		
	

}

	@Override
	public String toString() {
		return "Diamond [x1=" + x1 + ", x2=" + x2 + ", y1=" + y1 + ", y2=" + y2 + ", filled=" + filled + ", color="
				+ color + "]";
	}
}