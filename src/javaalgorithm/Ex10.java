package javaalgorithm;

public class Ex10 {

public static void main(String[] args)
{
	double s=0;
	double t=100;
	for(int i=1;i<=10;i++)
	{
		s+=t;
		t=t/2;
	}
	System.out.println(s);
	System.out.println(t);
	}
}