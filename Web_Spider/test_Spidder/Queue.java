package test_Spidder;
/**
 * 队列。保存将要访问的URL
 */
import java.util.LinkedList;

public class Queue {
	private LinkedList queue = new LinkedList();
	//入队列
	public void enQueue(Object t){
		queue.addLast(t);
	}
	//出队列
	public Object deQueue(){
		return queue.removeFirst();
	}
	//判断队列是否为空
	public boolean isQueueEmpty(){
		return queue.isEmpty();
	}
	//判断队列是否包含t
	public boolean contains(Object t){
		return queue.contains(t);
	}
}	
