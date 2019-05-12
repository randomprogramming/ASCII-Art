import java.io.File;
import java.io.FileWriter;

class ImageWriting {
    private int imageWidth;
    private int imageHeight;

    private int[][] brightnessValues;

    private FileWriter writer;

    private boolean isFileFound;

    ImageWriting(int imageWidth, int imageHeight, int[][] brightnessValues, String path) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.brightnessValues = brightnessValues;
        this.isFileFound = false;

        try{
            File textFile = new File(path);
            this.writer = new FileWriter(textFile);
            this.isFileFound = true;
        }
        catch(Exception e){
            System.out.println("Text file not found");
        }
    }
    void writeToFile(){
        if(this.isFileFound) {
            for (var i = 0; i < this.imageWidth; i++) {
                for (var j = 0; j < this.imageHeight; j++) {
                    try {
                        this.writer.append(Density.DENSITY.getDensityFor(this.brightnessValues[i][j]));
                        //this.writer.append(Density.DENSITY.getDensityFor(this.brightnessValues[i][j]));
                    } catch (Exception e) {
                        System.out.println("Error while writing");
                    }
                }
                try {
                    this.writer.write("\n");
                } catch (Exception f) {
                    System.out.println("Error while writing");
                }
            }
        }
    }
}