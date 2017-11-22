package edu.fjnu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import edu.fjnu.Task;
/**
 * SJF 调度算法 之     一个处理队列
 * @author zrs
 * SJF算法中 Task.java 中实现了Comparable<Task> 接口以便  对已到达任务，进行排序，找出短作业
 *
 */
public class SingleQueue{
	List<Task> list = new ArrayList<>();
	public void calculateTaskQueue() {
		Init init = new Init();  //初始化文件对象
		Task task = new Task();	 //创建任务对象
		//init.writeInitFile();//初始化任务列表，并写入文件	 测试用
		list = task.getTaskArr();//获得任务队列
		for(int i=0;i<list.size();i++) {
			Task tmp = new Task();
			if(i==0) {
				tmp = list.get(i);
				tmp.calculateTime(tmp.arrivalTime);//第1s到达任务只有一个 ID为1那个任务
			}
			else {
				//获得前一个任务完成时，的完成时间，用于判断  已经有多少个任务在这个时间点到达了
				int t =  (int)list.get(i-1).finishingTime+1;
				if(t>=list.size()) t= list.size(); 
				//对i到t个  即对当前已到达的任务进行排序，排序按服务时间从小到大进行。
				Collections.sort(list.subList(i,t));
				tmp = list.get(i);//获得当前时间节点， 服务时间最短的作业
				tmp.calculateTime(list.get(i-1).finishingTime);//进行计算
			}		
			list.set(i, tmp);// 将改变 写回 list
		}
	}
	
	private void displayInfo(List<Task> list) {
		DecimalFormat df = new DecimalFormat("0.0");
		for(Task tmp: list) {
			System.out.println((int)tmp.getTaskID()+" 	"+(int)tmp.getArrivalTime()+" 	"+(int)tmp.getServiceTime()+" 	"+(int)tmp.getStartingTime()+" 	"+(int)tmp.getFinishingTime()+"	 "+(int)tmp.getTurnAroundTime()+" 	"+df.format(tmp.getWeightTurnAround()));
		}	
	}
	
	public void showTaskList() {
		System.out.println("-----------------SJF 单个处理队列   总的任务调度情况---------------");
		System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
		displayInfo(this.list);
	}
	
	/*  测试 SJF 单个队列的main 现已改到 MainSJF.java中
	public static void main(String[] args) {
		SingleQueue sQueue = new SingleQueue();
		sQueue.calculateTaskQueue();//计算时间
		sQueue.showTaskList();//打印总的调度情况	
	}
	*/	
}
