package javaalgorithm;

public class exp2{

public exp2(){}

public void fengjie(int n){

	for(int i=2;i<=n/2;i++){	
		if(n%i==0){		
		System.out.print(i+"*");		
		fengjie(n/i);		
		}
	}	
	System.out.print(n);	
	System.exit(0);///��������䣬����������
	}	
	public static void main(String[] args){	
	String str="";	
	exp2 c=new exp2();	
	str=javax.swing.JOptionPane.showInputDialog("������N��ֵ������exit�˳�����");	
	int N;
	N=0;	
	try{	
	N=Integer.parseInt(str);	
	}catch(NumberFormatException e){	
	e.printStackTrace();	
	}	
	System.out.print(N+"�ֽ�������"+N+"=");	
	c.fengjie(N);	
	}

}