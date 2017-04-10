package use;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class painttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List nowlist = new ArrayList();
		Map nowMap = new HashMap();
		
	}
	
	public static int[] getallaround(List nowList){
		int[] getaround = new int[nowList.size()];
		Iterator<int[]> iterator =  nowList.iterator();
		int count=0;
		while(iterator.hasNext()){
			count++;
			int getcount=0;
			List getaroundlive=new ArrayList();
			int[] now = iterator.next();
			int[] nowlefttop = new int[2];
			int[] nowtop = new int[2];
			int[] nowleft = new int[2];
			int[] nowleftbottom = new int[2];
			int[] nowbottom = new int[2];
			int[] nowbottomright = new int[2];
			int[] nowtopright = new int[2];
			int[] nowright = new int[2];
			nowlefttop[0]=now[0]-1;
			nowlefttop[1]=now[1]-1;
			nowtop[0]=now[0];
			nowtop[1]=now[1]-1;
			nowleft[0]=now[0]-1;
			nowleft[1]=now[1];
			nowleftbottom[0]=now[0]-1;
			nowleftbottom[1]=now[1]+1;
			nowbottom[0]=now[0];
			nowbottom[1]=now[1];
			nowbottomright[0]=now[0]+1;
			nowbottomright[1]=now[1]+1;
			nowtopright[0]=now[0]+1;
			nowtopright[1]=now[1]-1;
			nowright[0]=now[0]+1;
			nowright[1]=now[1];
			getaroundlive.add(nowlefttop);
			getaroundlive.add(nowleft);
			getaroundlive.add(nowleftbottom);
			getaroundlive.add(nowtop);
			getaroundlive.add(nowbottom);
			getaroundlive.add(nowbottomright);
			getaroundlive.add(nowtopright);
			getaroundlive.add(nowright);
			Iterator<int[]> iteratorgetaround =  getaroundlive.iterator();
			while(iteratorgetaround.hasNext()){
				if(nowList.contains(iteratorgetaround.next())){
					getcount++;
				}
			}
			getaround[count]=getcount;
		}
		return getaround;
	}

}
