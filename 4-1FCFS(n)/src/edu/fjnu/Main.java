package edu.fjnu;
/**
 * 测试 FCFS 算法    的main
 * @author zrs
 *
 */
public class Main {

	public static void main(String[] args) {
		Init init = new Init();  // 文件名为input.txt
		if(init.isExistFile() == false)
			init.writeInitFile(); //  文件不存在则 生成任务列表初始文件	
		TaskFCFS Fcfs = new TaskFCFS();
		Fcfs.calculateFCFS(1); //n=1,即单处理队列
		Fcfs.showTaskList();  //按id排序后，将调度结果写入out1.txt
		Fcfs.calculateFCFS(2); //n=2双处理队列
		Fcfs.showTaskList();  //写入文件out2.txt
	}

}
