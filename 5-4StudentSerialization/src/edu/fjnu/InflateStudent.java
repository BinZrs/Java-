package edu.fjnu;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class InflateStudent{
	
	/**
	 * 从序列化生成的文件 student.bin中读取 学生对象，并输出学生信息。
	 * 
	 * @param fileName 读取学生信息的文件  
	 * @return
	 */
	public boolean readStuObjInfoFromFile(String fileName) {
		File stuFile = new File(fileName);
		
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		List<Student>stuList = new ArrayList<Student>();
		try {
			fis = new FileInputStream(stuFile);
			in = new ObjectInputStream(fis);
			try{
				while(true){
					Student s = new Student();
					s = (Student)in.readObject();
					stuList.add(s);	
				}
			}catch(EOFException e){
			
			}
			finally{
				fis.close();
				in.close();
			}		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("*****************学生信息(按学号升序)*****************");
		
		for(Student s:stuList){
			System.out.printf("%-15s%-10s%s\n",s.getID(),s.getName(),s.getSex());
		}
		return true;
	}
	
	/*测试main
	public static void main(String[] args) {
		File stuFile = new File("student.bin");
		
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		List<Student>stuList = new ArrayList<Student>();
		try {
			fis = new FileInputStream(stuFile);
			in = new ObjectInputStream(fis);
			try{
				while(true){
					Student s = new Student();
					s = (Student)in.readObject();
					stuList.add(s);	
				}
			}catch(EOFException e){
			
			}
			finally{
				fis.close();
				in.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("------student.bin学生信息如下 ------");
		for(Student s:stuList){
			System.out.println(s.getID()+" "+s.getName()+" "+s.getSex());
		}
		
	}*/
}
