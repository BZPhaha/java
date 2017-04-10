package getInfoFromImage;

public class getResultThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new getRessult1().start();
		/*new getRessult2().start();
		new getRessult3().start();
		new getRessult4().start();*/
		System.out.println("执行结束");
	}

}
class getRessult1 extends Thread{
	public void run() {
        System.out.println( " 线程-1-运行开始!");
		OcrTest.getResult(0, 10000);
        System.out.println("  线程-1-线程运行结束!");
    }
}
class getRessult2 extends Thread{
	public void run() {
        System.out.println( " 线程-2-运行开始!");
		OcrTest.getResult(1000, 2000);
        System.out.println("  线程-2-线程运行结束!");
    }
}
class getRessult3 extends Thread{
	public void run() {
        System.out.println( " 线程-3-运行开始!");
		OcrTest.getResult(2000, 3000);
        System.out.println("  线程-3-线程运行结束!");
    }
}
class getRessult4 extends Thread{
	public void run() {
        System.out.println( " 线程-4-运行开始!");
		OcrTest.getResult(3000, 4000);
        System.out.println("  线程-4-线程运行结束!");
    }
}
class getRessult5 extends Thread{
	public void run() {
        System.out.println( " 线程-5-运行开始!");
		OcrTest.getResult(4000, 5000);
        System.out.println("  线程-5-线程运行结束!");
    }
}
class getRessult6 extends Thread{
	public void run() {
        System.out.println( " 线程-6-运行开始!");
		OcrTest.getResult(5000, 6000);
        System.out.println("  线程-6-线程运行结束!");
    }
}
class getRessult7 extends Thread{
	public void run() {
        System.out.println( " 线程-7-运行开始!");
		OcrTest.getResult(6000, 7000);
        System.out.println("  线程-7-线程运行结束!");
    }
}
class getRessult8 extends Thread{
	public void run() {
        System.out.println( " 线程-8-运行开始!");
		OcrTest.getResult(7000, 8000);
        System.out.println("  线程-8-线程运行结束!");
    }
}
class getRessult9 extends Thread{
	public void run() {
        System.out.println( " 线程-9-运行开始!");
		OcrTest.getResult(8000, 9000);
        System.out.println("  线程-9-线程运行结束!");
    }
}
class getRessult10 extends Thread{
	public void run() {
        System.out.println( " 线程-10-运行开始!");
		OcrTest.getResult(9000, 10000);
        System.out.println("  线程-10-线程运行结束!");
    }
}
