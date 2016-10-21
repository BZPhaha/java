package HDacm;

import java.util.Scanner;

public class s1004 {
	public static void main(String[] args)   
    {  
        Scanner scan=new Scanner(System.in);  
        while(scan.hasNextInt())
        	{
        	 int a=scan.nextInt();
        	 String colornow=new String();
             int maxcount=0;
             String colornew=new String();
             int nowcount=0;
        	 if(a==0)
        	 {
        		 return;
        	 }
        	 String[] colorall=new String[a];
        	 for(int i=0;i<a;i++)
        	 {
        		 colorall[i]=scan.next();
        	 }
        	 for(int ii=0;ii<a;ii++)
        	 {
        		 colornew=colorall[ii];
        		 nowcount=1;
        		 for(int j=ii;j<a;j++)
        		 {
        			 if(colornew.equals(colorall[j]))
        			 {
        				 nowcount++;
        			 }
        		 }
        		 if(nowcount>maxcount)
        		 {
        			 colornow=colornew;
        			 maxcount=nowcount;
        		 }
        	 }
        	 System.out.println(colornow);
        	}
    }
}