public class Main {
    public static void main(String[] args){
        ImageReading test = new ImageReading("D:\\pic\\test.png");
        int[][] colors= test.getImageBrightness();

        for (var i = 0; i < test.getImageWidth(); i++) {
            for (var j = 0; j < test.getImageHeight(); j++) {
                System.out.print(colors[i][j]+", ");
            }
            System.out.println();
        }
    }
}