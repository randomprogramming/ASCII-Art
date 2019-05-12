import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class ImageReading {
    private BufferedImage image;
    
    private int imageWidth;
    private int imageHeight;

    private boolean isImageRead;

    ImageReading(String path) {
        this.isImageRead = false;

        try{
            File imageFile = new File(path);
            this.image = ImageIO.read(imageFile);
            this.isImageRead = true;
        }
        catch (Exception e){
            System.out.println("Image not found!");
        }
        if(this.isImageRead) {
            this.imageWidth = this.image.getWidth();
            this.imageHeight = this.image.getHeight();
        }
    }
    int[][] getImageBrightness(){
        //Extract a Colors class from each pixel of the picture
        Color[][] colors = new Color[this.imageWidth][this.imageHeight];

        for (var i = 0; i < this.imageWidth; i++) {
            for (var j = 0; j < this.imageHeight; j++) {
                colors[i][j] = new Color(this.image.getRGB(i, j));
            }
        }
        //Turn the Color array to 3d array of rgb values
        return RGBToBrightness(colorToRGB(colors));
    }
    private int[][][] colorToRGB(Color[][] colors){
        //Go through the whole Color array, read the R, G, B values and put them inside the 3d array
        int[][][] rgb = new int[this.imageWidth][this.imageHeight][3];

        for (var i = 0; i < this.imageWidth; i++) {
            for (var j = 0; j < this.imageHeight; j++) {
                rgb[i][j][0] = colors[i][j].getRed();
                rgb[i][j][1] = colors[i][j].getGreen();
                rgb[i][j][2] = colors[i][j].getBlue();
            }
        }
        return rgb;
    }
    private int[][] RGBToBrightness(int[][][] rgb){
        int[][] brightness = new int[this.imageWidth][this.imageHeight];

        for (var i = 0; i < this.imageWidth; i++) {
            for (var j = 0; j < this.imageHeight; j++) {
                brightness[i][j] = getAverage(rgb[i][j][0], rgb[i][j][1], rgb[i][j][2]);
            }
        }
        return brightness;
    }
    private int getAverage(int r, int g, int b){
        //This can be changed later to other methods for defining the brightness of a pixel
        return (r + g + b) / 3;
    }
    int getImageWidth(){
        return this.imageWidth;
    }
    int getImageHeight() {
        return this.imageHeight;
    }
}