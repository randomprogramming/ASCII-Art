import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args){
        ImageReading test = new ImageReading("D:\\pic\\test.png");
        int[][][] colors= test.getImageColor();

        for (var i = 0; i < test.getImageWidth(); i++) {
            for (var j = 0; j < test.getImageHeight(); j++) {
                System.out.print("[");
                for (var k = 0; k < 3; k++){
                    System.out.print(colors[i][j][k]+",");
                }
                System.out.print("] ");
            }
            System.out.println();
        }
    }
}