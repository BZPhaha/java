package Java_Inter;

/*
 * 
 * 有问题
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.Socket;

public class DictClient {
	public static final String SERVER = "dict.org";
	public static final int PORT = 2628;
	public static final int TIMEOUT = 15000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		try {
			System.out.println("开始执行");
			socket = new Socket(SERVER, PORT);
			socket.setSoTimeout(TIMEOUT);
			OutputStream out = socket.getOutputStream();
			Writer writer = new OutputStreamWriter(out,"UTF-8");
			writer = new BufferedWriter(writer);
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			String[] arg1 = {"hello"};
			for(String word : arg1){
				define(word,writer,reader);
			}
			writer.write("quit\r\n");
			System.out.println("结果"+writer);
			writer.flush();
			} catch (Exception e) {
			// TODO: handle exception
		}
			finally{
				//释放资源
				if(socket != null){
					try{
						socket.close();
					}
					catch(IOException e){
						
					}
				}
			}
	}
	
	static void define(String word,Writer writer,BufferedReader reader) throws IOException,UnsupportedEncodingException{
		System.out.println("翻译");
		writer.write("DEFINE eng-lat" + word + "\r\n");
		writer.flush();
		for(String line = reader.readLine();line != null;line = reader.readLine()){
			if(line.startsWith("250 ")){//OK
				//System.out.println("找到了");
				return;
			}
			else if(line.startsWith("552 ")){//无匹配
				System.out.println("No definition found for"+line);
				return;
			}
			else if(line.matches("\\d\\d\\d .*"))continue;
			else if(line.trim().equals(".")) continue;
			else System.out.println(line);
		}
	}

}
