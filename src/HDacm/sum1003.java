package HDacm;

import java.util.Scanner;

public class sum1003 {
	public static void main(String[] args)   
    {  
        Scanner scan=new Scanner(System.in);  
        	int a=scan.nextInt();  
            for(int i=0;i<a;i++)
            {
            	int count=scan.nextInt();
            	if(count < 1 || count >20)
            	{
            		return;
            	}
            	int[] shuzi=new int[100000];
            	int[] sum1=new int[500];
            	int start=1;
            	int end=0;
            	int sum2=0;
            	int maxsum=-10000;
            	for(int j = 0;j < count;j++)
            	{
            		shuzi[j] = scan.nextInt();
            	}
            	for(int ii=0;ii < count;ii++)
            	{
            		if(shuzi[ii]>=0)
            		{
            			start=ii+1;
            			break;
            		}
            	}
            	for(int jj=start;jj <= count;jj++)
            	{
            		if(jj-start==0)
            		{
            			sum1[jj-start] = shuzi[jj-1];
            		}
            		else
            		{
            			sum1[jj-start] = shuzi[jj-1]+sum1[jj-start-1];
            		}
            	}
            	maxsum=sum1[0];
            	end=1;
            	System.out.println("´ËÊ±"+maxsum);
            	for(int i1=1;i1<count;i1++)
            	{
            		if(sum1[i1] > maxsum)
            		{
            			maxsum = sum1[i1];
            			end=i1+start;
            		}
            	}
            	System.out.println("Case "+(i+1)+":");
            	System.out.println(maxsum+" "+start+" "+end);
            	if(i != (a-1))
            		System.out.println("\n");
            }
        }  
        
}
