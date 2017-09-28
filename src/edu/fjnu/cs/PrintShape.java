package edu.fjnu.cs;

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
	}

}
