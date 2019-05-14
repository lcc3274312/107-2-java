package revised;

public abstract class Shape {
	protected int height;
	protected boolean filled;
	protected String c="*" ;

	public Shape(int h,boolean filled,String c) {
		// TODO Auto-generated constructor stub
		this.filled = filled;
		this.c = c;
		height = h;
	}
	public Shape(int h,boolean filled) {
		// TODO Auto-generated constructor stub
		this.filled = filled;
		height = h;
	}
	public Shape(int h) {
		// TODO Auto-generated constructor stub
		height = h;
	}
	public Shape() {
		// TODO Auto-generated constructor stub
	}
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int h)
	{
		height = h;
	}
	public abstract void draw();
	{
		
	}
}
