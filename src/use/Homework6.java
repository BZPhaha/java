package use;

public class Homework6 {
    public static void main(String args[]){ 
	for(int i=1;i<=3;i+=2){
	for(int kong=7;kong>i-1;kong--){
	System.out.print(" ");
	}
	for(int cha=1;cha<=i;cha++){
	System.out.print("××");
	}
	System.out.println();
	}
	
	for(int j=1;j<=5;j+=2){
	for(int kong1=1;kong1<j+3;kong1++){
	System.out.print(" ");
	}
	for(int cha1=5;cha1>=j;cha1--){
	System.out.print("××");
	}
	System.out.println();
	}
	}
}
