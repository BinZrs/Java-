/**
 * 
 */
package edu.fjnu;

/**
 * Student 对象序列化实验的测试类
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		FlattenStudent fStu = new FlattenStudent();
		InflateStudent iStu = new InflateStudent();
		String readFileName = "list.txt"; 
		String StuFileName = "student.bin";
		
		if(fStu.outputStudentObject(readFileName,StuFileName)) {  // 序列化学生对象，并写入student.bin文件。
			System.out.println("成功序列化学生信息，并写入文件"+StuFileName+"\n");
		}
		else {
			System.out.println("序列化失败");
		}
		if(!iStu.readStuObjInfoFromFile(StuFileName)) { //该函数读取student.bin 文件并输出学生信息
			System.out.println("从"+StuFileName+"读取学生对象信息失败!");
		}
	}
}

