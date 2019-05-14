package polymorphism;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int MAX = 100;
		Shape shapes[] = new Shape[MAX];
		int shapecount = 0 ;
		shapes[shapecount++] = new Rect(6,10);
		shapes[shapecount++] = new Rect(8,8);
		shapes[shapecount++] = new Vtri(5,1);
		shapes[shapecount++] = new Vtri(5,2);
		shapes[shapecount++] = new Vtri(5,3);
		shapes[shapecount++] = new Vtri(5,4);
		
		
		
		
		for(int i=0;i<shapecount;i++)
		{
			shapes[i].draw();
			System.out.println(shapes[i]);
		}
	}

}
