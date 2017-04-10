package use;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * 用NIO把20g的文件分割开 生成到temp文件里
 * 然后再用传统的方法去读取每一个小文件
 */
/**
 *
 * 用NIO把20g的文件分割开 生成到temp文件里
 * 然后再用传统的方法去读取每一个小文件
 */
public class test2
{
 public static void main(String args[]) throws IOException
 {
	 String filePath = "E:\\java-study\\Java\\src\\use\\uv.txt";
  /*FileInputStream fin = new FileInputStream(filePath);
  FileChannel fcin = fin.getChannel();
  ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 50);
  while(true)
  {
   buffer.clear();
   int flag = fcin.read(buffer);
   if(flag == -1)
   {
    break;
   }
   buffer.flip();
   FileOutputStream fout = new FileOutputStream("d:\\temp\\" + Math.random() + ".log");
   FileChannel fcout = fout.getChannel();
   fcout.write(buffer);
   Buffer bb = buffer.flip();
   
   System.out.println();*/
   
   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
   
   String text = null;
   Map<String,String> map = new HashMap<String, String>();
   while((text = bufferedReader.readLine()) != null) {
       String[] strList = text.split("\\s");
       String value = map.get(strList[1]);
       
       if(value == null) {
           map.put(strList[1], strList[2]);
       }
   }
   
   bufferedReader.close();
   
   System.out.println("map.size = " + map.size());
 }
}