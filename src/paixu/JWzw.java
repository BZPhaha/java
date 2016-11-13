package paixu;

public class JWzw {
	public static void main(String[] args){
		JWzw j1 = new JWzw();
		int[] in={1,4,2,5,3,6,9};
		j1.insertSort(in);
	}
	public static void insertSort(int[] array) {  
        if (array == null || array.length < 2) {  
            return;  
        }  
        for (int i = 1; i < array.length; i++) {  
            int currentValue = array[i];  
            int position = i;  
            for (int j = i - 1; j >= 0; j--) {  
                if (array[j] > currentValue) {  
                    array[j + 1] = array[j];  
                    position -= 1;  
                } else {  
                    break;  
                }  
            }  
  
            array[position] = currentValue;  
        }    
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]);
			if(i < array.length-1){
				System.out.print(",");
			}
		}
	}
}
