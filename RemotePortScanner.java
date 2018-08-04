import java.net.*;
import java.io.*;

public class RemotePortScanner{

  public static void main(String[] args){

    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(in);

    String targetIp = "";
    int fromPort = 0;
    int toPort = 0;

    System.out.println("Please enter an IP address");

    try{
      targetIp = reader.readLine();
    }
    catch(Exception e){
      System.out.println(e.toString());
    }

    boolean isValid = false;

    while(!isValid){

      try{
        System.out.println("Please enter first port");
        String portString = reader.readLine();
        fromPort = Integer.parseInt(portString);

        if(fromPort >= 0 && toPort <= 65536){
          isValid = true;
        }
        else{
          System.out.println("Invalid Port Range");
        }
      }
      catch(NumberFormatException e1){
        System.out.println("please enter a number");
      }
      catch(Exception e2){
        System.out.println(e2.toString());
      }
    }

    isValid = false;

    while(!isValid){
      try{
        System.out.println("Enter ending port");
        String portString = reader.readLine();
        toPort = Integer.parseInt(portString);

        if(toPort >= 0 && toPort <= 65536){
          if( toPort >= fromPort){
            isValid = true;
          }
        }
        else{
          System.out.println("Invalid prot");
        }
      }
      catch(NumberFormatException e1){
        System.out.println("please enter a number");
      }
      catch(Exception e){
        System.out.println(e.toString());
      }
    }

    int port = fromPort;
    while( port >= fromPort && port <= toPort){
      try{
        Socket socket = new Socket(targetIp, port);
        System.out.println("Port " + port + " is in listening state!");
        socket.close();
      }
      catch(UnknownHostException e1){
        System.out.println(e1.toString());
      }
      catch(IOException e2){
        System.out.println(e2.toString());
      }
      catch(Exception e){
        System.out.println(e.toString());
      }
      port++;
    }

  }
}
