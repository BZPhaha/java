package Annotation;

public class Test {
	@SuppressWarnings("deprecation")
	public void sing(){
		Person p = new Child();
		
		p.sing();
	}
public static void main(String[] args) {     
        //FruitInfoUtil.getFruitInfo(Apple.class);
		String a= "abc"; 
		String b = "abc" ;
		String c = new String("abc");
		String d = "ab" + "c";
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(a==d);
		System.out.println(c==d);
		
    }
}
