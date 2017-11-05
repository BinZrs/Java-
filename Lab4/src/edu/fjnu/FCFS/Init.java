package edu.fjnu.FCFS;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class Init {
	int [] ServerTime = {6,2,1,3,9};//����ʱ�伯�ϣ�����ķ���ʱ����������������ȡ��һ��
	int taskNum = 100;//��������100
	int [][] vArray = new int [taskNum][3];	
	public boolean isExistFile() {
		File file = new File("initFile.txt");
		if(file.exists() && file.length()!=0)
			return true;
		else
			return false;
	}
	
	public void writeInitFile() {
		try {
			File file = new File("initFile.txt");//���ɴ�������б���ļ��Ķ���file
			FileWriter out = new FileWriter(file);
			Random r = new Random();
			String str = "";	
			for(int i=1;i<=taskNum;i++) {
				int tmp = r.nextInt(5);
				str+=i+" "+(i-1)+" "+ServerTime[tmp]+"\n";				
			}	
			out.write(str);
			out.close();
		
		}catch(Exception e1) {
			e1.printStackTrace();
		}	
	}
	
	public int[][] readInitFile() {
		try {
			File file = new File("initFile.txt");//��������б���ļ��Ķ���file
			FileReader in = new FileReader(file);
			BufferedReader bufr = new BufferedReader(in);
			String res = null;
			int cnt=0;
			while((res=bufr.readLine())!=null) {
				String v[] = res.split(" ");	
				int ans=0;
				for(String tmp:v) {
					vArray [cnt][ans] = Integer.parseInt(tmp);
					ans++;
				}
				cnt++;
			}	
			//��ӡ��ȡ������
			/*for(int i=0;i<taskNum;i++) {
				for(int j=0;j<3;j++)
					System.out.print(vArray[i][j]+" ");
				System.out.print("\n");
			}*/
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return vArray;	
	}
	
	
}
