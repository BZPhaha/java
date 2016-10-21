package HDacm;

import java.util.Scanner;

public class sum10031 {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = 0,numAccount=0;
        int max, newmax=0 , startIndex=1, endIndex=1,pos=1;
        int array[] = new int[100000];
        caseNum = scanner.nextInt();
        if (caseNum<1||caseNum>20) {
            return;
        }
        for (int i = 1; i <= caseNum; i++)
        {
            numAccount = scanner.nextInt();
            for(int m=0;m<numAccount;m++){
                array[m]=scanner.nextInt();
            }
            max=array[0];
            newmax=0;
            pos=1;
            for(int n=0;n<numAccount;n++){
                if(newmax>=0){
                    newmax+=array[n];
                }
                else {
                    newmax=array[n];
                    pos=n+1;
                }
                if(newmax>max){
                    max=newmax;
                    endIndex=n+1;
                    startIndex=pos;
                }
            }
            System.out.println("Case " + i + ":");
            System.out.println(max + " " + startIndex + " " + endIndex);
            if (i != caseNum) {
                System.out.print("\n");
            }
        }
    }
}