package client;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	public static void main(String[] args) {
		https://www.pegaxchange.com/2017/12/07/simple-tcp-ip-server-client-java/
		new Client();
	}

	public Client() {
		// "10.44.63.66"
		startConnection("127.0.0.1", 6666);
		String response = sendMessage("hello server");
		assertEquals("hello client", response);
	}

	public void startConnection(String ip, int port) {
		try {
			clientSocket = new Socket(ip, port);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String sendMessage(String msg) {
		out.println(msg);
		String resp;
		try {
			resp = in.readLine();
			return resp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void stopConnection() {
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
