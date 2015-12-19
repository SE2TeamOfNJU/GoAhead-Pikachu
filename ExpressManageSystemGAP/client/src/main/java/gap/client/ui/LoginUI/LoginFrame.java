package gap.client.ui.LoginUI;

import gap.client.datacontroller.NetModule;
import gap.client.ui.BaseListener.MoveListener;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class LoginFrame extends JFrame {
	static LoginFrame loginFrame;
	LoginPanel loginPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

					LoginFrame frame = new LoginFrame();
					NetModule.connect();
					loginFrame = frame;

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public static void setVi(boolean bool) {
		loginFrame.setVisible(bool);
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(430, 330);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);

		loginPanel = new LoginPanel(this);

		getContentPane().setLayout(null);
		getContentPane().add(loginPanel);
		MoveListener movelistener = new MoveListener(this);
		addMouseListener(movelistener);
		addMouseMotionListener(movelistener);
	}
}
