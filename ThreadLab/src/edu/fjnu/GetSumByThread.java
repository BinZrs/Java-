/**
 * 
 */
package edu.fjnu;

/**
      利用4个线程分段求和1~100
      线程1计算1~25之和；线程2计算26~50之和；以此类推
      要求线程1完成之后执行线程2，之后执行线程3，最后执行线程4
      打印每段求和结果，以及最后的总结果。即分别打印第一段求和结果，第二段求和结果，
      第三段求和结果，第四段求和结果，最终的求和结果
 */
public class GetSumByThread {
	static int totalSum=0;
	public static void main(String[] args) throws InterruptedException {
		Thread th[] = new Thread[4];//创建四个进程用来分别求和
		
		th[0] = new Thread(new Runnable() {	//线程1计算1~25的和；
			@Override
			public void run() {
				int sum=0;
				for(int i=1;i<=25;i++) {
					sum+=i;
				}	
				totalSum+=sum;
				System.out.println("1~25的和为："+sum);
			}
		});
		th[1] = new Thread(new Runnable() {	
			@Override
			public void run() {
				int sum=0;
				for(int i=26;i<=50;i++) {
					sum+=i;
				}	
				totalSum+=sum;
				System.out.println("26~50的和为："+sum);
			}
		});
		th[2]= new Thread(new Runnable() {	
			@Override
			public void run() {
				int sum=0;
				for(int i=51;i<=75;i++) {
					sum+=i;
				}	
				totalSum+=sum;
				System.out.println("51~75的和为："+sum);
			}
		});
		th[3] = new Thread(new Runnable() {	
			@Override
			public void run() {
				int sum=0;
				for(int i=76;i<=100;i++) {
					sum+=i;
				}	
				totalSum+=sum;
				System.out.println("76~100的和为："+sum);
			}
		});
		
		for(int j=0;j<4;j++) {
			th[j].start();
			th[j].join();//使用join函数，来保证线程执行顺序
		}
		System.out.println("1~100的和为："+totalSum);
	}
	
}
