package test_Spidder;

import java.util.HashSet;
import java.util.Set;

/**
 * 保存已经访问过的URL
 * @author BZP
 *
 */
public class LinkQueue {
	//已经访问的URL集合
	private static Set visitedUrl = new HashSet();
	//未访问的URL集合
	private static Queue unVisitedUrl = new Queue();
	//获得URL队列
	public static Queue getUnVisitedUrl(){
		return unVisitedUrl;
	}
	//添加到访过的URL队列中
	public static void addVisitedUrl(String url){
		visitedUrl.add(url);
	}
	//移除访问过的url
	public static void removeVisitedUrl(String url){
		visitedUrl.remove(url);
	}
	//未访问过的URL出队列
	public static Object unVisitedUrlDeQueue()
	{
		return unVisitedUrl.deQueue();
	}
	//保证每个URL只被访问一次
	public static void addUnvisitedUrl(String url){
		if(url != null && !url.trim().equals("") && !visitedUrl.contains(url) && !unVisitedUrl.contains(url)){
			unVisitedUrl.enQueue(url);
		}
	}
	//获得已经访问呢的URL数目
	public static int getVisitedUrlNum(){
		return visitedUrl.size();
	}
	//判断未访问的url是否为空
	public static boolean unVisitedUrlsEmpty(){
		return unVisitedUrl.isQueueEmpty();
	}
	
}
