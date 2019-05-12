public class Main {
    public static void main(String[] args){
        ImageReading readTest = new ImageReading("D:\\pic\\test.png");
        ImageWriting writeTest = new ImageWriting(  readTest.getImageWidth(),
                                                    readTest.getImageHeight(),
                                                    readTest.getImageBrightness(),
                                                "D:\\pic\\textImg.txt");
        writeTest.writeToFile();
    }
}