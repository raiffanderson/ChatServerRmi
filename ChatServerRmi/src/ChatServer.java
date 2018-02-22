import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
 
public class ChatServer {
public static void main (String[] argv) {
    try {
    	
	    	Scanner s=new Scanner(System.in);
	    	System.out.println("Nome Do usuario:");
	    	String name=s.nextLine().trim();
 
	    	Chat server = new Chat(name);	
 
//	    	Naming.rebind("rmi://localhost/PAD_Chat", server);
	    	Registry registry = LocateRegistry.createRegistry(2020);
	    	registry.bind("Chat", server);
	    	System.out.println("[System] Chat Remote Object is ready:");
 
	    	while(true){
	    		String msg=s.nextLine().trim();
	    		if (server.getClient()!=null){
	    			ChatInterface client=server.getClient();
	    			msg="["+server.getName()+"] "+msg;
	    			client.send(msg);
	    		}	
	    	}
 
    	}catch (Exception e) {
    		System.out.println("[System] Server failed: " + e);
    	}
	}
}