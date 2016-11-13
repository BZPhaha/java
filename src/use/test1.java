package use;

public class test1 {
	public static void main(String[] args) {
		int n=99;
		int result=calculate(n);
		System.out.print(result);	
	}
	
	static int calculate(int n){
		int result=0;
		boolean flag=false;
		//No.1
		//开始写代码，不用操作符计算1+2+……+n
		return n > 0 ? n + calculate(n-1) : 0 ;
		//end_code
	}
	static int calculate1(int n){
		int rsult = 0;
		while(n>0)
		{
			rsult += n;
			n--;
		}
		return rsult;
	}
}