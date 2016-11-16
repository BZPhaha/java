package Character_generator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* author bzphaha 
 * 
 * 字符生成器
 * */
public class Character_generator {

	public static void main(String[] args) throws IOException {
		try {
			OutputStream out = new FileOutputStream("a.txt");
			try {
				generateCharacters(out);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("运行over");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void generateCharacters(OutputStream out) throws IOException{
		int firstPrintableCharacter = 33;
		int numberOfPrintableCharacters = 94;
		int numberOfCharactersPerLine = 72;
		
		int start = firstPrintableCharacter;
		int j = 0;
		while(true){
			for(int i = start; i < start + numberOfCharactersPerLine; i++){
				out.write(((i - firstPrintableCharacter) % numberOfPrintableCharacters)+firstPrintableCharacter);
			}
			j++;
			out.write('\t');//回车
			out.write('\n');//换行
			start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
			if(j > 32){
				break;
			}
		}
	}
}
