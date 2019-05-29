package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import client.Client;

public class Window extends JFrame implements ActionListener{

	JTextField field = new JTextField();
	JButton button = new JButton("send");
	String message = new String();
	Client client;
	
	private static final long serialVersionUID = 1L;

	public Window() throws UnknownHostException, Exception {
		
		client = new Client(InetAddress.getByName("127.0.0.1"), 6666);

		System.out.println("\r\nConnected to Server: " + client.socket.getInetAddress());

		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(0, 0, 800, 600);
		setVisible(true);

		field.setBounds(200, 200, 200, 50);
		add(field);
		
		button.setBounds(450, 200, 50, 50);
		button.addActionListener(this);
		add(button);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			 message=field.getText();
			 try {
				client.send(message);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	
	
}
