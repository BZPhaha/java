package javaalgorithm;

import java.util.Arrays;

public class leetCode4 
{
	public static void main(String args[])
	{
		/*int[] nums1 = {1, 3};
		int[] nums2 = {2};
		Solution2 s1=new Solution2();
		System.out.println(s1.findMedianSortedArrays(nums1,nums2));*/
	       /* int result = 0;
	        int i=2;
	        switch (i) {
	        case 1:
	            result = result + i;
	        case 2:
	            result = result + i * 2;
	        case 3:
	            result = result + i * 3;
	        }
	        System.out.println(result);*/
		/*String str1 = null;
		String str2 = "test";
		System.out.println(str1+str2);*/
	}
}

class Solution2 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
    	 int n=nums1.length + nums2.length;
    	 int[] nums3=new int[n];
    	 int a = nums1.length;
    	 for(int i=0;i<n;i++)
    	 {
    		 if(i<a)
    		 {
    			 nums3[i]=nums1[i];
    		 }
    		 else
    		 {
    			 nums3[i]=nums2[i-a];
    		 }
    	 }
    	Arrays.sort(nums3);;
    	int b=n/2;
    	System.out.println("b��ֵΪ"+b);
    	int c=b+1;
    	if(n%2 == 0)
    	{
    		System.out.println(nums3[b]+" ��"+nums3[c]);
    		return (nums3[b]+nums3[c])/2;
    	}
    	else
    	{
    		return nums3[b];
    	}
    }  
}