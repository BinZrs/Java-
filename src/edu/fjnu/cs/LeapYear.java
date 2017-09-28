package edu.fjnu.cs;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = 0;
		for(int i = 1990;i <= 2007; i++){
			if((i%4 == 0 && i%100 != 0) || i%400 == 0){
				System.out.print(i+"  ");
				ans++;
			}
			if(ans == 2){
				System.out.print("\n");
				ans = 0;
			}	
		}
		
	}

}
