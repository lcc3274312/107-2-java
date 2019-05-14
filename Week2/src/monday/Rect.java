package monday;

public class Rect {
	private int height;
	private int width;
	
	public Rect(int h,int w)
	{
		height = h;
		width = w;
	}
	public void setHeight(int h)
	{
		height = h;
	}
	public void setWidth(int w)
	{
		width = w;
	}
	public int getHeight()
	{
		return height;
	}
	public int getWidth()
	{
		return width;
	}
	public void draw() {
		for(int i=1;i<=height;i++)
		{
		for(int j=1;j<=width;j++)
			System.out.print("*");
			System.out.println();
		}
}
}
