package edu.fjnu.cs;

public class FlowerNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 搜索3位水仙花数
		 */
		for(int i=100;i<=999;i++){
			int x=i%10;
			int y=(i/10)%10;
			int z=i/100;
			if(x*x*x + y*y*y + z*z*z == i){
				System.out.println(i + "是水仙花数。");
			}
		}
		
	}

}
