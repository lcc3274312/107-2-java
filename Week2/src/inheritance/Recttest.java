package inheritance;

import java.util.Scanner;

public class Recttest {


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int height;
			int width;
			Scanner input = new Scanner (System.in);
			System.out.print("Enter height and width:  ");
			height = input.nextInt();
			width = input.nextInt();
			Rect rect = new Rect (height,width);
			rect.draw();
			System.out.println("Height: "+rect.getHeight()+ ", Width: "+rect.getWidth());
			
			Rect rect2 = new Rect();
			rect2.setHeight(8);
			rect2.setWidth(8);
			rect2.draw();
			System.out.println("Height: "+rect2.getHeight()+",Width: "+rect2.getWidth());
		}
	}


