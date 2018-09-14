import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GetDetail
{
   public static void main(String args[]) 
   {
      //String IP = "127.0.0.1:24";
	  try{
      //Iptohex(IP);
	  System.out.println("\n------------------------Victim PC Information------------------------\n");
	  getMacAddress();
	  getInternalAddress();
	  getAttackerName();
      }catch(SocketException e)
	  {
		  e.printStackTrace();
	  }catch(UnknownHostException e)
	  {
		  e.printStackTrace();
	  }
   }
   
/*   
   public static StringBuilder Iptohex(String IP)
   { 
	   String address[] = IP.replace(".",":").split(":");
	   StringBuilder str = new StringBuilder();
	   for(String s : address)
	   {
		  s = Integer.toHexString(Integer.parseInt(s));
          s=(s.length()<2)?"0"+s:s;
		  System.out.print(s);
		  str.append(s);
	   }
		return str;
    }
   
*/
   
   public static String getMacAddress() throws SocketException, UnknownHostException
   {
	   NetworkInterface netint = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
	   StringBuilder sb = new StringBuilder();
	   byte [] mac=netint.getHardwareAddress();
	   for (int i = 0; i < mac.length; i++)
	   {
		   //System.out.print(mac[i]+"");
		   sb.append(String.format("%02X%s", mac[i],(i < mac.length - 1) ? "-" : ""));
	   }
	   System.out.println("Mac Address : "+sb.toString());
	   return sb.toString();
   }

   
   
   public static String getInternalAddress()throws UnknownHostException
   {
	   String Address = InetAddress.getLocalHost().getHostAddress();
	   System.out.println("IP Address : "+Address);
	   return Address;
   }
   
   
      public static String getAttackerName()throws UnknownHostException
   {
	   String Name = InetAddress.getLocalHost().getHostName();
	   System.out.println("Host Name : "+Name);
	   return Name;
   }
   
   
   
   
   
   
}