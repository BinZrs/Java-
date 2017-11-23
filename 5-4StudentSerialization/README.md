## 实验5-4 对象序列化
**实验内容：**

    1. 类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性        
       别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照            
       学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可
       以是String也可以是Long。
    2. 使用ObjectOutputStream将已经排序的学生信息写出到文
       件“student.bin”中。
    3. 使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控
       制台中。

**结果截图：**

 ![](https://github.com/BinZrs/JavaLab/raw/master/Image/学生对象序列化.png)
