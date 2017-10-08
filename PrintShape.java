package edu.fjnu.cs;

/**
 * 打印图案   
   *   
  ***  
 ***** 
*******
 ***** 
  ***  
   * 
 * @author Administrator
 *
 */
public class PrintShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int l=3;
		int r=3;
		for(int i=0;i<7;i++){ 
			for(int j=0;j<7;j++){
				if(j<l || j > r)
					System.out.print(' ');
				else
					System.out.print('*');			
			}
			if(i < 3){
				l--;
				r++;
			}
			if(i == 3){
				l=1;
				r=5;
			}
			if(i > 3){
				l++;
				r--;
			}
			System.out.print("\n");
		}
		/* 法2  
		int n=7; //图案的层数
		for(int i=0;i<=n/2;i++){
			for(int j=0;j<n/2-i;j++){
				System.out.print(" ");
			}
			for(int j=n/2-i;j<=n/2+i;j++){
				System.out.print("*");
			}
			for(int j=n/2+i+1;j<n;j++){
				System.out.print(" ");
			}
			System.out.print("\n");	
		}
		for(int i=0;i<n/2;i++){
			for(int j=0;j<i+1;j++){
				System.out.print(" ");
			}
			for(int j=i+1;j<n-i-1;j++){
				System.out.print("*");
			}
			for(int j=n-i-1;j<n;j++){
				System.out.print(" ");
			}
			System.out.print("\n");	
		}
		*/
	}

}
