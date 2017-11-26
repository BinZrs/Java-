package edu.fjnu;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;



/**
 * SJF 调度算法 
 * @author zrs
 *
 */
public class TaskSJF {
	ArrayList<Task> taskList = new ArrayList<>();//存放读取总的任务队列
	ArrayList<ArrayList<Task>> queueList = new ArrayList<ArrayList<Task>>();//嵌套list
	int queueCount;
	public void calculateSJF(int n) { //参数n队列处理数量		
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
				double minTime=list.get(0).getValue();//找出队列完成时间最短的那个minTime  是 第ans个	
				int ans=list.get(0).getKey();//获得完成时间最短，队列编号	
				int t =  (int)minTime+1;
				if(t>taskList.size()) t= taskList.size(); 
				if(t<i) t=i;
				Collections.sort(taskList.subList(i,t));
				tmp = taskList.get(i);//获得当前时间节点， 服务时间最短的作业	
				tmp.calculateTime(minTime);
				queueList.get(ans).add(tmp); 
			//	queueList.get(ans).set(queueList.get(ans).size()-1, tmp);				
			}
			taskList.set(i, tmp);	
		}	
	}
	
	/**
	 * 打印不同处理队列数量的整个任务结果
	 */
	public void showTaskList() {
		File file = new File("out"+queueCount+".txt");
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bfw = new BufferedWriter(fw);
			//System.out.println("-----------------SJF算法"+queueCount+"个处理队列    整个任务队列按ID排序结果---------------");
			//System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
			bfw.write("-----------------SJF算法"+queueCount+"个处理队列    整个任务队列按ID排序结果---------------\n");
			bfw.write("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间\n");
			ArrayList<Task> orderedList = taskList;
			
			Collections.sort(orderedList, new Comparator<Task>() {
				public int compare(Task o1, Task o2) {
					return o1.getTaskID()-o2.getTaskID();
				};	
			});
			
			for(Task tmp:orderedList) {
				//System.out.println(tmp);
				bfw.write(tmp.toString());
			}
			bfw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("SJF算法成功将"+queueCount+"个处理队列结果写入"+"out"+queueCount+".txt");
		}
}
	
/*	public void showQueue() {	//展示出n个处理队列情况下，队列1~n 即每个队列内部处理信息
		int cnt=1;
		for(ArrayList<Task> queue:this.queueList) {
			System.out.println("-----------------SJF队列"+cnt+"的情况---------------");
			System.out.println("任务ID	到达时间	服务时间	开始时间	完成时间	周转时间	带权周转时间");
			for(Task tmp: queue) {
				System.out.println(tmp);
			}			
			cnt++;
		}
	}*/


}
