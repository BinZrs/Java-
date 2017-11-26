package edu.fjnu;

public class Main {

	public static void main(String[] args) {
		Init init = new Init();
		if(init.isExistFile() == false)
			init.writeInitFile(); //    文件不存在则 生成任务列表初始文件
		
		TaskSJF sjf = new TaskSJF();
		sjf.calculateSJF(1); //处理队列数目为1的请
		sjf.showTaskList(); //按顺序打印所有任务总的信息
		sjf.calculateSJF(2);  //处理队列数目为2的情况
		sjf.showTaskList(); //按顺序打印所有任务总的信息
	}

}
