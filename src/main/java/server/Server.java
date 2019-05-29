package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	public void start(int port) {
		String greeting = null;
		try {

			serverSocket = new ServerSocket(port);
			clientSocket = serverSocket.accept();
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			greeting = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if ("hello server".equals(greeting)) {
			out.println("hello client");
		} else {
			out.println("unrecognised greeting");
		}
	}

	public void stop() {
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();
		try {
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.start(6666);
	}

}
