package edu.fjnu.FCFS;
import java.util.ArrayList;


/**
 * FCFS �����㷨 ֮     �����������
 * @author zrs
 *
 */
public class DoubleQueue {
	ArrayList<Task> taskList = new ArrayList<>();//��Ŷ�ȡ�ܵ��������
	ArrayList<Task> queue1 = new ArrayList<>(); //�������һ
	ArrayList<Task> queue2 = new ArrayList<>();	//������ж�
    
	public void calculateTaskQueue() {
		Init init = new Init();
		Task task = new Task();
		//init.writeInitFile();//��ʼ�������б���д���ļ�	 �����õ�
		taskList = task.getTaskArr();//����������
		queue1.add(taskList.get(0));//������FCFS ����һ��ʼ���Ϊ�������
		queue2.add(taskList.get(1)); //һ��ʼ�� ͷ��������ֱ����һ������
		for(int i=0;i<taskList.size();i++) {
			Task tmp = new Task();
			tmp = taskList.get(i);
			if(i==0) {
				tmp.calculateTime(tmp.arrivalTime);
				queue1.set(0, tmp);
			}
			else if(i==1) {
				tmp.calculateTime(tmp.arrivalTime);//��2�����񵽴�ʱ��Ϊ1���ڶ�������Ϊ����2��ʼ��һ���������Կ�ʼʱ��Ϊ1
				queue2.set(0, tmp);
			}		
			else {
				double t1 = queue1.get(queue1.size()-1).finishingTime;
				double t2 = queue2.get(queue2.size()-1).finishingTime;
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
			taskList.set(i, tmp); // д��ԭ�������顣
		}	
	}
	public void showTaskList() {
		System.out.println("-----------------FCFS �����������   �ܵ�����������---------------");
		System.out.println("����ID	����ʱ��	����ʱ��	��ʼʱ��	���ʱ��	��תʱ��	��Ȩ��תʱ��");
		for(Task tmp: this.taskList) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	public void showQueue1() {
		System.out.println("-----------------FCFS˫������ ����1�����---------------");
		System.out.println("����ID	����ʱ��	����ʱ��	��ʼʱ��	���ʱ��	��תʱ��	��Ȩ��תʱ��");
		for(Task tmp: this.queue1) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	
	public void showQueue2() {
		System.out.println("-----------------FCFS˫������ ����2�����---------------");
		System.out.println("����ID	����ʱ��	����ʱ��	��ʼʱ��	���ʱ��	��תʱ��	��Ȩ��תʱ��");
		for(Task tmp: this.queue2) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	
	/*  //���� FCFS �������е�main ���Ѹĵ� MainFCFS.java��
	public static void main(String[] args) {
			DoubleQueue dQueue = new DoubleQueue();
			dQueue.calculateTaskQueue(); //���������б� ÿ��ʱ��
			dQueue.showTaskList(); //��˳���ӡ���������ܵ���Ϣ
			dQueue.showQueue1();//��ӡ�������1�������Ϣ
			dQueue.showQueue2();//��ӡ�������2������Ϣ			
	}
	*/
}
