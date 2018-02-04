package Home;

import JRPiCam.*;
import org.opencv.*;

public class cam {
    public static void main(String[] args) {
	light tplight = new light();
	String newIP = tplight.getIP();
	System.out.println(newIP);
	RPiCamera piCam = new RPiCamera("/home/pi/Documents/com/Home/Pictures");
	piCam.setToDefaults();
	BufferedImage pic1 = piCam.takeBufferedStill();
	System.loadLibrary(Core.NATIVE_LIBRARY);
	while (true)
	{
	    Picture a = new Picture(pic1);
	    Tonemap map = a.createTonemap();
	    
	    thread.sleep(1000);
	}
    }
}
