package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import graphics.Window;

public class Client {
	private Socket socket;
	private Scanner scanner;

	private Client(InetAddress serverAddress, int serverPort) throws Exception {
		this.socket = new Socket(serverAddress, serverPort);
		this.scanner = new Scanner(System.in);
	}

	private void start() throws IOException {
		String input;
		while (true) {
			input = scanner.nextLine();
			PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
			out.println(input);
			out.flush();
		}
	}

	public static void main(String[] args) throws Exception {
		new Window();
		
		Client client = new Client(InetAddress.getByName("145.239.82.150"), 6666);

		System.out.println("\r\nConnected to Server: " + client.socket.getInetAddress());
		client.start();
	}
}