package getInfoFromImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import junit.framework.Assert; 


import getInfoFromImage.test2;

public class test {
	/*public static void main(String[] args){
		try {
			new test().testRotate(1,10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public void testRotate(String filepath,int c,int b,int a) throws IOException {
		//"C://Users//BZP//Desktop//im.png"
		BufferedImage src = ImageIO.read(new File(filepath));
		BufferedImage des = test2.Rotate(src, a);
		Assert.assertNotNull(des);
		Assert.assertTrue(ImageIO.write(des, "jpg", new File("C://Users//BZP//Desktop//aaaa//d"+c+"og"+b+".png")));
		System.out.println("生成成功");

		// bigger angel
		/*des = test2.Rotate(src, 150);
		Assert.assertNotNull(des);
		Assert.assertTrue(ImageIO.write(des, "jpg", new File("d:/dog3.jpg")));*/

		// bigger angel
		/*des = test2.Rotate(src, 270);
		Assert.assertNotNull(des);
		Assert.assertTrue(ImageIO.write(des, "jpg", new File("d:/dog4.jpg")));*/

	}

}