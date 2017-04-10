package PaintCircle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class test2 {
    public static void main(String[] args) throws IOException {
        BufferedImage im= ImageIO.read(new File("E:\\java-study\\Java\\source\\145620227274859.jpg"));//读取图片
        int width = im.getWidth();
        int height = im.getHeight();
        for(int i = 0; i < width; i++){
            for(int j = 0; j< height; j++){
                int color=im.getRGB(i, j);
                int r=(color>>16)&255;//获取red分量
                im.setRGB(i,j,0);
                if(r%2 == 1){
                    im.setRGB(i, j, 255);
                }
            }
        }
        File outputfile = new File("E:\\java-study\\Java\\source\\res.png");
        ImageIO.write(im, "png",outputfile);
    }
}
