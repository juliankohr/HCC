import ij.*;
import ij.plugin.filter.PlugInFilter;
import ij.process.*;

//Übungsaufgaben I, SBV1, Aufgabe 1.2 Konvertierung RGB nach Graustufen, a)

public class Greyscale_ implements PlugInFilter {

    public int setup(String arg, ImagePlus imp) {
        if (arg.equals("about"))
        {showAbout(); return DONE;}
        //accepts RGB images as input
        return DOES_RGB;
    } //setup


    public void run(ImageProcessor ip) {
        int width = ip.getWidth();
        int height = ip.getHeight();

        //create 3-dimensional channel image (z-axis: [0] = R, [1] = G, [2] = B)
        int[][][] channelImage = ImageJUtility.getChannelImageFromIP(ip, width, height, 3);

        //use generated channel image in greyscale functions for average and lightness method
        int[][] greyscale_average = getGreyscaleAverage(channelImage, width, height);
        int[][] greyscale_lightness = getGreyscaleLightness(channelImage, width, height);

        //use returned 2-dimensional array of function to generate new image
        ImageJUtility.showNewImage(greyscale_average, width, height, "greyscale_average");
        ImageJUtility.showNewImage(greyscale_lightness, width, height, "greyscale_lightness");
    } //run


    //greyscale filter using average value of R, G and B channel
    public static int[][] getGreyscaleAverage(int[][][] channelImage, int width, int height) {
        //defining 2-dimensional array "returnImg"
        int[][] returnImg = new int[width][height];

        //looping through all pixels in width
        for (int x = 0; x < width; x++) {
            //looping through all pixels in height
            for (int y = 0; y < height; y++) {
                //dividing the sum of R, G and B values at same [x][y]-position through 3 (because RGB has 3 channels)
                double averageValDbl = (channelImage[x][y][0] + channelImage[x][y][1] + channelImage[x][y][2]) / 3.0;

                //rounding the double value arithmetically for better precision
                int averageValInt = (int) Math.round(averageValDbl);

                //writing values into 2-dimensional "returnImg" array
                returnImg[x][y] = averageValInt;
            }
        }
        //return 2-dimensional array "returnImg"
        return returnImg;
    } //getGreyscaleAverage


    //greyscale filter using max + min value of R, G and B channel divided by 2
    public static int[][] getGreyscaleLightness(int[][][] channelImage, int width, int height) {
        //defining 2-dimensional array "returnImg"
        int[][] returnImg = new int[width][height];

        //looping through all pixels in width
        for (int x = 0; x < width; x++) {
            //looping through all pixels in height
            for (int y = 0; y < height; y++) {
                //determine which value of R, G and B is the highest and which is the lowest
                int maxVal = Math.max(channelImage[x][y][0], Math.max(channelImage[x][y][1], channelImage[x][y][2]));
                int minVal = Math.min(channelImage[x][y][0], Math.min(channelImage[x][y][1], channelImage[x][y][2]));

                //add the values together and divide them by 2
                double lightnessValDbl = (maxVal + minVal) / 2.0;

                //rounding the double value arithmetically
                int lightnessValInt = (int) Math.round(lightnessValDbl);

                //afterwards write value into 2-dimensional "returnImg" array
                returnImg[x][y] = lightnessValInt;
            }
        }
        //return 2-dimensional array "returnImg"
        return returnImg;
    } //getGreyscaleLightness


    void showAbout() {
        IJ.showMessage("About Template_...",
                "this is a Greyscale filter that outputs two processed greyscale images\n");
    } //showAbout

} //class Greyscale_