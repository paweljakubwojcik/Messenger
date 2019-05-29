package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import graphics.Window;

public class Client {
	public Socket socket;
	private Scanner scanner;

	public Client(InetAddress serverAddress, int serverPort) throws Exception {
		this.socket = new Socket(serverAddress, serverPort);
		this.scanner = new Scanner(System.in);
	}

	public void start() throws IOException {
		
	}

	public static void main(String[] args) throws Exception {
		new Window();
		
		
	}
	
	public void send(String message) throws IOException
	{
		PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
		out.println(message);
		out.flush();
	}
}