package javaalgorithm;

public class findprime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findprimeway f1 = new findprimeway();
		for(int i=100;i<200;i++)
		{
			if(f1.iszhishu(i))
			{
				System.out.println(i);
			}
		}
	}

}
class findprimeway
{
	public boolean iszhishu(int x)
	{
		for(int i=2;i<=x/2;i++)	
		if (x % i==0 )
		return false;	
		return true;

	}
}
