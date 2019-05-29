package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public Socket socket;

	public Client(InetAddress serverAddress, int serverPort) throws Exception {
		this.socket = new Socket(serverAddress, serverPort);
	}


	public void send(String message) throws IOException {
		PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
		out.println(message);
		out.flush();
	}
}