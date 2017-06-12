package BerkeleyDB;

import java.io.FileNotFoundException;

import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;



public abstract class AbstractFrontier {
	private Environment env;
	private static final String CLASS_CATALOG = "java_class_catalog";
	protected StoredClassCatalog javaCatalog;
	protected Database catalodatabase;
	protected Database database;
	
	public AbstractFrontier(String homeDirectory) throws DatabaseException,FileNotFoundException{
		//打开env
		System.out.println("Open environment in : " +  homeDirectory);
		EnvironmentConfig envConfig = new EnvironmentConfig();
		envConfig.setTransactional(true);
		envConfig.setAllowCreate(true);
		//设置DatabaseConfig
		DatabaseConfig dbConfig = new DatabaseConfig();
		dbConfig.setTransactional(true);
		dbConfig.setAllowCreate(true);
		//打开
		catalodatabase = env.openDatabase(null, CLASS_CATALOG, dbConfig);
		javaCatalog = new StoredClassCatalog(catalodatabase);
		//设置DatabaseConfig
		DatabaseConfig dbConfig0 = new DatabaseConfig();
		dbConfig0.setTransactional(true);
		dbConfig0.setAllowCreate(true);
		//打开
		database = env.openDatabase(null, "URL", dbConfig);
	}
	public void close() throws DatabaseException{
		database.close();
		javaCatalog.close();
		env.close();
	}
	protected abstract void put(Object key,Object value);
	protected abstract Object get(Object key);
	protected abstract Object delete(Object key);
}
