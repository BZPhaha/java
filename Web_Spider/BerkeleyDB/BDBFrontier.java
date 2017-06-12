package BerkeleyDB;

import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.Set;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.collections.StoredMap;
import com.sleepycat.je.DatabaseException;

public class BDBFrontier extends AbstractFrontier {
	private StoredMap pendingUrisDB = null;
	public BDBFrontier(String homeDirectory) throws DatabaseException,
			FileNotFoundException {
		super(homeDirectory);
		// TODO Auto-generated constructor stub
		EntryBinding keyBinding = new SerialBinding(javaCatalog, String.class);
		EntryBinding valueBinding = new SerialBinding(javaCatalog, CrawUrl.class);
		pendingUrisDB = new StoredMap(database, keyBinding, valueBinding, true);
	}
	//获取下一条记录
	public CrawUrl getNext() throws Exception{
		CrawUrl result = null;
		if(!pendingUrisDB.isEmpty()){
			Set entrys = pendingUrisDB.entrySet();
			System.out.println(entrys);
			Entry<String,CrawUrl> entry = (Entry<String,CrawUrl>)pendingUrisDB.entrySet().iterator().next();
			result = entry.getValue();
			delete(entry.getKey());
		}
		return result;
	}
	//存入URL
	public boolean putUrl(CrawUrl url){
		put(url.getOriUrl(),url);
		return true;
	}
	//存入数据库
	@Override
	protected void put(Object key, Object value) {
		// TODO Auto-generated method stub
		pendingUrisDB.put(key, value);
	}

	@Override
	protected Object get(Object key) {
		// TODO Auto-generated method stub
		return pendingUrisDB.get(key);
	}

	@Override
	protected Object delete(Object key) {
		// TODO Auto-generated method stub
		return pendingUrisDB.remove(key);
	}
	private String caculateUrl(String url){
		return url;
	}
	public static void main(String[] args){
		try {
			BDBFrontier bDBFrontier = new BDBFrontier("c:\\bdb");
			CrawUrl url = new CrawUrl();
			url.setOriUrl("http://www.163.com");
			bDBFrontier.putUrl(url);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
