package HDacm;

import java.math.BigInteger;
import java.util.Scanner;

public class sum1002
{    
	    public static void main(String[] args)   
	    {  
	        Scanner scan=new Scanner(System.in);  
	        while(scan.hasNextInt())  
	        {  
	            int a=scan.nextInt();  
	            for(int i=0;i<a;i++)
	            {
	            	BigInteger num1 = scan.nextBigInteger();
	            	BigInteger num2 = scan.nextBigInteger();
	            	BigInteger num3=num1.add(num2);
	            	System.out.println("Case "+(i+1)+":");
	            	System.out.println(num1.toString()+" + "+num2.toString()+" = "+num3.toString());
	            	if(i != (a-1))
	            	System.out.println();
	            }
	        }  
	    }  
}  
