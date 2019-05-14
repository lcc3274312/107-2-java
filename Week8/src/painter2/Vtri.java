package painter2;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Vtri extends Shape {

	private int type;
	final int upleft = 1;
	final int upright = 2;
	final int downleft = 3;
	final int downright = 4;
	public Vtri(int x1, int y1, int x2, int y2,int type, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public Vtri(int x1, int y1, int x2, int y2,int type, boolean filled, Color color,Color color2) {
		super(x1, y1, x2, y2, filled, color,color2);
		this.type = type;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		//g.setColor(color);
		
		int a1=Math.min(x1, x2);
		int b1=Math.min(y1, y2);
		int a4 = Math.max(x1, x2);
		int b4 = Math.max(y1, y2);
		int a2 = a4;
		int b2 = b1;
		int a3 = a1;
		int b3 = b4;
		
		int []x = null;
	    int []y = null;
	    if(x1<x2 && y1<y2)
		{
			type =1;
		}
		else if(x1>x2 && y1<y2)
		{
			type = 2;
		}
		else if(x1>x2 && y1>y2)		
		{
			type = 3;
		}
		else if(x1<x2 && y1>y2)
		{
			type = 4;
		}
	    switch(type)
	    {
	    case upleft:
	    	x=new int[]{a1,a3,a4};
	    	y=new int[]{b1,b3,b4};
	    
	    	 break ;
	    case upright:
	    	x=new int[]{a2,a3,a4};
	    	y=new int[]{b2,b3,b4};
	    
	    	 break ;
	    case downleft:
	    	x=new int[]{a1,a2,a4};
	    	y=new int[]{b1,b2,b4};
	  
	    	 break ;
	    case downright:
	    	x=new int[]{a1,a2,a3};
	    	y=new int[]{b1,b2,b3};
	    
	    	 break ;
	    
	    
	    }
	    g.setColor(color);
	    if(filled)
	    {
	    	g.fillPolygon(x, y, 3);
	    }
	    else
	    {
	    	g.drawPolygon(x, y, 3);
	    }
	    	
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Vtri [type=" + type + ", x1=" + x1 + ", x2=" + x2 + ", y1=" + y1 + ", y2=" + y2 + ", filled=" + filled
				+ ", color=" + color + "]";
	}
	
	

}
