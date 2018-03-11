package LightCV;

import java.util.*;
import java.util.Scanner;
import java.io.*;
import org.json.simple.JSONObject;

public class light {
    private String ip = "";
    private int port = 9999;
    private boolean valid = false;
    private static final String LIGHT_INFO = "{\"system\" : {\"get_sysinfo\" : null}, \"emeter\" : {\"get_realtime\" : null}}";
    private newPackage = "";

    /** Constructors
    *
    * take values of IP and/or Port, and sets values accordingly
    * also checking if they're valid.
    *
    */
    public light(String IP) throws IOException {
      this.ip = IP;
      this.valid = checkIP(IP);
      if (!valid) { System.out.println("Error: the IP Address " + this.ip + ""); }
      if (valid) {  System.out.println(newPack()); }
    }

    public light(String IP, int Port) throws IOException {
      this.ip = IP;
      this.port = Port;
      this.valid = checkIP(IP);
      if (!valid) { System.out.println("Error: the IP Address " + this.ip + ""); }
      if (valid) {  System.out.println(newPack()); }
    }

    /* checkIP()
    *
    *
    *
    */
    public boolean checkIP(String ip_check) {
      JsonObject newPackage = sendPacket(ip_check);
      if (newPack.isEmpty()) { return true; }
      return false;
    }

    public String sendPacket(String package) {
      Socket socket = new Socket(getIP(), getPort());
      OutputStream output = socket.getOutputStream();
      output.write(encrypt(package));

    }

    public int[] encrypt(String value) {
      private int[] pack = new int[value.length()];
      int k = 171;
      int t = 0;
      for (int i = 0; i < value.length(); i++) {
        t     = value.charAt(i) ^ obfusc;
        obfusc  = pack[i];
        pack[i] = val;
      }
      return
    }
    public void scan() throws IOException, FileNotFoundException {

    }

    public void on() throws IOException {
	    Process turnOn = Runtime.getRuntime().exec(on);
    }

    public void off() throws IOException {
    	Process turnOff = Runtime.getRuntime().exec(off);
    }

    public void dim() throws IOException {
    	Process turnOff = Runtime.getRuntime().exec(dim);
    }

    /** Getters and Setters
    *
    * sets and gets IP and Port
    *
    */
    public String getIP() { return ip; }
    public void setIP(String IP) { this.ip = IP; }
    public void setPort(int thisPort) { this.port = thisPort; }
    public int getPort() { return port; }

    /** main
    *
    */
    public static void main(String[] args) {
      System.out.println(encrypt(171).);
    }
}
