package edu.fjnu;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;


/**
 * FCFS 调度算法 
 * @author zrs
 *
 */
public class TaskFCFS {
	ArrayList<Task> taskList = new ArrayList<>();//存放读取总的任务队列
	ArrayList<ArrayList<Task>> queueList = new ArrayList<ArrayList<Task>>();//嵌套list
	int queueCount;
	/**
	 * FCFS算法 
	 * @param n   参数n是处理队列数量
	 */
	public void calculateFCFS(int n) { 		
		Init init = new Init();
		Task task = new Task();
		taskList = task.getTaskArr();//获得任务队列
		if(n>taskList.size()) {
			System.out.println("队列数量超出任务数量！将n重置为1");
			n=1;
		}
		queueCount=n;
		for(int j=0;j<n;j++) {
			ArrayList<Task> queue = new ArrayList<>();
			queueList.add(queue);
		}
		for(int i=0;i<taskList.size();i++) {	
			Task tmp = new Task();
			tmp = taskList.get(i);
			if(i<n) {
				tmp.calculateTime(tmp.getArrivalTime());
				queueList.get(i).add(tmp);
			}
			else {
				Map<Integer,Double> map = new TreeMap<>();
				for(int j=0;j<n;j++) {
					double t = queueList.get(j).get(queueList.get(j).size()-1).getFinishingTime();
					map.put(j,t);
				}
		        List<Map.Entry<Integer,Double>> list = new ArrayList<Map.Entry<Integer,Double>>(map.entrySet());
		        //然后通过比较器来实现排序
		        Collections.sort(list,new Comparator<Map.Entry<Integer,Double>>() {
		            //升序排序
		            public int compare(Entry<Integer,Double> o1,
		                    Entry<Integer,Double> o2) {
		                return o1.getValue().compareTo(o2.getValue());
		            }
		        });													
				double minTime=list.get(0).getValue();//找出队列完成时间最短的那个minTime  是 第i个
				int ans=list.get(0).getKey();
				queueList.get(ans).add(tmp); 
				tmp.calculateTime(minTime);
				queueList.get(ans).set(queueList.get(ans).size()-1, tmp);				
			}
			taskList.set(i, tmp);	
		}	
	}
	/**
	 * 将不同处理队列数量的整个任务结果 
	 * 写入到文件 out+队列处理个数.txt
	 * 当处理队列数n=1，输出文件out1.txt
	 */
	public void showTaskList() {
		File file = new File("out"+queueCount+".txt");
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bfw = new BufferedWriter(fw);
			String s1="-----------------FCFS算法"+queueCount+"个处理队列    整个任务队列按ID排序结果---------------\n";
			bfw.write(s1);
			String s2="任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间\n";
			bfw.write(s2);
			for(Task tmp:taskList) {
				bfw.write(tmp.toString());
			}
			bfw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("FCFS算法成功将"+queueCount+"个处理队列结果写入"+"out"+queueCount+".txt");
		}
	}
/*	public void showQueue() {	//展示出n个处理队列情况下，队列1~n 即每个队列内部处理信息
		int cnt=1;
		for(ArrayList<Task> queue:this.queueList) {
			System.out.println("-----------------FCFS队列"+cnt+"的情况---------------");
			System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
			for(Task tmp: queue) {
				System.out.println(tmp);
			}			
			cnt++;
		}
	}*/
	
}
