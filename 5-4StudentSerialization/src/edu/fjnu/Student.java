/**
 * 
 */
package edu.fjnu;

import java.io.Serializable;
import java.util.Collections;
/**
 * Student类  实现了Serializable,Comparable<Student>连个接口，
 * 实现第一个接口为了对 学生类进行序列化，  第二个接口为了实现对学生对象的自定义排序
 */
public class Student implements Serializable,Comparable<Student>{
	private static final long serialVersionUID = 1234L; //UID
	private String studentID;
	private String name;
	private String sex;
	@Override 
	public int compareTo(Student obj) {	 //重写compareTo方法
		return this.studentID.compareTo(obj.studentID);
	}
	
	public void setID(String id){
		this.studentID = id;
	}
	
	public String getID(){
		return this.studentID;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	
	public String getSex(){
		return this.sex;
	}
	
}
