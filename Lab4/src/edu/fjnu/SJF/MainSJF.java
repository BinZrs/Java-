package edu.fjnu.SJF;
import edu.fjnu.FCFS.Init;

public class MainSJF {

	public static void main(String[] args) {
		Init init = new Init();
		if(init.isExistFile() == false)
			init.writeInitFile(); //  ���������б��ʼ�ļ�
		
		SingleQueue sQueue = new SingleQueue();
		sQueue.calculateTaskQueue();//����ʱ��
		sQueue.showTaskList();//��ӡ�ܵĵ������	
		
		DoubleQueue dQueue = new DoubleQueue();
		dQueue.calculateTaskQueue(); //���������б� ÿ��ʱ��
		dQueue.showQueue1();//��ӡ�������1�������Ϣ
		dQueue.showQueue2();//��ӡ�������2������Ϣ	
		dQueue.showTaskList(); //��˳���ӡ���������ܵ���Ϣ
	}

}
