package test_Spidder;

import java.util.Set;

public class MyCrawler {
	private void initCrawlerWithSeeds(String[] seeds){
		for(int i = 0; i < seeds.length;i++){
			LinkQueue.addUnvisitedUrl(seeds[i]);
		}
	}
	public void crawling(String[] seeds){
		LinkFilter  filter = new LinkFilter(){
			@Override
			public boolean accept(String url) {
				// TODO Auto-generated method stub
				if(url.startsWith("http://www.baidu.com"))
					return true;
				return false;
			}
		};
		initCrawlerWithSeeds(seeds);
		while(!LinkQueue.unVisitedUrlsEmpty() && LinkQueue.getVisitedUrlNum() <= 1000){
			String visitUrl = (String)LinkQueue.unVisitedUrlDeQueue();
			if(visitUrl == null){
				continue;
			}
			DownLoadFile downLoad = new DownLoadFile();
			downLoad.downloadFile(visitUrl);
			LinkQueue.addVisitedUrl(visitUrl);
			Set<String> links = HtmlParaseTool.extracLinks(visitUrl, filter);
			for(String link:links){
				LinkQueue.addUnvisitedUrl(link);
			}
		}
	}
	public static void main(String[] args){
		MyCrawler myCrawler = new MyCrawler();
		myCrawler.crawling(new String[]{"http://www.baidu.com"});
	}
}
