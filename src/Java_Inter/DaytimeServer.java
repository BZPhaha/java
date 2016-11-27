package Java_Inter;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaytimeServer {
	public final static int PORT = 13;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ServerSocket server = new ServerSocket(PORT)){
			while(true){
				try (Socket connection = server.accept()){
					System.out.println("已连接");
					Writer out = new OutputStreamWriter(connection.getOutputStream());
					Date now = new Date();
					out.write(now.toString()+"\r\n");
					out.flush();
					connection.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

}
