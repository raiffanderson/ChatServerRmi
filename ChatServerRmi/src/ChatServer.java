import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
 
public class ChatServer{
public static void main (String[] argv) {
    try {
    	
	    	Scanner s=new Scanner(System.in);
	    	System.out.print("Grupo:");
	    	String name=s.nextLine().trim();
 
	    	ChatImpl server = new ChatImpl(name);	
 
	    	Registry registry = LocateRegistry.createRegistry(2020);
//	    	registry.bind("rmi://localhost:1098/ServerChat", server);
	    	Naming.rebind("rmi://localhost:2020/ServerChat", server);

	    	
	    	System.out.println("SERVIDOR ONLINE!");
 
    	}catch (Exception e) {
    		System.out.println("FALHA NO SERVIDOR: " + e);
    	}
	}
}