public class Main {
    public static void main(String[] args){
        ImageReading test = new ImageReading("D:\\pic\\download.png");
        int[][] colors= test.getImageBrightness();

        for (var i = 0; i < test.getImageWidth(); i++) {
            for (var j = 0; j < test.getImageHeight(); j++) {
                System.out.print(Density.DENSITY.getDensityFor(colors[i][j]));
            }
            System.out.println();
        }
    }
}