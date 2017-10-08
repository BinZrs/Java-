

public class GaderTranser {
	/**
	 * 将百分制成绩转换为对应等级
	 * @param zrs
	 */
	public static void toGraderScore(int [] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < 0 || arr[i] > 100) {
				System.out.println("分数:"+arr[i]+" 数据有误！");
				continue;
			}
			if(arr[i] >= 90){
				System.out.println("分数:"+arr[i]+" 对应等级为:优");
			}
			else if(arr[i] >= 80){
				System.out.println("分数:"+arr[i]+" 对应等级为:良");
			}
			else if(arr[i] >= 70){
				System.out.println("分数:"+arr[i]+" 对应等级为:中");
			}
			else if(arr[i] >= 60){
				System.out.println("分数:"+arr[i]+" 对应等级为:及格");
			}
			else{
				System.out.println("分数:"+arr[i]+" 对应等级为:不及格");
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score[] = {100,90,85,76,66,52,18};	
		toGraderScore(score);//输出对应成绩等级
	}

}
