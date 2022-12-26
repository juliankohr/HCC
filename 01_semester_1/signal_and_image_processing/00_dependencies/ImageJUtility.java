

import ij.ImagePlus;
import ij.gui.PolygonRoi;
import ij.process.ByteProcessor;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

public class ImageJUtility {

	/**
	 * 
	 * @param pixels 1D byte array from ImageProcessor
	 * @param width 
	 * @param height
	 * @return 2D image array
	 */
	public static int[][] convertFrom1DByteArr(byte[] pixels, int width, int height) {
		
		int[][] inArray2D = new int[width][height];
				
		int pixelIdx1D = 0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				inArray2D[x][y] = (int) pixels[pixelIdx1D];
				if (inArray2D[x][y] < 0) {
					inArray2D[x][y] += 256;
				} // if
				pixelIdx1D++;
			}
		}
		
		return inArray2D;		
	}	
	
	/**
	 * conversion from int to double image mask for intermediate calculations
	 * @param inArr int[][] image array
	 * @param width
	 * @param height
	 * @return double[][] image array
	 */
	public static double[][] convertToDoubleArr2D(int[][] inArr, int width, int height) {
		double[][] returnArr = new double[width][height];
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				returnArr[x][y] = inArr[x][y];
			}
		}
		
		return returnArr;
	}
	
	/**
	 * conversion from double to int image mask for visualization / result representation
	 * @param inArr double[][] image array
	 * @param width
	 * @param height
	 * @return int[][] image array
	 */
	public static int[][] convertToIntArr2D(double[][] inArr, int width, int height) {
		int[][] returnArr = new int[width][height];
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				returnArr[x][y] = (int)(inArr[x][y] + 0.5);
			}
		}
		
		return returnArr;
	}
	
	/**
	 * conversion back to 1D byte array for ImageJ use
	 * @param inArr
	 * @param width
	 * @param height
	 * @return
	 */
	public static byte[] convertFrom2DIntArr(int[][] inArr, int width, int height) {
	  int pixelIdx1D = 0;
	  byte[] outArray2D = new byte[width * height];
	  
	  for (int y = 0; y < height; y++) {
		for (int x = 0; x < width; x++) {
			int resultVal = inArr[x][y];
			if (resultVal > 127) {
		      resultVal -= 256;
			}				
			outArray2D[pixelIdx1D] = (byte) resultVal;
			pixelIdx1D++;
			}
		}
	  
	  return outArray2D;
	}
	
	/**
	 * opening new window for image visualization
	 * @param inArr
	 * @param width
	 * @param height
	 * @param title
	 */
	public static void showNewImage(int[][] inArr, int width, int height, String title) {
		byte[] byteArr = ImageJUtility.convertFrom2DIntArr(inArr, width, height);
		ImageJUtility.showNewImage(byteArr, width, height, title);
	}
	
	/**
	 * 
	 * @param inArr
	 * @param width
	 * @param height
	 * @param title
	 * @param roi - ROI visualized in result representation
	 */
	public static void showNewImage(int[][] inArr, int width, int height, String title, PolygonRoi roi) {
		byte[] byteArr = ImageJUtility.convertFrom2DIntArr(inArr, width, height);
		ImageJUtility.showNewImage(byteArr, width, height, title, roi);
	}
	
	/**
	 * 
	 * @param inArr in double[][] representation
	 * @param width
	 * @param height
	 * @param title
	 */
	public static void showNewImage(double[][] inArr, int width, int height, String title) {
		int[][] intArr = ImageJUtility.convertToIntArr2D(inArr, width, height);
		byte[] byteArr = ImageJUtility.convertFrom2DIntArr(intArr, width, height);
		ImageJUtility.showNewImage(byteArr, width, height, title);
	}
	

	/**
	 * 
	 * @param inDataArr - 3 channel RGB image mask int[][][] to be visualized as RGB image
	 * @param width
	 * @param height
	 * @param title
	 */
	public static void showNewImageRGB(int[][][] inDataArr, int width, int height, String title) {
		ImageProcessor outImgProc = new ColorProcessor(width, height);
		int[] channelArr = new int[3];
		for(int x = 0; x < width; x++) {
		  for(int y = 0; y < height; y++) {
			channelArr[0] = inDataArr[x][y][0];
			channelArr[1] = inDataArr[x][y][1];
			channelArr[2] = inDataArr[x][y][2]; 
	    	outImgProc.putPixel(x, y, channelArr);					
		  }
		}
							  
		  ImagePlus ip = new ImagePlus(title, outImgProc);		 
		  ip.show(); 
	}
	
	/**
	 * 
	 * @param inByteArr
	 * @param width
	 * @param height
	 * @param title
	 */
	public static void showNewImage(byte[] inByteArr, int width, int height, String title) {
		  ImageProcessor outImgProc = new ByteProcessor(width, height);
		  outImgProc.setPixels(inByteArr);
		  
		  ImagePlus ip = new ImagePlus(title, outImgProc);		 
		  ip.show();
	}
	
	/**
	 * 
	 * @param inByteArr
	 * @param width
	 * @param height
	 * @param title
	 * @param roi
	 */
	public static void showNewImage(byte[] inByteArr, int width, int height, String title, PolygonRoi roi) {
	  ImageProcessor outImgProc = new ByteProcessor(width, height);
	  outImgProc.setPixels(inByteArr);
	  
	  ImagePlus ip = new ImagePlus(title, outImgProc);
	  ip.setRoi(roi);
	  ip.show();
	}
	
	
		
	/**
	 * representing 3-channel RGB image as int[][][]
	 * @param ip
	 * @param width
	 * @param height
	 * @param numOfChannels
	 * @return
	 */
	public static int[][][] getChannelImageFromIP(ImageProcessor ip, int width, int height, int numOfChannels) {
		int [][][] returnMask = new int[width][height][numOfChannels];
		
		int[] channelArr = new int[numOfChannels];
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				ip.getPixel(x, y, channelArr);
				for(int z = 0; z < numOfChannels; z++) {
					returnMask[x][y][z] = channelArr[z];
				}
			}
		}
		
		return returnMask;
	}
	
	/**
	 * extract one color channel as separate image from int[][][] 3-channel structure
	 * @param inImg
	 * @param width
	 * @param height
	 * @param channelID
	 * @return
	 */
	public static int[][] getChannel(int[][][] inImg, int width, int height, int channelID) {
		int[][] returnArr = new int[width][height];
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				returnArr[x][y] = inImg[x][y][channelID];
			}
		}
		return returnArr;
	}
	
	/**
	 * assign int[][] color layer to int[][][] 3-channel RGB structure
	 * @param inImg
	 * @param width
	 * @param height
	 * @param channelID in [0;2]
	 * @param channelArr
	 * @param numOfChannels == 3
	 * @return
	 */
	public static int[][][] assignChannel(int[][][] inImg, int width, int height, int channelID, int[][] channelArr, int numOfChannels) {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				inImg[x][y][channelID] = channelArr[x][y];
			}
		}
		return inImg;
	}
			
	
}
