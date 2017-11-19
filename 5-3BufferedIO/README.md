##ʵ��5-3 ����������IO
### �ô�����Ͳ���������ַ���ʵ���ļ����ƣ����ȽϺ�ʱ�����
*��Ҫ���룺*
``` java
	public static long copy() throws IOException {
		File in = new File("src.txt");
		File out = new File("copy1.txt");
		FileReader fr = new FileReader(in);
		FileWriter fw = new FileWriter(out);
		int c;`�������`
		long startTime = System.currentTimeMillis();
		while((c=fr.read())!=-1) {
			fw.write(c);
		}
		long endTime = System.currentTimeMillis();
		return endTime-startTime;	
	}
	public static long copyBufferedIo() throws IOException {
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
��ͼ��
![](https://github.com/BinZrs/JavaLab/raw/master/Image/IOʱ��Ƚ�.png)