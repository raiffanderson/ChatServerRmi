import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class ChatServer {
	private static Scanner s;
	private static Registry registry;

	public static void main(String[] argv) {
		try {

			s = new Scanner(System.in);
			System.out.print("Grupo:");
			String name = s.nextLine().trim();

			ChatImpl server = new ChatImpl(name);

			String bind = "rmi://localhost:2020/ServerChat";
			registry = LocateRegistry.createRegistry(2020);
			Naming.rebind(bind, server);

			System.out.println("\nSERVIDOR " + name + " ONLINE!");
			System.out.println("Acesso em: " + bind);

		} catch (Exception e) {
			System.out.println("FALHA NO SERVIDOR: " + e);
		}
	}
}