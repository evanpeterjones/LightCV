package LightCV;

import java.util.*;
import java.io.*;
import org.json.simple.JSONObject;
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
      if (newPackage.isEmpty()) { return false; }
      this.newPackage = null;
      return true;
    }

    public String sendPacket(String package) {
      Socket socket = new Socket(getIP(), getPort());
      OutputStream output = socket.getOutputStream();
      output.write(encrypt(package));



    }

    public int[] encrypt(String value) {
      private int[] b = new int[value.length()];
      int k = 171;
      int t = 0;
      for (int i = 0; i < value.length(); i++) {
        t    = value.charAt(i) ^ k;
        k    = pack[i];
        b[i] = val;
      }
      return b;
    }

    public int[] decrypt(String value) {
      private int[] b = new int[value.length()];
      int k = 171;
      int t = 0;
      for (int i = 0; i < value.length(); i++) {
        b[i] = b[i] ^ k;
        k    = b[i];
      }
      return b;
    }

    /*
    public void scan() throws IOException, FileNotFoundException {
      n
    }
    */

    public void on() throws IOException {

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
      InetAddress ip = new InetAddress.getByName(getIP());
      System.out.println(ip.isReachable);
    }
}
