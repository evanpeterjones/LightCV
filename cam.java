package Home;

import JRPiCam.*;

public class cam {
    /** cam() 
     * 
     * constructor initiates all variables
     *
     */
    public cam() {
	light tplight = new light();
	String newIP = tplight.getIP();
	RPiCamera piCam = new RPiCamera("/home/pi/Documents/com/Home/Pictures");
	System.out.println(newIP);
	piCam.setToDefaults();
    }
    /** takeAndCompare()
     * 
     * Takes two photos and creates a double-dimensional array
     * that discerns the highest area of variance
     *
     */
    public int takeAndCompare() {
	BufferedImage pic1 = piCam.takeBufferedStill();
	BufferedImage pic2 = piCam.takeBufferedStill();
	int picCompData[][]= new int[pic2.getWidth()][pic2.getLength()];
	int width = 0;
	int height= 0;
	while (pic2.getHeight() > height)
	{
	    width = 0;
	    while (pic2.getWidth() > width)
	    {
		picCompData[height][width] = Math.abs((pic2.getRGB(height,width)
						       -pic1.getRGB(height,width)));
		width++;
	    }
	    height++;
	}
	return biggestQuadrant(picCompData);
    }

    public int biggestQuadrant(int[][] data) {
	
    }

    /** setLights()
     *
     * takes return value from takeAndCompare and sets lights based on 
     * quadrant of variance
     */
    
    public static void main(String[] args) {
	cam();
	
    }
}
