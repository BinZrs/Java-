package edu.fjnu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * 任务文件
 * @author zrs
 *
 */
public class Task implements  Comparable<Task> {
	int taskID; //任务ID
	double arrivalTime; //到达时间
	double serviceTime; //服务时间
	double startingTime; //开始时间
	double finishingTime; //完成时间=开始时间+服务时间
	double turnAroundTime; //周转时间=完成时间-达到时间
	double weightTurnAround; //带权周转时间=周转时间/服务时间
	ArrayList<Task> list = new ArrayList<>();
	
	 public int compareTo(Task t) {
		    if(this.serviceTime > t.serviceTime) {
		    	  return 1;
		    }
		    else if (this.serviceTime < t.serviceTime) {
				 return -1;
			}
			else
				 return 0;
		 }
	@Override 
		public String toString() {
			DecimalFormat df = new DecimalFormat("0.0");
			//return (int)this.getTaskID()+" 	"+(int)this.getArrivalTime()+" 	"+(int)this.getServiceTime()+" 	"+(int)this.getStartingTime()+" 	"+(int)this.getFinishingTime()+"	 "+(int)this.getTurnAroundTime()+" 	"+df.format(this.getWeightTurnAround());
			return (int)this.getTaskID()+"\t\t"+(int)this.getArrivalTime()+"\t\t"+(int)this.getServiceTime()+"\t\t"+(int)this.getStartingTime()+"\t\t"+(int)this.getFinishingTime()+"\t\t"+(int)this.getTurnAroundTime()+"\t\t"+df.format(this.getWeightTurnAround())+"\n";
	}
	public void setTask(int id,double ariTime,double serTime) {
		this.taskID = id; 
		this.arrivalTime = ariTime;//到达时间
		this.serviceTime = serTime;//服务时间
	}
	public void calculateTime(double startTime) {
		if(startTime < this.arrivalTime) 
			startTime = this.arrivalTime;
		this.startingTime = startTime;
		this.finishingTime = this.startingTime + this.serviceTime;
		this.turnAroundTime = this.finishingTime - this.arrivalTime;
		this.weightTurnAround = this.turnAroundTime/this.serviceTime;
	}
	public ArrayList<Task> getTaskArr(){//返回任务集
		Init init = new Init();
		int [][] arr = init.readInitFile();
		for(int i=0;i<arr.length;i++) {
			Task tmp = new Task();
			tmp.setTask(arr[i][0], arr[i][1], arr[i][2]);
			list.add(tmp);//注意在循环里面 创建一个tmp对象，若在外面创建，怎add多少次内容都一样，因为只有一个引用。
		}	
		return list;
	}
	
	
		public int getTaskID() {
			return taskID;
		}
		public void setTaskID(int taskID) {
			this.taskID = taskID;
		}
		public double getArrivalTime() {
			return arrivalTime;
		}
		public void setArrivalTime(double arrivalTime) {
			this.arrivalTime = arrivalTime;
		}
		public double getServiceTime() {
			return serviceTime;
		}
		public void setServiceTime(double serviceTime) {
			this.serviceTime = serviceTime;
		}
		public double getStartingTime() {
			return startingTime;
		}
		public void setStartingTime(double startingTime) {
			this.startingTime = startingTime;
		}
		public double getFinishingTime() {
			return finishingTime;
		}
		public void setFinishingTime(double finishingTime) {
			this.finishingTime = finishingTime;
		}
		public double getTurnAroundTime() {
			return turnAroundTime;
		}
		public void setTurnAroundTime(double turnAroundTime) {
			this.turnAroundTime = turnAroundTime;
		}
		public double getWeightTurnAround() {
			return weightTurnAround;
		}
		public void setWeightTurnAround(double weightTurnAround) {
			this.weightTurnAround = weightTurnAround;
		}

}
