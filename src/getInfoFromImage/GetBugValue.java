package getInfoFromImage;


//如果int a的值为最小值就MIN_INT。Math.abs(a)的值为 MIN_INT。取反之后就超过int的范围了

public class GetBugValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int seed = 0;
		/*GetBugValue getbv = new GetBugValue();
		getbv.srand(seed);
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = i;
		}*/
		//System.out.println(arr[getbv.next()%100]);
		for(int i = -100000; i < 1000000000;i++){
			//seed = i;
			int a = (398*i) ^ twist(i, 2*i) ^ 0xfba802c7;
			//11111011101010000000001011000111
			//00000100010101111111110100111000
			//00000000000000000000000000000000
			
			//00000000000000010101100111111011
			//(398*i) ^ i = 00000100010101111111110100111000
			
			int b = twist(i, 2*i);
			
			
			//System.out.println(b);
			//System.out.println(a);
			if(a==0){
				System.out.println("seed的值为"+i);
				break;
			}
		}
	}
	
	public void srand(int seed){//先执行这里。
		if(seed == 0)seed =1;
		for(int j = 0; j< 624;j++){
			state[j] = (j+1)*seed;
		}
	}
	
	public int next(){//再执行这里
		if(--left  == 0)next_state();
		return Math.abs(state[624-left]);
	}
	

	public void next_state(){//然后这里
		int p = 0;
		left = 624;
		for (int j = 228; --j > 0; p++) {
			state[p] = state[p+397] ^ twist(state[p],state[p+1]) ^ 2074608327;
		}
		for(int j = 397; --j > 0;p++){
			state[p] = state[p-227] ^ twist(state[p],state[0]) ^ 2074608327;
		}
	}
	
	private static final int twist(int u,int v){//最后这里
		return (((u & 0x80000000) | (v & 0x7fffffff)) >> 1) ^ ((v & 1) == 1 ? 0x9908b0df : 0);
	}
	
	private int[] state =  new int[624];
	private int left = 1;
	
	
	
}
