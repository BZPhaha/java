package paixu;
/*
 * author bzphaha
 * 二分查找
 */
public class BisearchFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] b = {1,2,3,4,5,6,10,30,40,50};
		System.out.println(bisearFind1(b, 500));
	}
	public static boolean bisearFind1(int[] arr,int b){
		int right=arr.length-1;
		int left = 0;
		int m ;
		while(right >= left ){
			m = (right + left) / 2;
			//System.out.println(right+" "+left+" "+m);
			if(b == arr[m]){
				return true;
			}
			else if(b < arr[m]){
				right = m-1;
			}
			else{
				left = m+1;
			}
		}
		return false;
	}

}
