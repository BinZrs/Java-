package edu.fjnu;
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * 任务文件
 * @author zrs
 *
 */
public class Task {
	private int taskID; //任务ID
	private double arrivalTime; //到达时间
	private double serviceTime; //服务时间
	private double startingTime; //开始时间
	private double finishingTime; //完成时间=开始时间+服务时间
	private double turnAroundTime; //周转时间=完成时间-达到时间
	private double weightTurnAround; //带权周转时间=周转时间/服务时间
	ArrayList<Task> list = new ArrayList<>();
	public void setTask(int id,double ariTime,double serTime) {
		this.setTaskID(id); 
		this.setArrivalTime(ariTime);//到达时间
		this.setServiceTime(serTime);//服务时间
	}
	public void calculateTime(double startTime) {
		if(startTime < this.arrivalTime) 
			startTime = this.arrivalTime;
		this.setStartingTime(startTime);
		this.setFinishingTime(this.getStartingTime() + this.getServiceTime());
		this.setTurnAroundTime(this.getFinishingTime() - this.getArrivalTime());
		this.setWeightTurnAround(this.getTurnAroundTime()/this.getServiceTime());
	}
	public ArrayList<Task> getTaskArr(){//返回任务集
		Init init = new Init();
		int [][] arr = init.readInitFile();
		for(int i=0;i<arr.length;i++) {
			Task tmp = new Task();
			tmp.setTask(arr[i][0], arr[i][1], arr[i][2]);	
			list.add(tmp);		
		}
		return list;
	}
	
	@Override 
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.0");
		//return (int)this.getTaskID()+" 	"+(int)this.getArrivalTime()+" 	"+(int)this.getServiceTime()+" 	"+(int)this.getStartingTime()+" 	"+(int)this.getFinishingTime()+"	 "+(int)this.getTurnAroundTime()+" 	"+df.format(this.getWeightTurnAround())+"\n";
		return (int)this.getTaskID()+"\t\t"+(int)this.getArrivalTime()+"\t\t"+(int)this.getServiceTime()+"\t\t"+(int)this.getStartingTime()+"\t\t"+(int)this.getFinishingTime()+"\t\t"+(int)this.getTurnAroundTime()+"\t\t"+df.format(this.getWeightTurnAround())+"\n";
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
