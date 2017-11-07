package edu.fjnu.SJF;
import java.util.ArrayList;
import java.util.Collections;


/**
 * SJF �����㷨 ֮     �����������
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
		//init.writeInitFile();//��ʼ�������б���д���ļ�	 ������
		taskList = task.getTaskArr();//����������
		queue1.add(taskList.get(0));//������FCFS ����һ��ʼ���Ϊ�������
		queue2.add(taskList.get(1)); //һ��ʼ�� ͷ��������ֱ����һ������
		for(int i=0;i<taskList.size();i++) {
			Task tmp = new Task();		
			if(i==0) {
				tmp = taskList.get(i);
				tmp.calculateTime(tmp.arrivalTime);
				queue1.set(0, tmp);
			}
			else if(i==1) {
				tmp = taskList.get(i);
				tmp.calculateTime(tmp.arrivalTime);//��2�����񵽴�ʱ��Ϊ1���ڶ�������Ϊ����2��ʼ��һ���������Կ�ʼʱ��Ϊ1
				queue2.set(0, tmp);
			}		
			else {		
				double t1 = queue1.get(queue1.size()-1).finishingTime;
				double t2 = queue2.get(queue2.size()-1).finishingTime;
				if(t1 <= t2){//��t1��Сʱ��˵��t1�����
					//���ǰһ���������ʱ�������ʱ�䣬�����ж�  �Ѿ��ж��ٸ����������ʱ��㵽����
					int t =  (int)t1+1;
					if(t>=queue1.size()) t= queue1.size(); 
					if(t<i) t=i;
					//��i��t��  ���Ե�ǰ�ѵ������������������򰴷���ʱ���С������С�
					Collections.sort(taskList.subList(i,t));
					tmp = taskList.get(i);//��õ�ǰʱ��ڵ㣬 ����ʱ����̵���ҵ
					tmp.calculateTime(t1);//���м���			
					queue1.add(tmp); 
/*					tmp.calculateTime(t1);
					queue1.set(queue1.size()-1, tmp);	*/		
				}
				else {
					//���ǰһ���������ʱ�������ʱ�䣬�����ж�  �Ѿ��ж��ٸ����������ʱ��㵽����
					int t = (int)t2+1;
					if(t>=queue2.size()) t= queue2.size(); 
					if(t<i) t=i;
					//��i��t��  ���Ե�ǰ�ѵ������������������򰴷���ʱ���С������С�
					Collections.sort(taskList.subList(i,t));
					tmp = taskList.get(i);//��õ�ǰʱ��ڵ㣬 ����ʱ����̵���ҵ
					tmp.calculateTime(t2);//���м���			
					queue2.add(tmp);  
				}
			}
			taskList.set(i, tmp); // д��ԭ�������顣
		}	
	}
	public void showTaskList() {
		System.out.println("-----------------SJF �����������   �ܵ�����������---------------");
		System.out.println("����ID	����ʱ��	����ʱ��	��ʼʱ��	���ʱ��	��תʱ��	��Ȩ��תʱ��");
		for(Task tmp: this.taskList) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	public void showQueue1() {
		System.out.println("-----------------SJF˫������ ����1�����---------------");
		System.out.println("����ID	����ʱ��	����ʱ��	��ʼʱ��	���ʱ��	��תʱ��	��Ȩ��תʱ��");
		for(Task tmp: this.queue1) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	
	public void showQueue2() {
		System.out.println("-----------------SJF˫������ ����2�����---------------");
		System.out.println("����ID	����ʱ��	����ʱ��	��ʼʱ��	���ʱ��	��תʱ��	��Ȩ��תʱ��");
		for(Task tmp: this.queue2) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	/* SJF�㷨  �������е����  ���Ѹĵ� MainSJF.java��
	public static void main(String[] args) {
			DoubleQueue dQueue = new DoubleQueue();
			dQueue.calculateTaskQueue(); //���������б� ÿ��ʱ��
			dQueue.showQueue1();//��ӡ�������1�������Ϣ
			dQueue.showQueue2();//��ӡ�������2������Ϣ	
			dQueue.showTaskList(); //��˳���ӡ���������ܵ���Ϣ
	}
	*/

}
