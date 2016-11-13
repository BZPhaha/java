package javaalgorithm;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 * 
 * �Ӵ��Ǳ�����ԭ�ַ��п����ҵ��ġ����� " I am a student"
am���Ӵ�����ȻҲ�������У�������aa�Ͳ����Ӵ��ˣ��������У���
�Ӵ�������substring
�����С�����subsequence

 Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 pwwkew
 *
 */
public class leetCode3 {
	public static void main(String args[])
	{
		Solution1 s=new Solution1();
		System.out.println(s.lengthOfLongestSubstring("pwwkew"));
	}
	
}
class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
