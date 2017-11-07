package edu.fjnu.FCFS;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * FCFS 调度算法 之     一个处理队列
 * @author zrs
 *
 */
public class SingleQueue {
	ArrayList<Task> list = new ArrayList<>();
	public void calculateTaskQueue() {
		Init init = new Init();
		Task task = new Task();
		//init.writeInitFile();//初始化任务列表，并写入文件	 测试用的
		
		list = task.getTaskArr();//获得任务队列
		//System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
		for(int i=0;i<list.size();i++) {
			Task tmp = new Task();
			tmp = list.get(i);
			if(i==0) tmp.calculateTime(tmp.arrivalTime);
			else tmp.calculateTime(list.get(i-1).finishingTime);
			list.set(i, tmp);
		//	System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+"		"+tmp.weightTurnAround);
		}
	}
	
	public void showTaskList() {
		System.out.println("-----------------FCFS 单个处理队列   总的任务调度情况---------------");
		System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
		for(Task tmp: this.list) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	
	/*	//测试 FCFS 单个队列的main 现已改到 MainFCFS.java中
	public static void main(String[] args) {
		SingleQueue sQueue = new SingleQueue();
		sQueue.calculateTaskQueue();//计算时间
		sQueue.showTaskList();//打印总的调度情况
		
	}
	*/

}
