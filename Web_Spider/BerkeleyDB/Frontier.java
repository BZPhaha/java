package BerkeleyDB;

public interface Frontier {
	public CrawUrl getnext() throws Exception;
	public boolean putUrl(CrawUrl url) throws Exception;
}
