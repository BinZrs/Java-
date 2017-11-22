package edu.fjnu;

public class Main {

	public static void main(String[] args) {
		Init init = new Init();
		if(init.isExistFile() == false)
			init.writeInitFile(); //    文件不存在则 生成任务列表初始文件
		
		SingleQueue sQueue = new SingleQueue();
		sQueue.calculateTaskQueue();//计算时间
		sQueue.showTaskList();//打印总的调度情况	
		
		DoubleQueue dQueue = new DoubleQueue();
		dQueue.calculateTaskQueue(); //计算任务列表 每个时间
		dQueue.showQueue1();//打印进入队列1任务的信息
		dQueue.showQueue2();//打印进入队列2任务信息	
		dQueue.showTaskList(); //按顺序打印所有任务总的信息
	}

}
