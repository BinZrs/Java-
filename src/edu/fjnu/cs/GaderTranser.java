package edu.fjnu.cs;

public class GaderTranser {
	/**
	 * ���ٷ��Ƴɼ�ת��Ϊ��Ӧ�ȼ�
	 * @param zrs
	 */
	public static void toGraderScore(int [] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < 0 || arr[i] > 100) {
				System.out.println("����:"+arr[i]+" ��������");
				continue;
			}
			if(arr[i] >= 90){
				System.out.println("����:"+arr[i]+" ��Ӧ�ȼ�Ϊ:��");
			}
			else if(arr[i] >= 80){
				System.out.println("����:"+arr[i]+" ��Ӧ�ȼ�Ϊ:��");
			}
			else if(arr[i] >= 70){
				System.out.println("����:"+arr[i]+" ��Ӧ�ȼ�Ϊ:��");
			}
			else if(arr[i] >= 60){
				System.out.println("����:"+arr[i]+" ��Ӧ�ȼ�Ϊ:����");
			}
			else{
				System.out.println("����:"+arr[i]+" ��Ӧ�ȼ�Ϊ:������");
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score[] = {100,90,85,76,66,52,18};	
		toGraderScore(score);//�����Ӧ�ɼ��ȼ�
	}

}
