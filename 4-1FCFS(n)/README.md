### 实验4 FCFS通用调度算法

**实验内容**

	1.用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。

*主要代码：*
``` java
/**
 * 实现FCFS主要代码
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
}
```
结果截图：

1个处理队列情况

![](https://github.com/BinZrs/JavaLab/raw/master/Image/FCFS(1).png)

2个处理队列情况

![](https://github.com/BinZrs/JavaLab/raw/master/Image/FCFS(2).png)


