package edu.fjnu.SJF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * �����ļ�
 * @author zrs
 *
 */
public class Task implements  Comparable<Task> {
	int taskID; //����ID
	double arrivalTime; //����ʱ��
	double serviceTime; //����ʱ��
	double startingTime; //��ʼʱ��
	double finishingTime; //���ʱ��=��ʼʱ��+����ʱ��
	double turnAroundTime; //��תʱ��=���ʱ��-�ﵽʱ��
	double weightTurnAround; //��Ȩ��תʱ��=��תʱ��/����ʱ��
	ArrayList<Task> list = new ArrayList<>();
	
	public void setTask(int id,double ariTime,double serTime) {
		this.taskID = id; 
		this.arrivalTime = ariTime;//����ʱ��
		this.serviceTime = serTime;//����ʱ��
	}
	public void calculateTime(double startTime) {
		this.startingTime = startTime;
		this.finishingTime = this.startingTime + this.serviceTime;
		this.turnAroundTime = this.finishingTime - this.arrivalTime;
		this.weightTurnAround = this.turnAroundTime/this.serviceTime;
	}
	public ArrayList<Task> getTaskArr(){//��������
		Init init = new Init();
		int [][] arr = init.readInitFile();
		for(int i=0;i<arr.length;i++) {
			Task tmp = new Task();
			tmp.setTask(arr[i][0], arr[i][1], arr[i][2]);
			list.add(tmp);//ע����ѭ������ ����һ��tmp�����������洴������add���ٴ����ݶ�һ������Ϊֻ��һ�����á�
		}	
		return list;
	}
	
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


}
