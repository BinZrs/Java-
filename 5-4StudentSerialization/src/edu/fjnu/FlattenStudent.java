/**
 * 
 */
package edu.fjnu;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 本类 主要实现学生对象序列化，从list.txt文件中读入学生信息，生成学生对象list,通过对象流写入文件。
 */
public class FlattenStudent {
	
	/**
	 * 通过带缓冲输入流  BufferedReader从 文件中读取内容，并调用学生对象set函数设置学生信息。
	 * 从文件中读入学生信息,学生信息包含  学号 姓名 性别
	 * 返回一个按学号升序排序的List
	 * 
	 * @retrun  List<Student> 返回学生对象list
	 */
	public static List<Student> readStuListFromFile(File f){
		List<Student> studentList = new ArrayList<Student>();
		try{
			FileReader fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			Scanner scanner = new Scanner(bfr);//利用scanner读入文件
			while(scanner.hasNext()) {
				Student tmp = new Student();
				tmp.setID(scanner.next());
				tmp.setName(scanner.next());
				tmp.setSex(scanner.next());
				studentList.add(tmp);		
			}	
		}catch(Exception e){
			e.printStackTrace();
		}	
		Collections.sort(studentList);	//对studentList进行排序
		return studentList;
	}
	/**
	 * 通过调用readStuListFromFile(file)返回读取学生list,
	 * 并通过对象流将所有学生对象写入到文件 student.bin
	 * 
	 * @return boolean   true：写入学生信息成功  false：写入失败
	 */
	public boolean outputStudentObject(String inFileName,String outFileName) {
		File file = new File(inFileName);   //输入文件
		File stuFile = new File(outFileName); //输出文件
		
		FileOutputStream fos = null;  
		ObjectOutputStream out = null;  //对象输出流
		
		//调用函数，从list.txt中读取信息，并返回一个按照学号升序的list
		List<Student>stuList = this.readStuListFromFile(file);

		try{
			fos = new FileOutputStream(stuFile);
			out = new ObjectOutputStream(fos);			
			for(Student s:stuList){
				out.writeObject(s);
			}
		//	System.out.println("学生信息成功写入student.bin文件中。");
			out.close();		
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}
	
//  临时测试main	
//	public static void main(String[] args) {
//		
//		File file = new File("list.txt");
//		File stuFile = new File("student.bin");
//		
//		FileOutputStream fos = null;
//		ObjectOutputStream out = null;
//		
//		List<Student>stuList = initStuList(file);
//		
//		try{
//			fos = new FileOutputStream(stuFile);
//			out = new ObjectOutputStream(fos);			
//			for(Student s:stuList){
//				out.writeObject(s);
//			}
//		//	System.out.println("学生信息成功写入student.bin文件中。");
//			out.close();		
//		}catch(Exception e){
//			e.printStackTrace();
//		}	
//	}
		
}
