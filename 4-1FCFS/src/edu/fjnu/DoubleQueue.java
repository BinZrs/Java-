package edu.fjnu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * FCFS 调度算法 之     两个处理队列
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
		//init.writeInitFile();//初始化任务列表，并写入文件	 测试用的
		taskList = task.getTaskArr();//获得任务队列
		queue1.add(taskList.get(0));//由于是FCFS 所以一开始情况为这样情况
		queue2.add(taskList.get(1)); //一开始， 头两个任务分别进入一个队列
		for(int i=0;i<taskList.size();i++) {
			Task tmp = new Task();
			tmp = taskList.get(i);
			if(i==0) {
				tmp.calculateTime(tmp.getArrivalTime());
				queue1.set(0, tmp);
			}
			else if(i==1) {
				tmp.calculateTime(tmp.getArrivalTime());//第2个任务到达时间为1，第二个任务为队列2开始第一个任务所以开始时间为1
				queue2.set(0, tmp);
			}		
			else {
				double t1 = queue1.get(queue1.size()-1).getFinishingTime();
				double t2 = queue2.get(queue2.size()-1).getFinishingTime();
				if(t1 <= t2){
					queue1.add(tmp); 
					tmp.calculateTime(t1);
					queue1.set(queue1.size()-1, tmp);			
				}
				else {
					queue2.add(tmp);
					tmp.calculateTime(t2);
					queue2.set(queue2.size()-1, tmp);
				}
			}
			taskList.set(i, tmp); // 写回原任务数组。
		}	
	}
	private void displayInfo(List<Task> list) {
		DecimalFormat df = new DecimalFormat("0.0");
		for(Task tmp: list) {
			System.out.println((int)tmp.getTaskID()+" 	"+(int)tmp.getArrivalTime()+" 	"+(int)tmp.getServiceTime()+" 	"+(int)tmp.getStartingTime()+" 	"+(int)tmp.getFinishingTime()+"	 "+(int)tmp.getTurnAroundTime()+" 	"+df.format(tmp.getWeightTurnAround()));
		}	
	}
	public void showTaskList() {
		System.out.println("-----------------FCFS 两个处理队列   总的任务调度情况---------------");
		System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
		this.displayInfo(this.taskList);
	}
	public void showQueue1() {
		System.out.println("-----------------FCFS双队列中 队列1的情况---------------");
		System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
		this.displayInfo(this.queue1);
	}
	
	public void showQueue2() {
		System.out.println("-----------------FCFS双队列中 队列2的情况---------------");
		System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
		this.displayInfo(this.queue2);
	}
	
	/*  //测试 FCFS 两个队列的main 现已改到 MainFCFS.java中
	public static void main(String[] args) {
			DoubleQueue dQueue = new DoubleQueue();
			dQueue.calculateTaskQueue(); //计算任务列表 每个时间
			dQueue.showTaskList(); //按顺序打印所有任务总的信息
			dQueue.showQueue1();//打印进入队列1任务的信息
			dQueue.showQueue2();//打印进入队列2任务信息			
	}
	*/
}
