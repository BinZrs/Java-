package edu.fjnu;

import java.io.*;

public class testIO {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("src.txt");
		File file2 = new File("dest.txt");
		FileInputStream in = new FileInputStream(file);	
		FileOutputStream out = new FileOutputStream(file);
		FileInputStream in2 = new FileInputStream(file2);	
		FileOutputStream out2 = new FileOutputStream(file2);
		try {		
			int i;
			System.out.println("Please enter the content of src.txt:");
			while((i=System.in.read()) != -1) {
				out.write(i);  //д��src.txt�ļ�
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			int i=0;
			while((i=in.read()) != -1) { //��src.txt������Ϣ
				out2.write(i); //д��dest.txt
			}	
			byte byt[] = new byte[2048];
			int len = in2.read(byt);			
			System.out.print("dest.txt:" + new String(byt,0,len));
			in.close();
			in2.close();
			out.close();
			out2.close();
		}catch(IOException e) {
		e.printStackTrace();
		}
	
	}
}
