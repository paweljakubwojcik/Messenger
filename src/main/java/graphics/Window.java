package graphics;

import javax.swing.JFrame;

public class Window extends JFrame{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(0, 0, 800, 600);
		setVisible(true);
		
		
	}
	
}
