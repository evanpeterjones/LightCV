package Home;

import java.awt.image.BufferedImage;

import JRPiCam.*;

public class cam {
	private int picHeight = 0;
	private int picWidth = 0;
	private int QUADRANTS = 3;
	public light tplight;
    /** cam() 
     * 
     * constructor initiates all variables
     *
     */
	public cam() {
		tplight = new light();
		String newIP = tplight.getIP();
		RPiCamera piCam = new RPiCamera("/home/pi/Documents/com/Home/Pictures");
		System.out.println(newIP);
		piCam.setToDefaults();
		setli
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
		picHeight = pic2.getHeight();
		picWidth = pic2.getWidth();
		int picCompData[][]= new int[picWidth][picHeight];
		int width = 0;
		int height= 0;
		while (picHeight > height)
		{
			width = 0;
			while (picWidth > width)
			{
				picCompData[height][width] = Math.abs((pic2.getRGB(height,width)
									-pic1.getRGB(height,width)));
				width++;
			}
			height++;
		}
		return biggestQuadrant(picCompData);
	}
	//computes the largest variance of 6 quadrants
    public int biggestQuadrant(int[][] data) {
	//TODO
		int biggestVariance = 0;
		int biggestVarianceQuad = 0;
		//variances are the most variable of 3 vertical quadrants,
		//then of that quadrant, which portion of this quadrant has the most variance
		int[] variances = new int[3];
		for (int i = 0; i <= QUADRANTS/2; i++) {
			variances[i] = average(data, i);
		}
		for (int k : variances)
			if (variances[k] > biggestVariance)
				biggestVariance = variances[k];
				biggestVarianceQuad = k;
		for (int j = 0; j <= QUADRANTS/3; j++) {

		}
		//Computes and returns which quadrant includes the
		//most 'variance', i.e. the quadrant in which someone
		//is placed in the room. 1-3 take precedence, if 
		//there is variance, we brighten the lights by 20%
		//the returned quadrant is between 0 and 6, 0 being
		//no variance (always starting on 0)
		return biggestVariance;
	}
	//helper method for computing Variance within quadrants
	public int average(int[][] data, int quad){
		int avg = data[0][0];
		for (int i = 0; i < picWidth/3; i++) {
			for (int j = 0; j < picHeight/2; j++) {
				avg = (avg + data[i][j]) / 2;
			}
		}
		return avg;
	}
    /** setLights()
     *
     * takes return value from takeAndCompare and sets lights based on 
     * quadrant of variance
     */
    public void setLights(int quadrant) {
		if (quadrant <= 3) {
			tplight.on();
		} else {
			
		}
	}
    public static void main(String[] args) {
		cam camera = new cam();
		camera.2
    }
}
