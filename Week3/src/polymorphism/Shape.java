package polymorphism;

public abstract class Shape {
	protected int height;

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
