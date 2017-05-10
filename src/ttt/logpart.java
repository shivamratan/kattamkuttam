package ttt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class logpart
{
	public void logip() {
		  try {
			  String content="\n";
		    InetAddress ip = InetAddress.getLocalHost();
		    System.out.println("Current IP address : " + ip.getHostAddress());
		    content+=ip.getHostAddress().toString()+"\n";
		    Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
		    while(networks.hasMoreElements()) {
		      NetworkInterface network = networks.nextElement();
		      byte[] mac = network.getHardwareAddress();

		      if(mac != null) {
		        System.out.print("Current MAC address : ");

		        StringBuilder sb = new StringBuilder();
		        for (int i = 0; i < mac.length; i++) {
		          sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		        }
		        System.out.println(sb.toString());
		        content+=sb.toString()+"\n";
		      }
		    }
		    if(checkupdate.checkinternetcon())
		    {
		    try
		    {
		    URL whatismyip = new URL("http://checkip.amazonaws.com");
		    BufferedReader in = new BufferedReader(new InputStreamReader(
		                    whatismyip.openStream()));

		    String ipaddr = in.readLine(); 
		    content+="\n\n \t ******************************\n\n \t public Ip Address ::"+ipaddr+"\n"; 
		    }
		    catch(Exception e)
		    {
		    	
		    }
		   }
		    new updatelog().updatelogs(content);
		    
		  //  mail.sendMail(content);
		  } catch (UnknownHostException e) {
		    e.printStackTrace();
		  } catch (SocketException e){
		    e.printStackTrace();
		  }
		}
}
