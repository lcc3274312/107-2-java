package revised;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int MAX = 100;
		Shape shapes[] = new Shape[MAX];
		int shapecount = 0 ;
		shapes[shapecount++] = new Rect(6,10,true);
		shapes[shapecount++] = new Rect(6,10,true,"#");
		shapes[shapecount++] = new Rect(8,8,false);
		shapes[shapecount++] = new Rect(8,8,false,"#");
		shapes[shapecount++] = new Vtri(5,1,true);
		shapes[shapecount++] = new Vtri(5,1,true,"@");
		shapes[shapecount++] = new Vtri(5,1,false);
		shapes[shapecount++] = new Vtri(5,1,false,"@");
//		shapes[shapecount++] = new Vtri(5,3,true);
//		shapes[shapecount++] = new Vtri(5,4,false);
		
		
		
		
		for(int i=0;i<shapecount;i++)
		{
			shapes[i].draw();
			System.out.println(shapes[i]);
		}
	}

}
