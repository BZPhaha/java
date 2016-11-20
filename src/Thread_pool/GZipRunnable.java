package Thread_pool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GZipRunnable implements Runnable {
	private final File input1;
	public  GZipRunnable(File input) {
		// TODO Auto-generated constructor stub
		this.input1 = input;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (!input1.getName().endsWith(".gz")){
			File output = new File(input1.getParent(),input1.getName()+".gz");
			if(!output.exists()){
				try (//with resource JDK 7;Jdk7 x新特性，try-with-resource。
					InputStream in = new BufferedInputStream(new FileInputStream(input1));
					OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)));)
					{
						int b;
						while((b = in.read()) != -1) out.write(b);
					}
				catch (IOException ex ) {
					// TODO: handle exception
					System.err.println(ex);
				}
			}
		}
	}

}
