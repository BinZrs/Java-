package edu.fjnu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IoTimeCompare {

	public static long copy() throws IOException {
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
	
	public static void main(String[] args) throws IOException {
	
		long t1=copy();
		long t2=copyBufferedIo();
		File f = new File("src.txt");
		System.out.println("复制的文件为："+f.getName()+"文件大小为："+f.length()+"kb");
		System.out.println("不带缓冲区的字符流复制文件花费时间："+t1);
		System.out.println("带缓冲区的字符流复制文件花费时间："+t2);

	}

}
