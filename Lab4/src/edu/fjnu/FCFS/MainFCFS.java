package edu.fjnu.FCFS;
/**
 * ���� FCFS �㷨    ��main
 * @author zrs
 *
 */
public class MainFCFS {

	public static void main(String[] args) {
		Init init = new Init();  // �ļ���ΪinitFile.txt
		if(init.isExistFile() == false)
			init.writeInitFile(); //  ���������б��ʼ�ļ�
		
		SingleQueue sQueue = new SingleQueue();//����������еĶ���
		sQueue.calculateTaskQueue();//����ʱ��
		sQueue.showTaskList();//��ӡ�ܵĵ������
		
		DoubleQueue dQueue = new DoubleQueue();//����������еĶ���
		dQueue.calculateTaskQueue(); //���������б� ÿ��ʱ��
		dQueue.showTaskList(); //��˳���ӡ���������ܵ���Ϣ
		dQueue.showQueue1();//��ӡ�������1�������Ϣ
		dQueue.showQueue2();//��ӡ�������2������Ϣ		
	}

}
