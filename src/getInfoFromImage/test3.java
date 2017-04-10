package getInfoFromImage;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(isLetter("aaaaaaaaaaa11"));
	}
	public static boolean isLetter(String str)
	{ 
	          java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[a-zA-Z]+"); 
	          java.util.regex.Matcher m = pattern.matcher(str);
	          return m.matches();     
	 }

}
