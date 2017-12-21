## 实验6 JAVA多线程
**实验内容：**

    1. 对实验三中的单例模式进行改造，使其支持多线程，并且是线程安全的。
    2. 利用4个线程分段求和1~100
       线程1计算1~25之和；线程2计算26~50之和；以此类推
       要求线程1完成之后执行线程2，之后执行线程3，最后执行线程4
       打印每段求和结果，以及最后的总结果。即分别打印第一段求和结果，第二段求和结果，第三段求和结果，第四段求和结果，最终的求和结果

实验3中单例模式使用线程同步机制的代码部分：
``` java
	public static ChocolateBoiler getuniqueInstance() {	
	        try {   
	            synchronized (ChocolateBoiler.class) { //同步块
	                if(uniqueInstance != null){  
	                      
	                }else{  
	                    //创建实例之前可能会有一些准备性的耗时工作   
	                    Thread.sleep(300);  
	                    uniqueInstance = new ChocolateBoiler();  
	                }  
	          }  
	        } catch (InterruptedException e) {   
	            e.printStackTrace();  
	        }  
	        return  uniqueInstance;  
	}
```
**结果截图：**

使用同步机制，测试时5个进程获取的对象的哈希码完全一样

 ![](https://github.com/BinZrs/JavaLab/raw/master/Image/单例线程同步.png)
 
不使用同步机制，测试时5个进程获取的对象的哈希码都不一样
 
 ![](https://github.com/BinZrs/JavaLab/raw/master/Image/单例非线程同步.png)
 
 
 进程求和代码：
 
 ```
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
```
 **结果截图：**
 
 ![](https://github.com/BinZrs/JavaLab/raw/master/Image/多线程求和.png)
