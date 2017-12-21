package edu.fjnu;

/**
 * 单例模式实现ChocolateBoiler
 * @author Administrator
 *
 */
public class ChocolateBoiler {
	private static ChocolateBoiler uniqueInstance;
	private  boolean empty = true; // 初始锅炉为空
	private  boolean boiled = false; // 未煮沸

	private ChocolateBoiler() {}
	
	
	public static ChocolateBoiler getuniqueInstance() {	
	        try {   
	          //  synchronized (ChocolateBoiler.class) {  
	                if(uniqueInstance != null){//懒汉式   
	                      
	                }else{  
	                    //创建实例之前可能会有一些准备性的耗时工作   
	                    Thread.sleep(300);  
	                    uniqueInstance = new ChocolateBoiler();  
	                }  
	       //    }  
	        } catch (InterruptedException e) {   
	            e.printStackTrace();  
	        }  
	        return  uniqueInstance;  
	}
	
	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

	public void fill() {
		if (isEmpty() == true) {
			System.out.println("正在填充巧克力和牛奶混合物！");
			this.empty = false;
		} else {
			System.out.println("锅炉已满，无法填充！");
		}
	}

	public void boil() {
		if (isEmpty() == false && isBoiled() == false) {
			System.out.println("正在执行煮沸操作！");
			this.boiled = true;
		} else {
			System.out.println("锅炉未满，无法执行煮沸操作");
		}

	}

	public void drain() {
		if (isEmpty() == false && isBoiled() == true) {
			System.out.println("正在排出混合物!");
			this.empty = true;
			this.boiled = false;
		} else {
			System.out.println("锅炉未满或没有煮沸，无法执行排出操作!");
		}

	}

	
}