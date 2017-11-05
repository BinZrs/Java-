package edu.fjnu.SJF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import edu.fjnu.SJF.Task;
/**
 * SJF �����㷨 ֮     һ���������
 * @author zrs
 * SJF�㷨�� Task.java ��ʵ����Comparable<Task> �ӿ��Ա�  ���ѵ������񣬽��������ҳ�����ҵ
 *
 */
public class SingleQueue{
	List<Task> list = new ArrayList<>();
	public void calculateTaskQueue() {
		Init init = new Init();  //��ʼ���ļ�����
		Task task = new Task();	 //�����������
		//init.writeInitFile();//��ʼ�������б���д���ļ�	 ������
		list = task.getTaskArr();//����������
		for(int i=0;i<list.size();i++) {
			Task tmp = new Task();
			if(i==0) {
				tmp = list.get(i);
				tmp.calculateTime(0);//��1s��������ֻ��һ�� IDΪ1�Ǹ�����
			}
			else {
				//���ǰһ���������ʱ�������ʱ�䣬�����ж�  �Ѿ��ж��ٸ����������ʱ��㵽����
				int t =  (int)list.get(i-1).finishingTime+1;
				if(t>=list.size()) t= list.size(); 
				//��i��t��  ���Ե�ǰ�ѵ������������������򰴷���ʱ���С������С�
				Collections.sort(list.subList(i,t));
				tmp = list.get(i);//��õ�ǰʱ��ڵ㣬 ����ʱ����̵���ҵ
				tmp.calculateTime(list.get(i-1).finishingTime);//���м���
			}		
			list.set(i, tmp);// ���ı� д�� list
		}
	}
	
	public void showTaskList() {
		System.out.println("-----------------SJF �����������   �ܵ�����������---------------");
		System.out.println("����ID	����ʱ��	����ʱ��	��ʼʱ��	���ʱ��	��תʱ��	��Ȩ��תʱ��");
		for(Task tmp: this.list) {
			System.out.println(tmp.taskID+" 	"+tmp.arrivalTime+" 	"+tmp.serviceTime+" 	"+tmp.startingTime+" 	"+tmp.finishingTime+"	 "+tmp.turnAroundTime+" 	"+tmp.weightTurnAround);
		}
	}
	
	/*  ���� SJF �������е�main ���Ѹĵ� MainSJF.java��
	public static void main(String[] args) {
		SingleQueue sQueue = new SingleQueue();
		sQueue.calculateTaskQueue();//����ʱ��
		sQueue.showTaskList();//��ӡ�ܵĵ������	
	}
	*/	
}
