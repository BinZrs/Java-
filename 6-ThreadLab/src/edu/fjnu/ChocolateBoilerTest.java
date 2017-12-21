package edu.fjnu;

public class ChocolateBoilerTest extends Thread {
		@Override
		public void run() {
			 System.out.println("hashcode:"+ChocolateBoiler.getuniqueInstance().hashCode());  
		}

	public static void main(String[] args) {
		ChocolateBoilerTest th[] = new ChocolateBoilerTest[5];
		System.out.println("不使用线程同步机制：");
		for (int i = 0; i < th.length; i++)
			th[i] = new ChocolateBoilerTest();
		for (int i = 0; i < th.length; i++)
			th[i].start();
	}
	
}
