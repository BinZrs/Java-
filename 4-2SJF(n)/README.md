### 实验4 SJF通用调度算法

*主要代码：*
``` java
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
	
}
```
结果截图：

1个处理队列情况

![](https://github.com/BinZrs/JavaLab/raw/master/Image/SJF(1).png)

2个处理队列情况

![](https://github.com/BinZrs/JavaLab/raw/master/Image/SJF(2).png)


