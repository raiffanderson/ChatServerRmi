import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

public class ChatImpl extends UnicastRemoteObject implements Chat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Chat client = null;
	private ArrayList<String> mensagens;

	public ChatImpl(String n) throws RemoteException {
		super();
		this.name = n;
		this.mensagens = new ArrayList<String>();
	}

	public String getName() throws RemoteException {
		return this.name;
	}

	public void setClient(Chat c) {
		client = c;
	}

	public Chat getClient() {
		return client;
	}

	public void send(String s) throws RemoteException {
		mensagens.add(s);
	}

	public ArrayList<String> lerMensagem() throws RemoteException {
		return mensagens;
	}

	public void enviarMensagem(String mensagem) throws RemoteException {
		mensagens.add(mensagem);
	}
}