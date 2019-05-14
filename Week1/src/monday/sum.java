package monday;

import java.util.Scanner;

public class sum {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		int n1, n2;
		int sum=0;
	    System.out.printf("Enter n1 n2: ");
	    Scanner input = new Scanner (System.in );
	    n1 = input.nextInt();
	    n2 = input.nextInt();
		while(n1>=0 && n2>=0){
			sum = 0;
			for(int i=n1;i<=n2;i++){
			  sum += i;
			}
			System.out.printf("sum(%d,%d) = %d\n",n1,n2,sum);
			System.out.printf("Enter n1 n2: ");
			n1 = input.nextInt();
		    n2 = input.nextInt();

	}

}
}