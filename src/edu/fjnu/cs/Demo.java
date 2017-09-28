package edu.fjnu.cs;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=20;
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
	}

}
