package Thread_pool;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * author bzphaha
 * 多线程压缩文件
 * 
 */

public class GZipAllFiles {
	public final static int THREAD_COUNT = 4;
	public static void main(String[] args){
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
		String[] args1 = {"F:\\test1.doc","F:\\test2.doc"};
		for(String filename : args1){
			File f = new File(filename);
			if(f.exists()){
				if(f.isDirectory()){
					File[] files = f.listFiles();
					for(int i = 0;i < files.length;i++){
						if(!files[i].isDirectory()){
							Runnable task = new GZipRunnable(f);
							pool.submit(task);
						}
					}
					System.out.println("执行1");
				}
				else{
					Runnable task  = new GZipRunnable(f);
					pool.submit(task);
					System.out.println("执行2");
				}
			}
		}
		System.out.println("执行3");
		pool.shutdown();
	}
}
