package edu.fjnu.SJF;
import java.util.ArrayList;
import java.util.Collections;


/**
 * SJF 调度算法 之     两个处理队列
 * @author zrs
 *
 */
public class DoubleQueue {
	ArrayList<Task> taskList = new ArrayList<>();//存放读取总的任务队列
	ArrayList<Task> queue1 = new ArrayList<>(); //处理队列一
	ArrayList<Task> queue2 = new ArrayList<>();	//处理队列二
    
	public void calculateTaskQueue() {
		Init init = new Init();
		Task task = new Task();
		//init.writeInitFile();//初始化任务列表，并写入文件	 测试用
		taskList = task.getTaskArr();//获得任务队列
		queue1.add(taskList.get(0));//由于是FCFS 所以一开始情况为这样情况
		queue2.add(taskList.get(1)); //一开始， 头两个任务分别进入一个队列
		for(int i=0;i<taskList.size();i++) {
			Task tmp = new Task();		
			if(i==0) {
				tmp = taskList.get(i);
				tmp.calculateTime(0);
				queue1.set(0, tmp);
			}
			else if(i==1) {
				tmp = taskList.get(i);
				tmp.calculateTime(0);
				queue2.set(0, tmp);
			}		
			else {		
				double t1 = queue1.get(queue1.size()-1).finishingTime;
				double t2 = queue2.get(queue2.size()-1).finishingTime;
				if(t1 <= t2){//当t1较小时，说明t1先完成
					//获得前一个任务完成时，的完成时间，用于判断  已经有多少个任务在这个时间点到达了
					int t =  (int)t1+1;
					if(t>=queue1.size()) t= queue1.size(); 
					if(t<i) t=i;
					//对i到t个  即对当前已到达的任务进行排序，排序按服务时间从小到大进行。
					Collections.sort(taskList.subList(i,t));
					tmp = taskList.get(i);//获得当前时间节点， 服务时间最短的作业
					tmp.calculateTime(t1);//进行计算			
					queue1.add(tmp); 
/*					tmp.calculateTime(t1);
					queue1.set(queue1.size()-1, tmp);	*/		
				}
				else {
					//获得前一个任务完成时，的完成时间，用于判断  已经有多少个任务在这个时间点到达了
					int t = (int)t2+1;
					if(t>=queue2.size()) t= queue2.size(); 
					if(t<i) t=i;
					//对i到t个  即对当前已到达的任务进行排序，排序按服务时间从小到大进行。
					Collections.sort(taskList.subList(i,t));
					tmp = taskList.get(i);//获得当前时间节点， 服务时间最短的作业
					tmp.calculateTime(t2);//进行计算			
					queue2.add(tmp);  
				}
			}
			taskList.set(i, tmp); // 写回原任务数组。
		}	
	}
	public void showTaskList() {
		System.out.println("-----------------SJF 两个处理队列   总的任务调度情况---------------");
		System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
		for(Task tmp: this.taskList) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	public void showQueue1() {
		System.out.println("-----------------SJF双队列中 队列1的情况---------------");
		System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
		for(Task tmp: this.queue1) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	
	public void showQueue2() {
		System.out.println("-----------------SJF双队列中 队列2的情况---------------");
		System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
		for(Task tmp: this.queue2) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	/* SJF算法  两个队列的情况  现已改到 MainSJF.java中
	public static void main(String[] args) {
			DoubleQueue dQueue = new DoubleQueue();
			dQueue.calculateTaskQueue(); //计算任务列表 每个时间
			dQueue.showQueue1();//打印进入队列1任务的信息
			dQueue.showQueue2();//打印进入队列2任务信息	
			dQueue.showTaskList(); //按顺序打印所有任务总的信息
	}
	*/

}
