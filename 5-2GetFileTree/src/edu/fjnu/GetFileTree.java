/**
 * 
 */
package edu.fjnu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.Collator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * @author Administrator
 *
 */
public class GetFileTree{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("请输入文件路径:");
		Scanner scanner = new Scanner(System.in);
		String path = new String("");
		//path = scanner.next(); //next遇到 tab 空格 回车即结束
		path = scanner.nextLine();//读到回车才结束
		File file = new File(path);
		if(!file.exists()) {
			System.out.println(path+"路径不存在!");
		}
		File fileList[] = file.listFiles();
		ArrayList<File> list1 = new ArrayList<File>();
		ArrayList<File> list2 = new ArrayList<File>();
		for(File f:fileList) {
			if(f.isDirectory() && !f.isHidden()) {
				list1.add(f);
			}
			else if(!f.isHidden())
				list2.add(f);
			else;
		}
		Collections.sort(list1, new Comparator<File>() {
			Comparator cmp = Collator.getInstance(Locale.CHINESE);
			@Override
			public int compare(File o1, File o2) {
				// TODO Auto-generated method stub
				return cmp.compare(o1.getName(), o2.getName());
			}				
		});
		Collections.sort(list2, new Comparator<File>() {
			Comparator cmp = Collator.getInstance(Locale.CHINESE);
			@Override
			public int compare(File o1, File o2) {
				// TODO Auto-generated method stub
				return cmp.compare(o1.getName(), o2.getName());
			}				
		});
		File outputFile = new File("output.txt");
		FileWriter out = new FileWriter(outputFile);
		for(File f:list1) {			
			Date date = new Date(f.lastModified());
			DateFormat df = DateFormat.getDateInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			String str= String.format("%-30s%-40s\n",f.getName(),sdf.format(date));
			System.out.print(str);
			//System.out.printf("%-30s%-40s\n",f.getName(),sdf.format(date));
			//	System.out.print(String.format("%-20s",f.getName()));
			//	System.out.println(String.format("%-30s",sdf.format(date)));
			out.write(str);
		}	
		for(File f:list2) {
			Date date = new Date(f.lastModified());
			DateFormat df = DateFormat.getDateInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			String str2=String.format("%-30s%-26s%10s kb\n",f.getName(),sdf.format(date),f.length());
			//System.out.printf("%-30s%-26s%-10s kb\n",f.getName(),sdf.format(date),f.length());
			System.out.print(str2);
			out.write(str2);
		}
		out.close();
	}

}
