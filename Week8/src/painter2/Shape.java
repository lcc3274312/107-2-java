package painter2;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	
	protected int x1,x2,y1,y2;
	protected boolean filled;
	protected Color color= Color.BLUE;
	protected Color color2= Color.RED;

	
  

    public Shape(int x1,int y1,int x2,int y2,boolean filled,Color color) {
    	this.x1=x1;
    	this.x2=x2;
    	this.y1=y1;
    	this.y2=y2;
    	this.filled=filled;
    	this.color=color;
    	
    }
    public Shape(int x1,int y1,int x2,int y2,boolean filled,Color color,Color color2) {
    	this.x1=x1;
    	this.x2=x2;
    	this.y1=y1;
    	this.y2=y2;
    	this.filled=filled;
    	this.color=color;
    	this.color2=color2;
    	
    }
    public abstract void draw(Graphics g);
    

}
