package edu.fjnu.FCFS;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * FCFS �����㷨 ֮     һ���������
 * @author zrs
 *
 */
public class SingleQueue {
	ArrayList<Task> list = new ArrayList<>();
	public void calculateTaskQueue() {
		Init init = new Init();
		Task task = new Task();
		//init.writeInitFile();//��ʼ�������б���д���ļ�	 �����õ�
		
		list = task.getTaskArr();//����������
		//System.out.println("����ID	����ʱ��	����ʱ��	��ʼʱ��	���ʱ��	��תʱ��	��Ȩ��תʱ��");
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
		System.out.println("-----------------FCFS �����������   �ܵ�����������---------------");
		System.out.println("����ID	����ʱ��	����ʱ��	��ʼʱ��	���ʱ��	��תʱ��	��Ȩ��תʱ��");
		for(Task tmp: this.list) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	
	/*	//���� FCFS �������е�main ���Ѹĵ� MainFCFS.java��
	public static void main(String[] args) {
		SingleQueue sQueue = new SingleQueue();
		sQueue.calculateTaskQueue();//����ʱ��
		sQueue.showTaskList();//��ӡ�ܵĵ������
		
	}
	*/

}
