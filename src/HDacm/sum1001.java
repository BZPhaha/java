package HDacm;
import java.util.Scanner;  
	  
public class sum1001
{    
	    public static void main(String[] args)   
	    {  
	        Scanner scan=new Scanner(System.in);  
	        while(scan.hasNextInt())  
	        {  
	            int a=scan.nextInt();  
	            if(a >=1)
		        {
		            int sum = 0;
		            for(int i=1;i<=a;i++)
		            {
		              sum+=i;
		            }
		            System.out.println(sum);
		            System.out.println();
		        }
	        }  
	        
	    }  
}  

