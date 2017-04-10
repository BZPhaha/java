package PaintCircle;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * 根据txt中提供的圆的坐标，画图
 * @author BZP
 *
 */

class PaintovalPane extends JPanel
{
	public static void readTxtFile(String filePath){
        try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        System.out.println(lineTxt);
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
     
    }
 public void paintComponent(Graphics g)
 {
	  super.paintComponent(g);
	  g.setColor(Color.pink);
	String filePath = "E:\\java-study\\Java\\source\\145035182953188.txt";
	try {
        String encoding="GBK";
        File file=new File(filePath);
        if(file.isFile() && file.exists()){ //判断文件是否存在
            InputStreamReader read = new InputStreamReader(
            new FileInputStream(file),encoding);//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while((lineTxt = bufferedReader.readLine()) != null){
            	 String[] a1 = lineTxt.split(" ");
                 //System.out.println(a1[0]+"----"+a1[1]);
                 int a2 = Integer.parseInt(a1[0]);
                 int a3 = Integer.parseInt(a1[1]);
                 g.fillOval(a2, a3, 5, 5);
            }
            read.close();
}else{
    System.out.println("找不到指定的文件");
}
} catch (Exception e) {
    System.out.println("读取文件内容出错");
    e.printStackTrace();
}
 
  
 }
}
class PaintovalFrame extends JFrame
{
 public PaintovalFrame()
 {
  setTitle("lamp");
  setSize(500,500);
  addWindowListener(
  new WindowAdapter()
  {
   public void WindowClosing(WindowEvent e)
   {
    System.exit(0);
   }
  });
  Container contentPane = getContentPane();
  contentPane.add(new PaintovalPane());
 }
}
public class test {
 public static void main(String[] args) {
  JFrame f = new PaintovalFrame();
  f.show();
 }
}
