package edu.fjnu.FCFS;
import java.util.ArrayList;
/**
 * 任务文件
 * @author zrs
 *
 */
public class Task {
	int taskID; //任务ID
	double arrivalTime; //到达时间
	double serviceTime; //服务时间
	double startingTime; //开始时间
	double finishingTime; //完成时间=开始时间+服务时间
	double turnAroundTime; //周转时间=完成时间-达到时间
	double weightTurnAround; //带权周转时间=周转时间/服务时间
	ArrayList<Task> list = new ArrayList<>();
	
	public void setTask(int id,double ariTime,double serTime) {
		this.taskID = id; 
		this.arrivalTime = ariTime;//到达时间
		this.serviceTime = serTime;//服务时间
	}
	public void calculateTime(double startTime) {
		this.startingTime = startTime;
		this.finishingTime = this.startingTime + this.serviceTime;
		this.turnAroundTime = this.finishingTime - this.arrivalTime;
		this.weightTurnAround = this.turnAroundTime/this.serviceTime;
	}
	public ArrayList<Task> getTaskArr(){//返回任务集
		Init init = new Init();
		int [][] arr = init.readInitFile();
	//	Task tmp = new Task();  //写这里会出错的。外面创建一个对象，在之后while所有操作都是针对这一个对象进行的
		for(int i=0;i<arr.length;i++) {
			Task tmp = new Task();
			tmp.setTask(arr[i][0], arr[i][1], arr[i][2]);
		//	System.out.println(tmp.taskID+" "+tmp.arrivalTime+" "+tmp.serviceTime);
			list.add(tmp);//注意在循环里面 创建一个tmp对象，若在外面创建，怎add多少次内容都一样，因为只有一个引用。
			
		}
		return list;
	}
	 
}
