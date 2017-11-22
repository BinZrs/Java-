### 实验5-3 带缓冲区的IO

**实验内容**

	1.用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。

*主要代码：*
``` java
	public static long copy() throws IOException { //不带缓冲区复制文件src.txt
		File in = new File("src.txt");
		File out = new File("copy1.txt");
		FileReader fr = new FileReader(in);
		FileWriter fw = new FileWriter(out);
		int c;
		long startTime = System.currentTimeMillis();
		while((c=fr.read())!=-1) {
			fw.write(c);
		}
		long endTime = System.currentTimeMillis();
		return endTime-startTime;	
	}
	public static long copyBufferedIo() throws IOException { //带缓冲区复制文件src.txt
		File in = new File("src.txt");
		File out = new File("copy2.txt");
		FileReader fr = new FileReader(in);
		FileWriter fw = new FileWriter(out);
		BufferedReader bfr = new BufferedReader(fr);
		BufferedWriter bwr = new BufferedWriter(fw);
		int c;
		long startTime = System.currentTimeMillis();
		while((c=bfr.read())!=-1) {
			bwr.write(c);
		}
		long endTime = System.currentTimeMillis();
		return endTime-startTime;
	}
```
截图：
![](https://github.com/BinZrs/JavaLab/raw/master/Image/IO时间比较.png)
