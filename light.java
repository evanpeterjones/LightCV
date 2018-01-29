package Home;

import java.util.*;
import java.util.Scanner;
import java.io.*;

public class light {
    private String ip = "";
    private String def = "tplight";
    private String fileName = "ip.txt";
    private String off = def + " off " + ip;
    private String on = def + " on " + ip;

    public light() throws IOException {
	scan();
    }
    
    public void scan() throws IOException, FileNotFoundException {
	String args = def + " scan -t 1 > " + fileName;
        Process scan = Runtime.getRuntime().exec(args);
	parse(fileName);
    }

    public String parse(String file) throws FileNotFoundException {
	String ips = "";
	File ipad = new File(fileName);
	Scanner read = new Scanner(ipad);
	ips = read.nextLine();
	read.close();
	return ips.substring(0, 12);
    }

    public String getIP() {
	return ip;
    }

    public void on() throws IOException {
	Process turnOn = Runtime.getRuntime().exec(on);
    }

    public void off() throws IOException {
	Process turnOff = Runtime.getRuntime().exec(off);
    }

    //    public void onColor(enum val){
    //N	process turnOn = Runtime.getRuntime(___).start();
    //    }
	
    /*  public static void main(String[] args) throws IOException{
	scan();
	ip = parse(fileName);
	System.out.println(ip);
	}*/
}
