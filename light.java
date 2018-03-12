package LightCV;

import java.util.*;
import java.io.*;
import org.json.*;
import com.google.gson.JsonObject;
import java.net.InetAddress;

public class light {
    private String ip = "";
    private int port = 9999;
    private boolean valid = false;
    private static final String LIGHT_INFO = "{\"system\" : {\"get_sysinfo\" : null}, \"emeter\" : {\"get_realtime\" : null}}";
    private static final String LIGHT_ON = "{\"system\":{\"set_relay_state\":{\"state\":1}}}";
    private static final String LIGHT_OFF = "{\"system\":{\"set_relay_state\":{\"state\":0}}}";
    private String newPackage = "";

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
      if (valid) {  System.out.println(sendPacket(LIGHT_INFO)); }
    }

    public light(String IP, int Port) throws IOException {
      this.ip = IP;
      this.port = Port;
      this.valid = checkIP(IP);
      if (!valid) { System.out.println("Error: the IP Address " + this.ip + ""); }
      if (valid) {  System.out.println(sendPacket(LIGHT_INFO)); }
    }

    /* checkIP()
    *
    *
    *
    */
    public boolean checkIP(String IP_CHECK) {
      JsonObject newPackage = sendPacket(IP_CHECK);
      if (newPackage.isEmpty()) { return false; }
      this.newPackage = null;
      return true;
    }

    public String sendPacket(String PACKAGE) {
      Socket socket = new Socket(getIP(), getPort());
      OutputStream output = socket.getOutputStream();
      output.write(encrypt(PACKAGE));
      InputStream in = socket.getInputStream();
      String data = decrypt(in);

    }

    public int[] encrypt(String VALUE) {
      int[] b = new int[VALUE.length()];
      int k = 171;
      int t = 0;
      for (int i = 0; i < VALUE.length(); i++) {
        t    = VALUE.charAt(i) ^ k;
        k    = pack[i];
        b[i] = val;
      }
      return b;
    }

    public String decrypt(InputStream INPUT) throws IOException {
      String test;
      int val = 0;
      int k = 171;
      int t = 0;
      while ((val = INPUT.read()) != -1) {
        test += (char) val ^ k;
        k    = val;
      }
      return test;
    }

    /*
    public void scan() throws IOException, FileNotFoundException {
      n
    }


    public void on() throws IOException {

    }

    public void off() throws IOException {
    	Process turnOff = Runtime.getRuntime().exec(off);
    }jsonobject java

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
      light l = new light("192.168.0.155");
      InetAddress ip = new InetAddress.getByName(l.getIP());
      System.out.println(ip.isReachable());
    }
}
