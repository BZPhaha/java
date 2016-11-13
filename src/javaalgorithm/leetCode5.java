package javaalgorithm;

public class leetCode5 {

	public static void main(String[] args)
	{
		String ss="aaa11asdasdwqegsddsfdaaaaabbavccvasdasdsa";
		leetCode5 l1=new leetCode5();
		String s1=l1.longestPalindrome(ss);
		System.out.println(s1);
	}
	
	public String longestPalindrome(String s) {
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
}
