package Home;

import JRPiCam.*;

public class cam {
    public static void main(String[] args) {
	light tplight = new light();
	String newIP = tplight.getIP();
	System.out.println(newIP);
	RPiCamera piCam = new RPiCamera("/home/pi/Documents/com/Home/Pictures");
	piCam.setToDefaults();
	BufferedImage pic1 = piCam.takeBufferedStill();
	
    }
}
