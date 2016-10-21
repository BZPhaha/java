package HDacm;

import java.util.Scanner;

public class s1005 {
	public static void main(String[] args)   
    {  
        Scanner scan=new Scanner(System.in);  
        while(scan.hasNextInt())
        {
        	int a=scan.nextInt();
        	int b=scan.nextInt();
        	int c=scan.nextInt();
        	if(a == 0 && b == 0 && c == 0)
        	{
        		return;
        	}
        	a%=7;
        	b%=7;
        	System.out.println(f(a,b,c));
        	
        }
    }
	public static int f(int a,int b,int n)
	{
		if(n==1 || n==2)
		{
			return 1;
		}
		else
		{
			return  ((a * f(a,b,n-1) + b * f(a,b,n-2)) % 7);
		}
	}
}
